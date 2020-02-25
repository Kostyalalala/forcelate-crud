package com.jdv.engine.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdv.engine.db.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
