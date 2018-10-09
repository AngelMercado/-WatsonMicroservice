package com.itemsharing.authenticationserver.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.RequestMatcher;
/**
 * Allows customization to the {@link WebSecurity} all changes will
 * be applied authomatically to WebSecurity
 * The configuration of Spring Security
 * @author root
 *
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
	@Autowired 
	private Environment env;
	
	@Autowired
	private UserSecurityService userSecurityService;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return SecurityUtility.passwordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//the AuthenticationManagerBuilder allows config DaoAuthenticationProvider
		//also allow customization of authentication
		auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		is similar to Spring Security's XML &lt;http&gt; element in the
//		 * namespace configuration. It allows configuring web based security for specific http
//		 * requests. By default it will be applied to all requests, but can be restricted using
//		 * {@link #requestMatcher(RequestMatcher)} or other similar methods.
		http.csrf().disable();
	}
	
	
}
