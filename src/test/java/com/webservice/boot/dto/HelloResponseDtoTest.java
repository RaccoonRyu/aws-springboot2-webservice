package com.webservice.boot.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat; // 테스트 검증 라이브러리로 Junit 대신 assertj 사용
// assertj : Junit과 달리 추가적인 라이브러리가 필요하지 않고 자동완성이 더 확실하게 지원되는 테스트 검증 라이브러리

public class HelloResponseDtoTest {

    @Test
    public void lombokFunctionTest() {
<<<<<<< HEAD
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount); // 생성자로 HelloResponseDto 생성

        // then
        // assertThat : assertj의 검증 메서드. 검증하고 싶은 대상을 인자로 받음. 메서드 체이닝 지원됨
        // isEqualTo : assertj의 동등 비교 메서드. assertThat에 있는 값과 isEqualTo의 값을 비교해 같을 때만 테스트 성공
=======
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
>>>>>>> origin/master
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
