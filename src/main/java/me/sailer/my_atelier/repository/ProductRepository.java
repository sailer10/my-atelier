package me.sailer.my_atelier.repository;

import me.sailer.my_atelier.domain.Product;
import me.sailer.my_atelier.dto.product.ProductListViewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {



    // todo: 삭제
    @Query(value = """
            select distinct P from Product as P
            left outer join fetch P.productTagMappings PTM
            left outer join fetch PTM.productTag T
            left join fetch P.atelier A
            left join fetch P.category C
            where C.categoryNo = :categoryNo
            """)
    public List<Product> findByCategory(@Param("categoryNo") Byte categoryNo);

    /**
     * JPQL 에 DTO 받는법: 해당 DTO 를 new 로 SELECT 하고 생성자를 적절히 생성해준다
     * 그 생성자에 맞는 파라미터를 new DTO() 에서 괄호 안에 넣어준다. 그러면 마법같이 생성됨.
     * 중요한점. GROUP_CONCAT() MYSQL 함수를 사용하려면 GROUP BY 를 같이 사용해서 어느것을 기준으로 그루핑할지 적어줘야함!!
     * @param categoryNo
     * @return 해당하는 카테고리 번호에 맞는 상품 리스트 리턴
     */
    @Query(value = """
             select new me.sailer.my_atelier.dto.product.ProductListViewResponse(
                P.productNo, P.name, P.price, P.isDiscount, P.discountPrice,
                A.name, PI.imageSrc,
                COALESCE(GROUP_CONCAT(DISTINCT PT.name), '') as tagStr)
             from Product P
             left join P.productTagMappings PTM
             left join PTM.productTag PT
             left join P.atelier A
             left join P.category C
             left join fetch ProductImage PI on PI.product = P AND PI.isMain = true
             where C.categoryNo = :categoryNo
             group by P.productNo
            """)
    public List<ProductListViewResponse> findProductListByCategory(@Param("categoryNo") Byte categoryNo);


}