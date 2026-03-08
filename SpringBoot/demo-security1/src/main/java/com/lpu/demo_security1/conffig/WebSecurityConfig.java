package com.lpu.demo_security1.conffig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	//if not create this container will take default bean which will return login page by default
	@Bean  //taking control of filter chain ourselves
	public SecurityFilterChain filterChain(HttpSecurity http) {
		http.authorizeHttpRequests(
				(req)->req.requestMatchers("/reg","/error").permitAll()  //if reg and error permit else authenticate
					.anyRequest().authenticated());
				//(req)->req.requestMatcher("/account").authenticated()
				//	.anyrequest().permitAll());
				//(req)->req.anyRequest().authenticated() );  //authenticate the request, check for login
				//(req)->req.anyRequest().permitAll());   //allowing every request to access
				//(req)->req.anyRequest().denyAll());  //deny access for every request
				
				
		http.formLogin(Customizer.withDefaults()); //authenticating with form - chrome login page
		http.httpBasic(Customizer.withDefaults()); //for postman basic auth, generate pop up
		
		return http.build(); 
	}
	
	@Bean
	public UserDetailsService  userDetailsService() {
		UserDetails user1=User
				.withUsername("raju")
				.password("{noop}123")  //noop coz want plain text
				.roles("read")
				.build();
		
		UserDetails user2=User
				.withUsername("admin")
				.password("{noop}321")
				.roles("admin")
				.build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	}
	
}
