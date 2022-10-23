package com.webservice.boot.domain.posts;

import com.webservice.boot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Posts
 * - 실제 DB의 TBL과 매칭될 Entity 클래스
 * - 해당 Entity 클래스의 수정을 통해 DB 데이터를 작업한다.
 *
 * @author 류지헌
 */
@Getter
@NoArgsConstructor // 기본 생성자(Args가 없는) 추가
@Entity // 해당 클래스가 DB의 테이블과 링크될 클래스임을 알림. 통상적으로 카멜케이스 -> 언더스코어 네이밍을 사용
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK(기본키) 필드를 명시함
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄. 또한 생성 규칙은 자동증가이다.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타냄. 이때 컬럼에 사이즈, 타입, 널허용등의 옵션을 부여할 수 있다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 여기서는 컬럼의 타입을 TEXT로 설정
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함된다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author; // 빌더 패턴을 사용하면 어느 필드에 어떤 값을 채워야 할지를 명확하게 할 수 있다.
    }

    // setter 대신 객체의 행위를 나타내는 메서드를 명확한 목적과 의도로 만든다. (책 92p 참조)
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
