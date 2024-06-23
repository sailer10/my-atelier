package me.sailer.my_atelier.service;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.domain.ProductTag;
import me.sailer.my_atelier.repository.ProductTagRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductTagService {

    private final ProductTagRepository tagRepository;

    public ProductTag findById(Integer id) {
        return tagRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("잘못된 테그번호!"));
    }


}
