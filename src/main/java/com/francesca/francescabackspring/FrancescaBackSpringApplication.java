package com.francesca.francescabackspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.swagger.models.HttpMethod;
import security.JWTAuthorizationFilter;

@SpringBootApplication
public class FrancescaBackSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrancescaBackSpringApplication.class, args);
	}
	@EnableWebSecurity
    @Configuration
    static
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    //.antMatchers(HttpMethod.GET, "/clients/{id}").permitAll()
                    //.antMatchers("/clients/**").authenticated()
                    .anyRequest().permitAll();
        }

    }

}
