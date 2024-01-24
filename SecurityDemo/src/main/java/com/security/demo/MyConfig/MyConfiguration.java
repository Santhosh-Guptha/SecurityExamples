
package com.security.demo.MyConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

@EnableWebSecurity
public class MyConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("san").password(this.encoder().encode("san"))
				.roles("NORMAL");
		auth.inMemoryAuthentication().withUser("sha").password(this.encoder().encode("san")).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/user/**").hasRole("ADMIN").anyRequest().authenticated().and().httpBasic();
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/public/**").hasRole("NORMAL").antMatchers("/user/**").hasRole("ADMIN")
		.anyRequest().authenticated().and().formLogin();
	}

	@Bean
	public PasswordEncoder encoder() {
		// return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}

}
