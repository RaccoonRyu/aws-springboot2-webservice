package com.webservice.boot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * BaseTimeEntity
 * - Entity들의 생성/수정 일시를 관리하는 class
 *
 * @author 류지헌
 */
@Getter
@MappedSuperclass // JPA Entity 클래스들이 이 어노테이션을 사용한 클래스를 상속할 경우, 해당 클래스의 필드들을 컬럼으로 인식하게 함.
@EntityListeners(AuditingEntityListener.class) // 이 어노테이션을 사용한 클래스에 Auditing 기능을 포함시킴. Auditing : ?
public abstract class BaseTimeEntity {

    @CreatedDate // Entity가 생성-저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate // Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;
}
