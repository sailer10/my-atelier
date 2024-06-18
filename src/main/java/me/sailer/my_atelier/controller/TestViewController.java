package me.sailer.my_atelier.controller;

import me.sailer.my_atelier.statics.StaticUrls;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestViewController {

    @GetMapping("/image") // 구글 클라우드 스토리지 이미지 가져오기 테스트
    public String getImage(Model model) {
        model.addAttribute("imageUrl", StaticUrls.TEST_IAMGE_URL);

        return "test/image";
    }
}