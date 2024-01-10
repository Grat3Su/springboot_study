package com.example.springbootdeveloper.service;

import com.example.springbootdeveloper.domain.Article;
import com.example.springbootdeveloper.dto.AddArticleRequest;
import com.example.springbootdeveloper.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service // 빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    //블로그 글 추가
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    //Article 테이블의 모든 것을 불러옴
    public List<Article> findAll(){
        return blogRepository.findAll();
    }
}
