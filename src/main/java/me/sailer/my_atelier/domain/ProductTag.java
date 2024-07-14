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
    @Column(updatable = false, name = "tag_no")
    private Integer tagNo;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "productTag")
    private Set<ProductTagMapping> product_tag_mappings = new HashSet<>();
}
