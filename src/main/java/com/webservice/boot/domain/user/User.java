package com.webservice.boot.domain.user;

import com.webservice.boot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    // @Enumerated : JPA로 DB에 저장시 Enum 값을 어떤 형태로 저장할지 결정
    // 기본적으로는 int형의 숫자 저장됨
    // 허나 int로 저장시 DB로 확인할 때 값이 무슨 코드를 의미하는 바를 알 수 없으므로 문자열로 저장(EnumType.STRING)하게 선언
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User updateUser(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
