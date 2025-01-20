package com.example.demo.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	//passwordEncode설정
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/", "/home").permitAll()
				.requestMatchers("/admin").hasRole("ADMIN") //ROLE이름은 반드시 대문자로 시작해야되는 규칙이 있음
															//hasAnyRole에서는 반드시 ROLE_로 시작해야됨.
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.usernameParameter("userid")	//아이디 파라미터 이름 바꾸기
				.successHandler(authenticationSuccessHandler())
				.permitAll()
			)
			/*
			.formLogin()
			.loginPage("login")
			.usernameParameter("userid")
			.and() //다음 설정으로 넘어갈 때 .and()로 묶어주게 됨. 람다식으로 표현한 게 위에 방식. 이 방식은 권장되지 않음
			*/			
			.logout((logout) -> logout.permitAll());
			//.csrf(csrf -> csrf.disable());	//csrf토큰이 로그인시에 발생하지 않게 함. default는 사용함.
		
		
		//403에러 직접만든 페이지로 페이지 연결
		//http.exceptionHandling(ex -> ex.accessDeniedPage("/error403.html"));	//accessDeniedPage --- static폴더 하위에 있는 파일을 찾아감
		http.exceptionHandling(ex -> ex.accessDeniedHandler(accessDeniedHandler()));
		return http.build();
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	//@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1111")
				.roles("USER")
				.build();
		
		UserDetails admin =
				 User.withDefaultPasswordEncoder()
					.username("admin")
					.password("1111")
					.roles("ADMIN")
					.build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}