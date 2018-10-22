package com.contoso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(2)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.requestMatchers()
			.antMatchers("/resources/**", "/favicon.ico", "/login", "/oauth/authorize", "/actuator/**").and()
			.authorizeRequests().antMatchers("/resources/**", "/favicon.ico", "/login", "/oauth/authorize", "/actuator/**").permitAll()
			.anyRequest().authenticated().and()
			.formLogin().loginPage("/login").permitAll().and().logout().permitAll()
			.and().csrf().disable().httpBasic().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring().antMatchers("/resources/**","/favicon.ico");
	}

}
