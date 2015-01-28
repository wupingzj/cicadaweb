package com.yang.cicada.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//        .authorizeRequests()
//            .antMatchers("/*").permitAll();
            
		
		// if /info, /health and /beans shows HTTP 404 error, basically means authentication failed.
		http
        .authorizeRequests()
            .antMatchers("/*.html", "/dashboard/**", "/css/**", "/image/**", "/js/**", "/fonts/**", "/home", "/heartbeat", "/info", "/health", "/beans", "/index.html", "/cicada2.html", "/cicada.html", "/bootstrap_template.html").permitAll()
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("admin")
		.password("password")
		.roles("adminRole");
	}
}
