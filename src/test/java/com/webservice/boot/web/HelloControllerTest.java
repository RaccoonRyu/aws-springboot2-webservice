package com.webservice.boot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class) // 테스트를 진행할 때 JUnit에 내장된 실행자 외 다른 실행자를 실행(여기서는 SpringRunner). 스프링부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) // 웹 MVC 테스트를 지원하는 어노테이션. 해당 어노테이션 선언시 컨트롤러 계열의 어노테이션만 사용할 수 있다. (서비스, 레포 등은 불가)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc; // 웹 API를 테스트할 때 사용. HTTP 메서드(GET, POST 등)에 대한 API를 테스트할 수 있다.

    @Test
    public void helloReturn() throws Exception {
        String hello = "hello";

        mockMvc.perform(get("/hello")) // MockMvc를 통해 입력한 주소로 HTTP GET 요청을함. 메서드 체이닝 사용 가능
                .andExpect(status().isOk()) // mockMvc.perform의 결과 중 HTTP Header의 Status(200, 400, 500 등)를 검증한다. 여기서는 OK(200인지 아닌지)를 검증한다.
                .andExpect(content().string(hello)); // mockMvc.perform의 결과 중 응답 본문의 내용을 검증한다. 여기서는 응답 본문의 리턴값이 "hello"인지 아닌지를 검증한다.
    }

    @Test
    public void helloDtoReturn() throws Exception {
        String name = "hello";
        int amount = 1000;

        mockMvc.perform(get("/hello/dto")
                    .param("name", name) // API를 테스트할 때 사용될 요청 파라미터를 설정(값은 String만 허용되어 타 자료형은 형변환이 필요)
                    .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name))) // Json 응답값을 필드별로 검증할 수 있는 메서드. $를 기준으로 검증할 필드명을 명시
                    .andExpect(jsonPath("$.amount", is(amount)));

    }
}
