package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = true)
    private int discountedPrice;

    @Column(nullable = false)
    private int remaining;  // 재고

    // @ForeignKey(ConstraintMode.NO_CONSTRAINT) 를 통해 FK 제약조건을 없앤다 (즉 외래키가 아니게 됨)
    // 현업에선 개발및 테스트 편의성을 위해 외래키를 잘 안쓴다고 함
    // todo :nullable=false -> joinColumn 속성에 추가해야 함. 테스트 한 이후에...
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Seller seller;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @Column(name = "tags")
    private Set<ProductTagMapping> productTagMappings = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @Column(name = "images")
    private List<ProductImage> imageList = new ArrayList<>();

    @CreatedDate
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "modifiedAt")
    private LocalDateTime modifiedAt;

    @Builder
    public Product(String name, int price, int remaining, Category category) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.category = category;
    }

    public void update(String name, int price, int remaining) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
    }
}
