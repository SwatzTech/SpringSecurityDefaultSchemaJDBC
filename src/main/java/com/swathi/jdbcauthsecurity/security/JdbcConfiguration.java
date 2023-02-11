package com.swathi.jdbcauthsecurity.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * 
 * Standard schema required for the default JDBC implementation of UserDetailsService 
 * 
 * https://docs.spring.io/spring-security/site/docs/4.0.x/reference/html/appendix-schema.html
 * 
 * @author swath
 *
 */
@EnableWebSecurity
public class JdbcConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		
		// To authenticate users and authorities based on standard schema definitions provided by spring boot 
		// configured in data.sql and schema.sql files
		auth.jdbcAuthentication()
		.dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/user").hasAnyRole("ADMIN","USER")
		.antMatchers("/").permitAll()
		.and().formLogin();
		
	}
	
	
	@Bean
	public PasswordEncoder doPasswordEncoding() {
		PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
        return passwordEncoder;
	}
}
