package com.angelehl.rest.webservices.restfulwebservices.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		//Simplemente se esta sobreescribiendo la clase por defecto de spring security
		
		//Todas las peticiones deben ser autenticadas
		http.authorizeHttpRequests(
					auth -> auth.anyRequest().authenticated()
				);
		
		//Si una peticion no esta autenticada, una pagina web por default es mostrada
		http.httpBasic(withDefaults());
		
		http.csrf().disable();
		
		
		return http.build();
	}

}
