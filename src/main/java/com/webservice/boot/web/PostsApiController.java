package com.webservice.boot.web;

import com.webservice.boot.dto.PostsSaveRequestDto;
import com.webservice.boot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PostsApiController
 * - Posts 등록, 수정, 삭제 컨트롤러
 *
 * @author 류지헌
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto postsSaveRequestDto) {
        return postsService.savePosts(postsSaveRequestDto);
    }
}
