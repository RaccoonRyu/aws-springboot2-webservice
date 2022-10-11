package com.webservice.boot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // DB 계층 접근자인 PostsRepository 인터페이스
    // JpaRepository<Entity 클래스, PK타입>을 상속한다.
    // 위의 레포지토리를 상속하면 기본적인 CRUD 메서드가 자동으로 생성된다.
    // 주의할 점은 엔티티클래스와 해당 엔티티를 사용하는 레포지토리는 같은 위치에 생성해야한다는 것이다.
}
