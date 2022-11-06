package com.webservice.boot.service.posts;

import com.webservice.boot.domain.posts.Posts;
import com.webservice.boot.domain.posts.PostsRepository;
import com.webservice.boot.dto.PostsListResponseDto;
import com.webservice.boot.dto.PostsResponseDto;
import com.webservice.boot.dto.PostsSaveRequestDto;
import com.webservice.boot.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                                     .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                                      .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));

        return new PostsResponseDto(entity);
    }
    
    @Transactional(readOnly = true) // 트랜잭션 범위는 유지하지만 조회기능만 사용 -> 조회 속도 개선을 위함
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                    .map(PostsListResponseDto::new) // posts stream을 map()을 통해 PostsListResponseDto -> List로 반환
                    .collect(Collectors.toList());
    }
    
    @Transactional
    public void delete(Long id) {
        // 우선 삭제할 엔티티가 실제로 DB에 존재하는지 확인을 위해 조회
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " +id));
        postsRepository.delete(posts); // JpaRepository에서 지원하는 delete 메서드 사용. 지금은 삭제할 엔티티 자체를 파라미터로 사용한다.
    }
}
