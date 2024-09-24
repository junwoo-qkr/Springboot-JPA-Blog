package com.abc.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // IoC
public class SecurityConfig {

 @Bean
 BCryptPasswordEncoder encode() {
  return new BCryptPasswordEncoder();
 }

 @SuppressWarnings("removal")
@Bean // 스프링 컨테이너에서 객체를 관리할 수 있게 됨
 SecurityFilterChain configure(HttpSecurity http) throws Exception {
  http
  	.csrf().disable() // csrf 토큰 비활성화
    .authorizeHttpRequests()
    // .requestMatchers("/", "/WEB-INF/**", "/js/**", "/css/**", "/image/**") // 여기 적힌 url로 들어오는 요청은
    	.requestMatchers("/", "/WEB-INF/**", "/auth/**", "/js/**", "/css/**", "/image/**") // 여기 적힌 url로 들어오는 요청은
    	.permitAll() // 모두 허용
    	.anyRequest() // 그 이외의 모든 요청은
    	.authenticated() // 인증 필요
    .and()
    	.formLogin()
    	.loginPage("/auth/loginForm") // 인증이 필요한 요청이 오면 /auth/loginForm 으로 연결됨
  		.permitAll();
  http
  	.sessionManagement()
  	.invalidSessionUrl("/auth/loginForm");
  return http.build();
 }
}