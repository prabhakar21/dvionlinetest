package com.bokaro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	 @Autowired 
	 private UserDetailsService userDetailsService;
//	 @Autowired
//	 private Environment environment; 
 
 @Autowired
 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {    
	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
 } 
 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
   http.authorizeRequests()
  .antMatchers("/index").access("hasRole('ROLE_ADMIN')")
  .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
  .antMatchers("/user/**").access("hasRole('ROLE_USER')")
  .antMatchers("/questionForm").access("hasRole('ROLE_OTHER')")
  .antMatchers("/hello").access("hasRole('ROLE_USER')")
  .anyRequest().permitAll()
  .and()
    .formLogin().loginPage("/login")
    .usernameParameter("email").passwordParameter("password")
  .and()
    .logout().logoutSuccessUrl("/login?logout") 
   .and()
   .exceptionHandling().accessDeniedPage("/403")
  .and()
    .csrf();
 }
 
 	@Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
     return new BCryptPasswordEncoder();
    }
 	
// 	 @Bean
// 	  public DataSource dataSource() {
// 	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
// 	    dataSource.setDriverClassName(environment.getRequiredProperty("com.mysql.jdbc.Driver"));
// 	    dataSource.setUrl(environment.getRequiredProperty("jdbc:mysql://localhost/userbase?useSSL=false"));
// 	    dataSource.setUsername(environment.getRequiredProperty("root"));
// 	    dataSource.setPassword(environment.getRequiredProperty("root"));
// 	    return dataSource;
// 	}
}