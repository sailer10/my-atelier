package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Byte> {

}
