package com.webservice.boot.web;

import com.webservice.boot.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // JSON을 반환하는 컨트롤러, 해당 어노테이션을 사용하면 컨트롤러의 메서드마다 @ResponseBody를 선언하지 않아도 된다.
public class HelloController {
    @GetMapping("/hello") // 메서드를 HTTP Method중 Get 요청을 받을 수 있는 API로 만들어주는 어노테이션
    public String Hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto getHelloDto(@RequestParam("name") String name,
                                        @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
