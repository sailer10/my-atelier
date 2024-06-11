package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int remaining;  // 재고

    // deafult 값 설정
    @Column(name = "is_discounted", nullable = true)
    private boolean isDiscounted = false;

    @Column(nullable = true)
    private int discountedPrice;

    // @ForeignKey(ConstraintMode.NO_CONSTRAINT) 를 통해 FK 제약조건을 없앤다 (즉 외래키가 아니게 됨)
    // 현업에선 개발및 테스트 편의성을 위해 외래키를 잘 안쓴다고 함
    // todo :nullable=false -> joinColumn 속성에 추가해야 함. 테스트 한 이후에...
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Seller seller;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @ManyToOne  // FetchType.EAGER 로 default 설정. LAZY로 하면 해당 객체가 사용되기 전까지 로딩되지 않고 프록시객체로 대체되는데
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @Column(name = "tags")
    private Set<ProductTagMapping> productTagMappings = new HashSet<>();

    // todo: 이미지는 빼서 따로 저장하는게 맞는듯
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @Column(name = "images")
    private List<ProductImage> imageList = new ArrayList<>();



    @Builder
    public Product(String name, int price, int remaining, Category category) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.category = category;
    }

    public void update(String name, int price, int remaining, boolean isDiscounted,
                       int discountedPrice, Category category) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
        this.isDiscounted = isDiscounted;
        this.discountedPrice = discountedPrice;
        this.category = category;
    }
}
