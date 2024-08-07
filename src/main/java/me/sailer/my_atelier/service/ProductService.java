package me.sailer.my_atelier.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sailer.my_atelier.domain.*;
import me.sailer.my_atelier.dto.product.AddProductRequest;
import me.sailer.my_atelier.dto.product.ProductDetailResponse;
import me.sailer.my_atelier.dto.product.ProductListViewResponse;
import me.sailer.my_atelier.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    // service
    private final AtelierService atelierService;
    private final CategoryService categoryService;
    private final ProductTagService tagService;

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾는 상품이 없습니다"));
    }

    public List<Product> findByCategory(Byte id) {
        return productRepository.findByCategory(id);
    }

    public List<ProductListViewResponse> findProductListByCategory(Byte categoryNo) {
        return productRepository.findProductListByCategory(categoryNo);
    }

    public ProductDetailResponse findByid(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("찾는 상품이 없습니다"));
        return new ProductDetailResponse(product);
    }

    public Product saveProduct(AddProductRequest request) {
        // 캐싱되있거나 새로 조회한 카테고리 가져옴
        Category category = categoryService.findById(request.getCategory_no());
        Atelier atelier = atelierService.findById(request.getAtelier_no());

        // todo: 카테고리나 공방을 찾아서 없으면 에러 리턴해야됨. 각각의 서비스에선 에러 반환하는데 이경우 나와서 어떻게 될지 모르겟음.
        return productRepository.save(request.toEntity(category, atelier));
    }

    // 상품에 태그 추가
    public void addTagToProduct(Product product, Integer tagNo) {
        ProductTag tag = tagService.findById(tagNo);

        ProductTagMapping productTagMapping = ProductTagMapping.builder().
                product(product).productTag(tag).build();


    }



}
