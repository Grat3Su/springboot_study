package com.example.springbootdeveloper.repository;

import com.example.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> {//pk타입 long을 인수로 넣는다.
}
