package test2.kakaooauth.security.dto;

import java.util.Map;

public enum OAuthClient {
    NAVER("naver", null), KAKAO("kakao", new KakaoOAuthResponse()), GOOGLE("google", null);

    private String name;
    private OAuthResponse response;

    OAuthClient(String name, OAuthResponse response) {
        this.name = name;
        this.response = response;
    }

    public static OAuthResponse getResponse(String name, Map<String, Object> attributes) {
        for (OAuthClient client : OAuthClient.values()) {
            if (client.name.equals(name)) {
                client.response.setAttribute(attributes);
                return client.response;
            }
        }
        return null;
    }

}
