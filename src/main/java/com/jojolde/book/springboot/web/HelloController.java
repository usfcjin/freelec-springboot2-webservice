package com.jojolde.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줍니다.
// @responseBody를 각 메소드마다 선언했던것을 한버에 사용할수 있게 해줍니다.
public class HelloController {

    @GetMapping("/hello")
    // HTTP Method인 Get의 요청을 받을수 있는 API를 만들어 줍니다.
    // 예전에는 @RequsetMapping(method = RequestMethod.GET)으로 사용
    // 현재 /hello로 요청하는 문자열이 오면 hello를 반환하는 기능을 가지게 되었습니다.
    public String hello() {
        return "hello";
    }
}
