package com.webservice.boot.web;

import com.webservice.boot.dto.PostsResponseDto;
import com.webservice.boot.dto.PostsSaveRequestDto;
import com.webservice.boot.dto.PostsUpdateRequestDto;
import com.webservice.boot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/v1/posts/{id}")
    public Long upDatePosts(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
