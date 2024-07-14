package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.ProductTagMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTagMappingRepository extends JpaRepository<ProductTagMapping, Long> {
}
