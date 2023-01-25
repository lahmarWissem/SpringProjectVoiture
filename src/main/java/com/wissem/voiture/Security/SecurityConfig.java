package com.wissem.voiture.Security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// lLister Tous les produits
		http.authorizeRequests().antMatchers("/api/all/**").hasAnyAuthority("ADMIN", "USER");
	
		

		// Consulter un produits par son id
		http.authorizeRequests().antMatchers(HttpMethod.GET, "api/**").hasAnyAuthority("ADMIN", "USER");

		// Ajouter Un Produit
		http.authorizeRequests().antMatchers(HttpMethod.POST, "api/**").hasAuthority("ADMIN");

		// Modifier Un Produits
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "api/**").hasAuthority("ADMIN");

		// Supprission D'un Produits
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "api/**").hasAuthority("ADMIN");
		
		http.authorizeRequests().anyRequest().authenticated();
		
		http.addFilterBefore(new JWTAuthorizationFilter(),UsernamePasswordAuthenticationFilter.class);

	}
}
