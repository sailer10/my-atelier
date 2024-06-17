package me.sailer.my_atelier.domain;

import jakarta.persistence.*;

@Entity
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productImageNo;

    @Column(name = "image_url")
    private String imageUrl;    // 클라우드 스토리지 경로


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_no", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Product product;


}
