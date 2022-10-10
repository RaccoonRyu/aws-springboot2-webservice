package com.webservice.boot.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 클래스에 선언된 모든 지역 변수의 getter 메서드를 생성
@RequiredArgsConstructor // 선언된 모든 final 지역 변수가 포함된 생성자를 생성 (final이 아닌 지역 변수는 포함하지 않음)
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
