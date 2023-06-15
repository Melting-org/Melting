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
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/", 
				"/board/newlist",
				"/read",
				"/board/download",
				"/join",
				"/images/**",
				"/css/**",
				"/script/**",
				"/idChk",
				"/idCheck",
				"/nameCheck"
				).permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/loginForm")
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
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)

		.usersByUsernameQuery(
				"select memberid username, memberpwd password, enabled "
				+ "from m_member "
				+ "where memberid= ?"
				
				
				)
		
		
		.authoritiesByUsernameQuery(
				"select memberid username, rolename role_name "
				+ "from m_member "
				+ "where memberid= ?"
				);
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
