package test2.kakaooauth.security.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import test2.kakaooauth.security.dto.OAuthClient;
import test2.kakaooauth.security.dto.OAuthResponse;
import test2.kakaooauth.security.dto.UserDto;
import test2.kakaooauth.security.user_details.CustomOAuth2User;

@Service
@Slf4j
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();

         OAuthResponse response = OAuthClient.getResponse(registrationId, oAuth2User.getAttributes());


        UserDto dto = new UserDto();
        dto.setEmail(response.getEmail());
        dto.setRole("ROLE_USER");
        dto.setNickname(response.getNickname());

        log.info("user = {}", dto.toString());

        return new CustomOAuth2User(dto);
    }
}
