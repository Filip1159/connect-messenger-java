package springchat.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class RestAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final Long expirationTime;
    private final String secret;

    @Autowired
    public RestAuthenticationSuccessHandler(@Value("${custom.jwt-expiration-time}") Long expirationTime,
                                            @Value("${custom.secret}") String secret) {
        this.expirationTime = expirationTime;
        this.secret = secret;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) {
        MyUserDetails principal = (MyUserDetails) authentication.getPrincipal();
        String token = JWT.create()
                .withClaim("id", principal.getUserId())
                .withClaim("username", principal.getUsername())
                .withClaim("name", principal.getName())
                .withClaim("surname", principal.getSurname())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secret));
        response.addHeader("Authentication", "Bearer " + token);
    }
}
