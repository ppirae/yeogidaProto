package com.yeogida.yeogidaProto.global.security;

import com.yeogida.yeogidaProto.global.jwt.service.TokenService;
import com.yeogida.yeogidaProto.global.oauth.CustomOAuth2UserService;
import com.yeogida.yeogidaProto.global.oauth.OAuth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final TokenService tokenService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers("/token/**").permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                    .oauth2Login()
                        .successHandler(oAuth2SuccessHandler)
                        .userInfoEndpoint()
                        .userService(customOAuth2UserService);

        return http.build();
    }
}
