package com.jdv.engine.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdv.engine.db.model.User;
import com.jdv.engine.db.model.enums.Color;
import com.jdv.engine.db.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserService {
    
    private final UserRepository repository;

    public void saveUser(User user) {
        repository.save(user);
    }

    public List<User> getUsersByAge(Integer age) {
        return repository.getUsersByAge(age);
    }

    public List<User> getUsersByArticleColor(Color color) {
        return repository.findUsersByArticleColor(color.toString());
    }

    public List<String> getDistinctUsersWithArticles() {
        return repository.getDistinctUsersWithArticles();
    }
}
