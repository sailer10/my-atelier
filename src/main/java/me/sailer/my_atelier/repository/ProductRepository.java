package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {



    public List<Product> findByCategory(Category category);
}
