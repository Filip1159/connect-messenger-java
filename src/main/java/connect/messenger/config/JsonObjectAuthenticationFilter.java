package connect.messenger.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import connect.messenger.model.User;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JsonObjectAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final String secret;
    private final Long expirationTime;
    private final AuthenticationManager authenticationManager;

    public JsonObjectAuthenticationFilter(String secret,
                                          Long expirationTime,
                                          AuthenticationManager authenticationManager) {
        this.secret = secret;
        this.expirationTime = expirationTime;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        try {
            LoginCredentials credentials = new ObjectMapper().readValue(request.getReader(), LoginCredentials.class);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    credentials.getUsername(),
                    credentials.getPassword()
            );

            return authenticationManager.authenticate(token);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) {

        User user = (User) authResult.getPrincipal();

        String token = JWT.create()
                .withClaim("id", user.getId())
                .withClaim("username", user.getUsername())
                .withClaim("name", user.getName())
                .withClaim("surname", user.getSurname())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC256(secret));
        response.addHeader("Authentication", "Bearer " + token);
    }
}