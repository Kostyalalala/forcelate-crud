package com.jdv.engine.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jdv.engine.db.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> getUsersByAge(Integer age);

    @Query(
            value = "SELECT u FROM users u LEFT JOIN articles a ON a.id = u.id WHERE a.color =:color",
            nativeQuery = true
    )
    public List<User> findUsersByArticleColor(@Param("color") String color);

    @Query(
            value = "SELECT DISTINCT(u.name) FROM users u LEFT JOIN articles a ON a.userId = u.id WHERE COUNT(u.articles) > 3",
            nativeQuery = true
    )
    public List<String> getDistinctUsersWithArticles();
}
