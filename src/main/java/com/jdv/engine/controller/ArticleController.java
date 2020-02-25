package com.jdv.engine.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdv.engine.dto.ArticleDTO;
import com.jdv.engine.service.ArticleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/save")
    public void saveArticle(ArticleDTO articleDTO) {
        articleService.saveArticle(articleDTO);
    }
}
