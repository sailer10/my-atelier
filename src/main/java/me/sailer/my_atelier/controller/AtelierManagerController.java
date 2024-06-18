package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.service.AtelierManagerService;
import me.sailer.my_atelier.statics.StaticUrls;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(StaticUrls.API_ATELIER + StaticUrls.MASTER)
public class AtelierManagerController {

    private final AtelierManagerService managerService;

    @PostMapping

    @GetMapping

}
