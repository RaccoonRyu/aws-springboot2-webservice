package com.webservice.boot.domain.posts;


import com.webservice.boot.Application;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    // @After : Junit에서 단위테스트가 끝날 때마다 수행되는 메서드 지정
    // 보통 배포 전 전체테스트를 수행 시 테스트간 데이터 침범을 막기위해 사용
    // @After 없이 여러 테스트가 동시에 수행되면 DB(여기서는 H2)에 데이터가 그대로 남아 다음 테스트 실행 시 테스트가 실패할 수 있음
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void getPost() {
        // given
        String title = "테스트 제목";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // posts 테이블에 insert/update 쿼리를 실행
                                .title(title) // 기존에 id값이 있담녀 update, 없다면 insert 쿼리가 실행
                                .content(content)
                                .author("rjhwind94@gmail.com")
                                .build());

        // when
        List<Posts> postsList = postsRepository.findAll(); // posts 테이블에 있는 모든 데이터를 조회하는 메서드

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
