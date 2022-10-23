package com.webservice.boot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // 해당 어노테이션을 이용해 스프링 부트의 자동 설정, 스프링 Bean 읽기/생성을 모두 자동으로 설정한다.
public class Application { // 해당 프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
