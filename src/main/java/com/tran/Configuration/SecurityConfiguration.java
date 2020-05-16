package com.tran.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity

     @Order(1)
    public  class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 @Autowired
	 private DataSource dataSource;
	 
	 private final String USERS_QUERY = "select email, password, active from driver where email=?";
	 private final String ROLES_QUERY = "select u.email, r.role from driver u inner join user_role ur on (u.id = ur.user_id) inner join role r on (ur.role_id=r.role_id) where u.email=?";
   
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.jdbcAuthentication()
	   .usersByUsernameQuery(USERS_QUERY)
	   .authoritiesByUsernameQuery(ROLES_QUERY)
	   .dataSource(dataSource)
	   .passwordEncoder(bCryptPasswordEncoder);
	 }
	 @Override
	 protected void configure(HttpSecurity http) throws Exception{
		 http.authorizeRequests()
		   .antMatchers("/").permitAll()
		   .antMatchers("/login").permitAll()
		   .antMatchers("/signup").permitAll()
		  // .antMatchers("/forgotpassword").permitAll()
		   .antMatchers("/adlogin").permitAll()
		   .antMatchers("/adsignup").permitAll()
		   .antMatchers("/adminhome").permitAll()
		   .antMatchers("/booking").permitAll()
		   .antMatchers("/probook").permitAll()
		   
			 .antMatchers("/select/{comlic}").permitAll()
			 .antMatchers("/edit/{id}").permitAll()
			 .antMatchers("/update/{id}").permitAll()
			 .antMatchers("/delete/{id}").permitAll()
			 .antMatchers("/deletee/{id}").permitAll()
			 .antMatchers("/view").permitAll()
			 .antMatchers("/viewsalary").permitAll()
			 .antMatchers("/viewall").permitAll()
			 .antMatchers("/editing/{id}").permitAll()
			 .antMatchers("/updating/{id}").permitAll()
			 .antMatchers("/deletesalary/{id}").permitAll()
			 .antMatchers("/Logout").permitAll()
			 .antMatchers("/about").permitAll()
						
		  	
			
		   .antMatchers("/home").permitAll()
		   .antMatchers("/home").hasAuthority("ADMIN").anyRequest()
		   .authenticated().and().csrf().disable()
		   .formLogin().loginPage("/login").failureUrl("/Login?error=true")
		  .defaultSuccessUrl("/home")
		   .permitAll(true)
		   .usernameParameter("email")
		   .passwordParameter("password")
		   .and().logout()
		   .logoutRequestMatcher(new AntPathRequestMatcher("/driverlogout"))
		   .logoutSuccessUrl("/");
}
}
  

