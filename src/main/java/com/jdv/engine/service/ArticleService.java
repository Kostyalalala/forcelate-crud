package com.jdv.engine.service;

import org.springframework.stereotype.Service;

import com.jdv.engine.db.model.Article;
import com.jdv.engine.db.repository.ArticleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public void saveArticle(Article article) {
        repository.save(article);
    }
}
