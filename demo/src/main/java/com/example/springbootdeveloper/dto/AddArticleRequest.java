package com.example.springbootdeveloper.dto;

import com.example.springbootdeveloper.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    String title;
    String content;

    public Article toEntity(){
        return Article.builder().title(title).content(content).build();
    }
}
