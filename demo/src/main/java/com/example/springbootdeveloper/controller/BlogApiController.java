package com.example.springbootdeveloper.controller;

import com.example.springbootdeveloper.domain.Article;
import com.example.springbootdeveloper.dto.AddArticleRequest;
import com.example.springbootdeveloper.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController // http response body에 객체 데이터를 json 형식으로 반환
public class BlogApiController {
    private final BlogService blogService;
    
    @PostMapping(value = "/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){//요청 본문값 매핑
        Article saveArticle = blogService.save(request);
        System.out.println("why!!!!!!!!!!!!!!!");
        // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED).body(saveArticle);
    }

    @GetMapping(value = "/api")
    public ResponseEntity<Article> getArticle(){
        System.out.println("what");
        return null;
    }
}
