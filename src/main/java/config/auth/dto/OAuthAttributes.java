package config.auth.dto;

import com.webservice.boot.domain.user.Role;
import com.webservice.boot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, String name,
                           String email, String picture) {
        this.attributes = attributes;
        this. nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    // of : OAuth2User에서 반환하는 사용자 정보가 Map이기 때문에, 이어지는 ofGoogle에서 Map의 값 하나하나를 변환해야 한다.
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    // toEntity : User 엔티티를 생성.
    // OAuthAttributes에서 엔티티를 생성하는 시점은 처음 가입할 때
    // 처음 가입시 기본 권한을 GUEST로 주기 위해 role 빌더 값에는 Role.GUEST를 사용
    // 추후 OAuthAttributes와 같은 패키지의 '직렬화 기능을 가진 SessionUser 클래스'를 통해 User 엔티티를 생성한다.
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
