package com.jdv.engine.db.config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.jdv.engine.db.model.Article;
import com.jdv.engine.db.model.User;
import com.jdv.engine.db.model.enums.Color;
import com.jdv.engine.db.repository.ArticleRepository;
import com.jdv.engine.db.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DBConfig {

    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    private List<Integer> ids = new ArrayList<>();

    @PostConstruct
    private void dbInit() {
        createUsers();
        createArticles();
    }

    private void createUsers() {
        ids.add(userRepository.save(User.builder().name("Tom").age(21).build()).getId());
        ids.add(userRepository.save(User.builder().name("John").age(19).build()).getId());
        ids.add(userRepository.save(User.builder().name("John").age(16).build()).getId());
        ids.add(userRepository.save(User.builder().name("Anna").age(29).build()).getId());
        ids.add(userRepository.save(User.builder().name("Jerry").age(11).build()).getId());
        ids.add(userRepository.save(User.builder().name("Maria").age(43).build()).getId());
    }

    private void createArticles() {
        ids.stream().forEach(id -> articleRepository.save(getArticles(id)));
    }

    private List<Article> getArticles(Integer userId) {
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            articles.add(getRandomArticle(userId));
        }
        return articles;

    }

    private Article getRandomArticle(Integer userId) {
        return Article.builder().text("some text").color(getColor(userId)).userId(userId).build();
    }

    private Color getColor(Integer userId) {
        return (userId % 2 == 0) ? Color.GREEN : Color.RED;
    }
}