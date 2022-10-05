package com.webservice.boot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러, 해당 어노테이션을 사용하면 컨트롤러의 메서드마다 @ResponseBody를 선언하지 않아도 된다.
public class HelloController {
    @GetMapping("/hello") // 메서드를 HTTP Method중 Get 요청을 받을 수 있는 API로 만들어주는 어노테이션
    public String Hello() {
        return "hello2";
    }
}
