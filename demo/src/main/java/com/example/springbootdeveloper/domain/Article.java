package com.example.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.metrics.buffering.StartupTimeline;

@Entity // 엔티티 지정
@Table(name = "test_table")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 접근 제어가 protect
@AllArgsConstructor
public class Article {
    @Id // id 필드 기본으로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1 증가
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "title", nullable = false) // title이라는 notnull 컬롬과 매핑
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder//빌더 패턴으로 객체 생성
    private Article(String title, String content){
        this.title = title;
        this.content = content;
    }
}
