package com.jdv.engine.service;

import static com.jdv.engine.dto.Transfromer.ArticleDTOToEntity;

import org.springframework.stereotype.Service;

import com.jdv.engine.db.repository.ArticleRepository;
import com.jdv.engine.dto.ArticleDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public void saveArticle(ArticleDTO articleDTO) {
        repository.save(ArticleDTOToEntity(articleDTO));
    }
}
