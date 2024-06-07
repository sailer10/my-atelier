package me.sailer.my_atelier.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    private String name;

    //(mappedBy = "productTag", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productTag")
    private Set<ProductTagMapping> productTagMappings = new HashSet<>();

}
