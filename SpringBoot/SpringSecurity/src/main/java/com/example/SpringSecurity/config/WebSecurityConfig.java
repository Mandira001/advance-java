package com.example.SpringSecurity.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableMethodSecurity   //pre/post authorization
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
    	//CSRF--Cross Site Request Forgery
//        http.csrf(csrf -> csrf.disable());
        //STATELESS,NEVER,IF_REQUIRED,ALWAYS
        //http.sessionManagement((s)->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    	http.cors(c->{});  //enable CORS in security
        http.authorizeHttpRequests(req -> 
            req.requestMatchers("/register", "/public", "/error", "/save").permitAll()   //here we can use denyAll() to deny the permission for these
            /*here instead of hasRole we can also use hasAuthorities, hasAllRole(multiple role specification for one customer),
             * hasAnyAuthority, hasAllAuthority, these works same */
               .requestMatchers("/delete").hasRole("ADMIN")
               .requestMatchers("/update").hasAnyRole("ADMIN","USER")
               .anyRequest()
               .authenticated()  //for authentication
        );

        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());

        return http.build();     //return the object of SecurityFilterChain
    }
    
    @Bean
    public PasswordEncoder encoder() {
    	return new BCryptPasswordEncoder();   //most secured one, here we can also specify the rounds that how many times the password will get encrypted
    }
    
    @Bean
    public CorsConfigurationSource corsConfgurationSource() {
    	CorsConfiguration config = new CorsConfiguration();
    	
    	config.setAllowedOrigins(List.of("http://localhost:3000"));
    	config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
    	config.setAllowedHeaders(List.of("*"));
    	config.setAllowCredentials(true);
    	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	
    	source.registerCorsConfiguration("/**", config);
    	return source;
    	
    	
    }
}
