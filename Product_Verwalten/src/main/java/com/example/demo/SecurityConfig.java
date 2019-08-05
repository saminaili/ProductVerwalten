package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;



@Configuration
@EnableWebSecurity

public class SecurityConfig  extends WebSecurityConfigurerAdapter{
@Autowired	
private DataSource datasource;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	/*auth.inMemoryAuthentication().withUser("admin").password("1234").roles("USER","ADMIN");
	auth.inMemoryAuthentication().withUser("user").password("12342").roles("USER");*/

auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery("SELECT login as principal, pass as credentials, active FROM userss WHERE login=?")
.authoritiesByUsernameQuery("SELECT loginn, role FROM userss_role WHERE loginn=?").passwordEncoder(new Md4PasswordEncoder()).rolePrefix("Role_");
	
	
	
	


}



@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
	}
}
