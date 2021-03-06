package com.jojolde.book.springboot.web;

import com.jojolde.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

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

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
    // 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션입니다
    // 여기선튼 외부에서 name(@RequestParam("name")) 이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하게 됩니다.
        return new HelloResponseDto(name, amount);
    }
}
