package com.contoso;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {

        http.requestMatchers().antMatchers("/catalog/**", "/user/**", "/account/**").and()
            .authorizeRequests().antMatchers("/catalog/**", "/user/**", "/account/**").permitAll()
            .and().csrf().disable().httpBasic().disable();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/catalog/**", "/user/**", "/account/**");
	}

}
