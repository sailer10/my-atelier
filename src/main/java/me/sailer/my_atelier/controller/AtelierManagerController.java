package me.sailer.my_atelier.controller;

import lombok.RequiredArgsConstructor;
import me.sailer.my_atelier.service.AtelierManagerService;
import me.sailer.my_atelier.util.Urls;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(Urls.API_ATELIER + Urls.URL_MASTER)
public class AtelierManagerController {

    private final AtelierManagerService managerService;


}
