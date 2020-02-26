package com.jdv.engine.service;

import static com.jdv.engine.dto.Transfromer.UserDTOToEntity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jdv.engine.db.repository.UserRepository;
import com.jdv.engine.dto.Transfromer;
import com.jdv.engine.dto.UserDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserService {

    private final UserRepository repository;

    public Integer saveUser(UserDTO userDTO) {
        return repository.save(UserDTOToEntity(userDTO)).getId();
    }

    public List<UserDTO> getUsersByAge(Integer age) {
        return repository.getUsersWithOlderAge(age)
            .stream()
            .map(Transfromer::UserEntityToDTO)
            .collect(Collectors.toList());
    }

    public List<UserDTO> getUsersByArticleColor(String color) {
        return repository.findUsersByArticleColor(color.toUpperCase())
            .stream()
            .map(Transfromer::UserEntityToDTO)
            .collect(Collectors.toList());
    }

    public List<String> getDistinctUsersWithArticles() {
        return repository.getDistinctUsersWithArticles();
    }
}
