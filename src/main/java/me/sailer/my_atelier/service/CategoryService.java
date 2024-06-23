package me.sailer.my_atelier.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sailer.my_atelier.domain.Category;
import me.sailer.my_atelier.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final Map<Byte, Category> categoryCache = new ConcurrentHashMap<>();

    public Category findById(Byte id) {
        // 람다식으로 카테고리가 있으면 캐싱된 카테고리반환해주고, 없으면 리포지토리를 통해 찾아서 맵에 넣고 반환.
        Category category;
        category = categoryCache.computeIfAbsent(id, this::loadCategory);

        return category;

//        return categoryCache.computeIfAbsent(id, this::loadCategory);
    }

    public Category loadCategory(Byte id) {
        log.debug("id 값 들어오는지 테스트" + id);
        return categoryRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("카테고리 번호 지정 오류"));
    }

}