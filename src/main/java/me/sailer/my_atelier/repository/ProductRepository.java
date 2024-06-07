package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
