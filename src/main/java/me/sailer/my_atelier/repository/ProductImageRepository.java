package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    @Query(value = """
            select PI
            from ProductImage PI
            right join Product P on P = PI.product
            where P.productNo = :productNo
            """)
    public List<ProductImage> findByProduct_productNo(Long productNo);
}