package com.webservice.boot.service.posts;

import com.webservice.boot.domain.posts.PostsRepository;
import com.webservice.boot.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PostsService
 * - Posts 서비스
 * 
 * @author 류지헌
 */
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long savePosts(PostsSaveRequestDto postsSaveRequestDto) {
        return postsRepository.save(postsSaveRequestDto.toEntity()).getId();
    }
}
