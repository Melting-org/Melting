package com.melting.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	
	@Autowired
	private DataSource dataSource;
	
	// 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/", 
				"/board/newlist",
				"/board/read",
				"/member/join",
				"/images/**",
				"/css/**"
				).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/member/login")
		.loginProcessingUrl("/login").permitAll() 
		.usernameParameter("memberid")
		.passwordParameter("memberpwd")
		.and()
		.logout()
		.logoutSuccessUrl("/").permitAll()
		.and()
		.cors()
		.and()
		.httpBasic();
		
		return http.build();
	}
	
	// 인증을 위한 쿼리
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		// 인증 (로그인)
		.usersByUsernameQuery(
				"select memberid username, memberpwd password, enabled "
				+ "from m_member "
				+ "where memberid = ?"
				)
		
		// 권한
		.authoritiesByUsernameQuery(
				"select memberid username, rolename role_name "
				+ "from m_member "
				+ "where memberid= ?"
				);
		
	}
	
	// 단방향 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
