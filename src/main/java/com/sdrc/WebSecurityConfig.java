package com.sdrc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.sdrc.security.LoginAuthenticationFailerHandler;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter 
{
	 @Autowired
     UserDetailsService userDetailsService;
	
	 @Autowired
	 PasswordEncoder passwordEncoder;
	 
	 @Autowired
	 AuthenticationSuccessHandler successHandler;
	
	
	 @Autowired
	 public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception 
	 {
	        auth.authenticationProvider(authenticationProvider());
	 }
	
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() 
	 {
	        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(userDetailsService);
	        authenticationProvider.setHideUserNotFoundExceptions(false);
	        authenticationProvider.setPasswordEncoder(passwordEncoder);
	        return authenticationProvider;
	 }
	 
	 @Override
	 protected void configure(HttpSecurity http) throws Exception 
	 {
		 handleCsrf(http);
		 handlePrivilages(http);
		 handleLogin(http);
		 handleSession(http);
		 handleException(http);
	 }
	 
	
	 
	 
	 private void handleCsrf(HttpSecurity http)throws Exception
	 {
		http.csrf().disable();
	 }
	 
	 private void handleLogin(HttpSecurity http)throws Exception
	 {
		 http.formLogin().loginPage("/login").loginProcessingUrl("/j_spring_security_check")
		 	 .usernameParameter("userid").passwordParameter("password")
		 	 .defaultSuccessUrl("/loginSuccess", false).failureUrl("/login?error=true")
		 	 .successHandler(successHandler).failureHandler(failerHandler());
	 }
	 
	 
	 private void handleSession(HttpSecurity http)throws Exception
	 {
		 http.sessionManagement().invalidSessionUrl("/").maximumSessions(1).expiredUrl("/");
	 }
	 
	 
	 @Bean
     public AuthenticationFailureHandler failerHandler() 
	 {
			 LoginAuthenticationFailerHandler authenticationFailureHandler=new LoginAuthenticationFailerHandler();
			 authenticationFailureHandler.setDefaultFailureUrl("/login?error=true");
			 return authenticationFailureHandler;
	 }
	 
	 private void handlePrivilages(HttpSecurity http)throws Exception
	 {
		 http.authorizeRequests().antMatchers("/loginSuccess").hasRole("ADMIN");
			 
	 }
	 
	 private void handleException(HttpSecurity http) throws Exception
	 {
		 http.exceptionHandling().accessDeniedPage("/403error");
	 }
	 
}