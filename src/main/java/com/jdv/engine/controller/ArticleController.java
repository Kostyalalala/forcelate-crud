package com.jdv.engine.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdv.engine.db.model.Article;
import com.jdv.engine.service.ArticleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/save")
    public void saveArticle(Article article) {
        articleService.saveArticle(article);
    }
}
