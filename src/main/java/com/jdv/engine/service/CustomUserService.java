package com.jdv.engine.service;

import static com.jdv.engine.dto.Transfromer.UserDTOToEntity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jdv.engine.db.model.enums.Color;
import com.jdv.engine.db.repository.UserRepository;
import com.jdv.engine.dto.Transfromer;
import com.jdv.engine.dto.UserDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserService {

    private final UserRepository repository;

    public void saveUser(UserDTO userDTO) {
        repository.save(UserDTOToEntity(userDTO));
    }

    public List<UserDTO> getUsersByAge(Integer age) {
        return repository.getUsersWithOlderAge(age)
            .stream()
            .map(Transfromer::UserEntityToDTO)
            .collect(Collectors.toList());
    }

    public List<UserDTO> getUsersByArticleColor(Color color) {
        return repository.findUsersByArticleColor(color.toString())
            .stream()
            .map(Transfromer::UserEntityToDTO)
            .collect(Collectors.toList());
    }

    public List<String> getDistinctUsersWithArticles() {
        return repository.getDistinctUsersWithArticles();
    }
}
