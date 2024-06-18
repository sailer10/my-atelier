package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import me.sailer.my_atelier.domain.base.BaseTime;
import me.sailer.my_atelier.enums.ProductStatus;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Product extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no", updatable = false)
    private Long productNo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @Column(name = "tags")
    private final Set<ProductTagMapping> productTagMappings = new HashSet<>();

    @ManyToOne  // FetchType.EAGER 로 default 설정 되어있음.
                // LAZY로 하면 해당 객체가 사용되기 전까지 로딩되지 않고 프록시객체로 대체되는데
    @JoinColumn(name = "category_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Category category;

    @ManyToOne
    @JoinColumn(name = "atelier_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Atelier atelier;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int remaining;  // 재고

    @Column(name = "is_discounted", nullable = true)
    private final boolean isDiscounted = false; // deafult 값 설정

    @Column(nullable = true)
    private int discountPrice;

    private String description;

    private ProductStatus status;

//    @Builder
//    public Product(String name, int price, int remaining,
//                   boolean isDiscounted, int discountedPrice, Category category) {
//        this.name = name;
//        this.price = price;
//        this.remaining = remaining;
//        this.isDiscounted = isDiscounted;
//        this.discountedPrice = discountedPrice;
//        this.category = category;
//    }
//
//    public void update(String name, int price, int remaining, boolean isDiscounted,
//                       int discountPrice, Category category) {
//        this.name = name;
//        this.price = price;
//        this.remaining = remaining;
//        this.isDiscounted = isDiscounted;
//        this.discountPrice = discountPrice;
//        this.categoryNo = category;
//        // 생성 및 수정시각이 처음 상품 등록시에는 자동으로 적용 되지만, 수정시간은 직접 설정해야함
//        this.setModifiedDateTime(LocalDateTime.now());
//    }
}