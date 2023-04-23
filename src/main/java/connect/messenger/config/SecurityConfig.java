package connect.messenger.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import connect.messenger.repo.UserRepo;
import connect.messenger.service.UserService;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${custom.secret}")
    private String secret;
    @Value("${custom.jwt-expiration-time}")
    private Long expirationTime;
    private final UserRepo userRepo;

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:3000", "https://filip1159.github.io"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT"));
        configuration.addExposedHeader("Authentication");
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList(
                "Accept", "Origin", "Content-Type", "User-Agent",
                "Cache-Control", "Authorization", "X-Req"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/login", "/websocket/**", "/swagger-ui.html", "/v2/api-docs",
                        "/swagger-resources/**", "/images/**", "/test-s3")
                .permitAll()
                .anyRequest().authenticated()

                .and()
                .cors().configurationSource(corsConfigurationSource())

                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .addFilter(new JsonObjectAuthenticationFilter(secret, expirationTime, authenticationManager()))
                .addFilterAfter(new JwtAuthorizationFilter(secret, authenticationManager(), userDetailsService()), JsonObjectAuthenticationFilter.class)
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

                .and().headers().frameOptions().disable();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    protected AuthenticationManager authManager() throws Exception {
        return authenticationManager();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserService(userRepo);
    }

    @Bean
    protected DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        return authProvider;
    }
}