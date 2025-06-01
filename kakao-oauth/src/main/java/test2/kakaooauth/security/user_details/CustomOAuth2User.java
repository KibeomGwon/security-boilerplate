package test2.kakaooauth.security.user_details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;
import test2.kakaooauth.security.dto.UserDto;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class CustomOAuth2User  implements OAuth2User {

    private final UserDto dto;

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        GrantedAuthority authority = () -> dto.getRole();
        return List.of(authority);
    }

    @Override
    public String getName() {
        return dto.getNickname();
    }

    public String email() {
        return dto.getEmail();
    }
}
