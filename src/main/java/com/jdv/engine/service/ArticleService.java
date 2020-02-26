package com.jdv.engine.service;

import static com.jdv.engine.dto.Transfromer.ArticleDTOToEntity;
import static com.jdv.engine.dto.Transfromer.ArticleToDTO;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jdv.engine.db.repository.ArticleRepository;
import com.jdv.engine.dto.ArticleDTO;
import com.jdv.engine.dto.Transfromer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository repository;

    public Integer saveArticle(ArticleDTO articleDTO) {
        return repository.save(ArticleDTOToEntity(articleDTO)).getId();
    }

    public ArticleDTO getArticleById(Integer id) {
        return ArticleToDTO(repository.findOne(id));
    }
    
    public List<ArticleDTO> getAllArticles(){
        return repository.findAll().stream().map(Transfromer::ArticleToDTO).collect(Collectors.toList());
    }
}
