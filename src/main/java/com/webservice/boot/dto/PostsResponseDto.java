package com.webservice.boot.dto;

import com.webservice.boot.domain.posts.Posts;
import lombok.Getter;

/**
 * PostsResponseDto
 * - Posts 클래스에 대한 DB 응답용 DTO
 *
 * @author 류지헌
 */
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
