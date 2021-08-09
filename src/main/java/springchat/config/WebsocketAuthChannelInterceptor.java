package springchat.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import springchat.service.UserService;

@Service
@RequiredArgsConstructor
public class WebsocketAuthChannelInterceptor implements ChannelInterceptor {

    @Value("${custom.secret}")
    private String secret;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (accessor == null) throw new RuntimeException("Cannot retrieve accessor to stomp headers");

        if (accessor.getCommand() == StompCommand.CONNECT) {
            String token = accessor.getFirstNativeHeader("Authentication");

            if (token == null || !token.startsWith("Bearer ")) {
                throw new RuntimeException("Received no or incorrect token");
            }

            token = token.replace("Bearer ", "");
            String username = JWT.require(Algorithm.HMAC256(secret))
                    .build()
                    .verify(token)
                    .getClaim("username").asString();

            UserDetails userDetails = userService.loadUserByUsername(username);

            if (userDetails == null) {
                throw new RuntimeException(String.format("User with provided username: %s doesn't exist", username));
            }

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    username,
                    null,
                    userDetails.getAuthorities()
            );

            SecurityContextHolder.getContext().setAuthentication(auth);
            auth.eraseCredentials();
            accessor.setUser(auth);
        }
        return message;
    }
}
