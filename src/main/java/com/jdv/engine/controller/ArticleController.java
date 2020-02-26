package com.jdv.engine.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdv.engine.dto.ArticleDTO;
import com.jdv.engine.service.ArticleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/article")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/save")
    public Integer saveArticle(ArticleDTO articleDTO) {
        return articleService.saveArticle(articleDTO);
    }

    @GetMapping("/{id}")
    public ArticleDTO getArticleById(@PathVariable Integer id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/all")
    public List<ArticleDTO> getAllArticles() {
        return articleService.getAllArticles();
    }
}
