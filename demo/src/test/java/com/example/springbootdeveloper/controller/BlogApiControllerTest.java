package com.example.springbootdeveloper.controller;

import com.example.springbootdeveloper.domain.Article;
import com.example.springbootdeveloper.dto.AddArticleRequest;
import com.example.springbootdeveloper.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.hamcrest.CoreMatchers;

import java.awt.*;
import java.util.List;

import static org.springframework.http.RequestEntity.post;


@SpringBootTest // test용 앱 컨텍스트
@AutoConfigureMockMvc // MockMvc 생성 및 자동 구성
class BlogApiControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    WebApplicationContext context;

    @Autowired
    BlogRepository blogRepository;

    @BeforeEach // 테스트 실행 전 실행하는 메소드
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        blogRepository.deleteAll();
    }

    @DisplayName("addArticle : 블로그 글 추가에 성공한다.")
    @Test
    public void addArticle() throws Exception {
        //given - 블로그 글 추가에 필요한 요청 객체를 만든다.
        final String url = "/api/articles";
        final String title = "title";
        final String content = "content";
        final AddArticleRequest userRequest = new AddArticleRequest(title, content);

        //객체 JSON으로 직렬화
        final String requestBody = objectMapper.writeValueAsString(userRequest);

        //when - 블로그 글 추가 API에 요청을 보낸다. 이 때 요청 타입은 JSON 이며 given 절에서 미리 만들어둔 객체를 요청 본문으로 함께 보낸다.
        //설정한 내용을 바탕으로 요청 전송
        ResultActions result = mockMvc.perform((RequestBuilder) post(url).contentType(MediaType.APPLICATION_JSON_VALUE)).content(requestBody);

        //then - 응답 코드가 201 created인지 확인한다. 블로그를 전체 조회해 크기가 1인지 확인하고 실제로 저장된 데이터와 요청값을 비교한다.
        result.andExpect(status().isCreated());
        List<Article> articles = blogRepository.findAll();

        assertThat(articles.size()).isEqualTo(1); // 크기가 1이지 검증
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
        assertThat(articles.get(0).getTitle()).isEqualTo(content);



    }

}