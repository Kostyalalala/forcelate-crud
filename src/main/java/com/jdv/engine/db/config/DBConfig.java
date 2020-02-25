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
        ids.add(userRepository.saveAndFlush(User.builder().name("Tom").age(21).build()).getId());
        ids.add(userRepository.saveAndFlush(User.builder().name("John").age(19).build()).getId());
        ids.add(userRepository.saveAndFlush(User.builder().name("Anna").age(29).build()).getId());
        ids.add(userRepository.saveAndFlush(User.builder().name("Jerry").age(11).build()).getId());
        ids.add(userRepository.saveAndFlush(User.builder().name("Maria").age(43).build()).getId());
    }

    private void createArticles() {
        ids.stream().forEach(id -> {
            articleRepository.save(Article.builder().text("some text").color(Color.GREEN).userId(1).build());
        });
    }
}