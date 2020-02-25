package com.jdv.engine.dto;

import com.jdv.engine.db.model.Article;
import com.jdv.engine.db.model.User;

public class Transfromer {
    public static ArticleDTO ArticleToDTO(Article article) {
        return ArticleDTO.builder()
            .text(article.getText())
            .color(article.getColor())
            .userId(article.getUserId())
            .build();
    }

    public static Article ArticleDTOToEntity(ArticleDTO articleDTO) {
        return Article.builder()
            .text(articleDTO.getText())
            .color(articleDTO.getColor())
            .userId(articleDTO.getUserId())
            .build();
    }

    public static User UserDTOToEntity(UserDTO userDTO) {
        return User.builder().name(userDTO.getName()).age(userDTO.getAge()).build();
    }

    public static UserDTO UserEntityToDTO(User user) {
        return UserDTO.builder().name(user.getName()).age(user.getAge()).build();
    }

}
