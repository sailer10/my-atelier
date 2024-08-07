package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.ProductTag;
import me.sailer.my_atelier.domain.ProductTagMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProductTagRepository extends JpaRepository<ProductTag, Integer> {

}
