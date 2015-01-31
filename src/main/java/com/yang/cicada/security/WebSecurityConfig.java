package com.yang.cicada.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// if /info, /health and /beans shows HTTP 404 error, basically means authentication failed.
//		http
//        .authorizeRequests()
//            .antMatchers("/", "/*.html", "/dashboard/**", "/css/**", "/image/**", "/js/**", "/fonts/**", "/home", "/heartbeat", "/info", "/health", "/beans", "/index.html", "/cicada2.html", "/cicada.html", "/bootstrap_template.html")
//            .permitAll()
//            .anyRequest().authenticated()
//            .and()
//        .formLogin()
//            //.loginPage("/login")
//            .permitAll()
//            .and()
//        .logout()
//            .permitAll();
		
		http
			.authorizeRequests()
	        .antMatchers("/dashboard*.js", "/dashboard*.html").hasRole("ADMIN")
	        .antMatchers("/**").hasRole("USER")
	        .and()
	    .formLogin()
	      //.loginPage("/login")
	    	.and()
	    .logout()
	    	.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	    throws Exception {
		auth
		     .inMemoryAuthentication()
		          .withUser("user")
		               .password("password")
		               .roles("USER")
		               .and()
		          .withUser("adminr")
		               .password("password")
		               .roles("ADMIN","USER");
	}

	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("password")
//		.roles("adminRole");
//	}
	
	// Expose the UserDetailsService as a Bean
	 @Bean
	 @Override
	 public UserDetailsService userDetailsServiceBean() throws Exception {
	     return super.userDetailsServiceBean();
	 }
}
