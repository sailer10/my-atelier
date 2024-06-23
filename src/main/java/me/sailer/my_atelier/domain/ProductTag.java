package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "PRODUCT_TAG")
public class ProductTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Integer tagNo;
    private String name;

    @OneToMany(mappedBy = "productTag")
    @Column
    private Set<ProductTagMapping> productTagMappings = new HashSet<>();
}
