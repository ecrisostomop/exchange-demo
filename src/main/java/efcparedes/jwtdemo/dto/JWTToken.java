package efcparedes.jwtdemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTToken {
    String user;
    String password;
    String token;
}
