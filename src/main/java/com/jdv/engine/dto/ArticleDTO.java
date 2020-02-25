package com.jdv.engine.dto;

import com.jdv.engine.db.model.enums.Color;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO {

    private String text;
    private Color color;
    private Integer userId;
}
