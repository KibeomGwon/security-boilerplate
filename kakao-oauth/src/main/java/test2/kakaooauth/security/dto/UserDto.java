package test2.kakaooauth.security.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
    private String email;
    private String role;
    private String nickname;
}
