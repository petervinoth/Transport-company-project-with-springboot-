package com.tran.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@Order(2)
public class adminloginConfig extends  WebSecurityConfigurerAdapter {
	
	
	 @Override
	 protected void configure(HttpSecurity http) throws Exception{
		 http.authorizeRequests()
		// .antMatchers("/login").permitAll()
		 .antMatchers("/").permitAll()
		 .antMatchers("/adsignup").permitAll()
		 .antMatchers("/confirm").permitAll()
		 .antMatchers("/forgotpassword").permitAll()
		 .antMatchers("/resetpassword").permitAll()
		 .antMatchers("/view").permitAll()
				 
		 
			 
		 .antMatchers("/add").permitAll()
		 .and().csrf().disable()
		   .formLogin().loginPage("/adlogin").failureUrl("/adlogin")
		  .defaultSuccessUrl("/adminlogin")
		  
       
		
		   .permitAll(true)
		   .usernameParameter("username")
		   .passwordParameter("password")
		  
		
		   .and().logout()
		   .logoutRequestMatcher(new AntPathRequestMatcher("/Logout"))
		   .logoutSuccessUrl("/adlogin");
		   
		 
	 }
	 

}