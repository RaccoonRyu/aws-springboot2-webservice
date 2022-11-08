package com.webservice.boot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email); // 소셜 로그인의 반환 값 중 email을 통해 기생성자/신규가입자를 판단하기 위한 메서드
}
