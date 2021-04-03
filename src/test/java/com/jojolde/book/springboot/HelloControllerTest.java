package com.jojolde.book.springboot;

import com.jojolde.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
// 테스트를 진행할때 JUnit에 내장된 실행자외에 다른 실행자를 실행해줍니다.
// 여기서는 SpringRunner라는 스프링 실행자를 사용합니다.
// 즉. 스프링 부트 테스트와 JUnit 사이에 연결자 역확을 합니다.
@WebMvcTest(controllers = HelloController.class)
// 여러 스프링 어노테이션중, Web(spring MVC)에 집중할 수 있는 어노테이션 입니다.
// 선언할 경우  @Controller, @ControllerAdvice 등을 사용할 수 있습니다.
// 단. @Service, @Component, @Repository 등은 사용할 수 있습니다.
// 여기서는 컨트롤러만 사용하게 때문에 선언합니다.
public class HelloControllerTest {

    @Autowired
    // 스프링이 관리하는 빈(bean)을 주입 받습니다.
    private MockMvc mvc;
    // 웹 API를 테스트 할때 사용합니다.
    // 스프링 MVC 테스트의 시작점입니다.
    // 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있습니다.

    @Test
    public void hello_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 합니다.
                // 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있습니다.
                .andExpect(status().isOk())
                // mvc.perform의 결과를 검증합니다.
                // HTTP Header의 Status를 검증합니다.
                // 우리가 흔희 알고 있는 200, 404, 500 등의 상태를 검증합니다.
                // 여기서 OK 즉, 200인지 아닌지 검증합니다.
                .andExpect(content().string(hello));
                // mvc.perform의 결과를 검증합니다.
                // 응답 본문의 내용을 검증합니다.
                // Controller 에서 "hello"를 리턴하기 대문에 이 값이 맞는지 검증합니다.

    }
}
