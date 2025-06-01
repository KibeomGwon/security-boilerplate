package test2.kakaooauth.security.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
public class KakaoOAuthResponse implements OAuthResponse {

    private Map<String, Object> attribute;
    private Map<String, Object> kakaoAccount;

    public KakaoOAuthResponse(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    @Override
    public void setAttribute(Map<String, Object> attribute) {
        this.attribute = attribute;
        this.kakaoAccount = (Map<String, Object>) attribute.get("kakao_account");
    }

    @Override
    public String getProvider() {
        return "kakao";
    }

    @Override
    public String getProviderId() {
        return (String) attribute.get("id");
    }

    @Override
    public String getEmail() {
        return (String) kakaoAccount.get("email");
    }

    @Override
    public String getNickname() {
        return (String) ((Map<String, Object>) kakaoAccount.get("profile")).get("nickname");
    }
}
