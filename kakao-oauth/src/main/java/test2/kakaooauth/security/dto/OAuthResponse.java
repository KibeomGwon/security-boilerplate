package test2.kakaooauth.security.dto;

import java.util.Map;

public interface OAuthResponse {
    void setAttribute(Map<String, Object> attribute);

    String getProvider();

    String getProviderId();

    String getEmail();

    String getNickname();
}
