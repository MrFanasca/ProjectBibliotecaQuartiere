package org.generation.italy.bibliotecaQuartiere.security;


import org.generation.italy.bibliotecaQuartiere.security.service.DatabaseUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	  @Bean
	  SecurityFilterChain filterChain(HttpSecurity http) 
	  	throws Exception {
		    http
//		   .authorizeHttpRequests((requests) -> requests.anyRequest().authenticated()).formLogin((form) -> form.permitAll());
		    .authorizeHttpRequests((requests) -> requests
		    	//richieste GET per nuovo, modifica, elimina prodotto richiedono il ruolo admin
		    	.requestMatchers(
		    		
					"/Volontario", 
					"/Volontario/**",				//necessarie per bootstrap e font awesome		
					"/img/**",
					"/error")
				.hasAuthority("volontario")
				
				//richieste POST per nuovo, modifica, elimina prodotto richiedono il ruolo admin			    
				.requestMatchers(HttpMethod.POST,
					"/Volontario", 
					"/Volontario/**",				//necessarie per bootstrap e font awesome			
					"/img/**",
					"/error")
				.hasAuthority("volontario")
			)
		    
		    .authorizeHttpRequests((requests) -> requests
		    	//richieste get che richiedono solo di autenticarsi
				.requestMatchers(
					"/",
					"/servlet/cittadino/**",
					"/WEB-INF/jsp/**",
					"/WEB-INF/jsp/fragments/**",
					"/webjars/**",				//necessarie per bootstrap e font awesome
					"/css/**",			
					"/img/**",
					"/error")
				.authenticated()
			)
		    
		    
		    //il form login è permesso a tutti
		    .formLogin((form) -> form.permitAll())
		    //pagina custom (da gestire in un controller):
		    //.formLogin((form) -> form.loginPage("/userLogin").permitAll())
		   
		    //il logout è permesso a tutti
		    .logout(
		    	(logout) -> logout.permitAll())
		    
		    //protegge dagli attacchi Cross Site Request Forgery (CSRF)
		    .csrf(Customizer.withDefaults());
		    
	    return http.build();
	  }
	  
	  //restituisce un oggetto DatabaseUserDetailsService
	  @Bean
	  DatabaseUserDetailService userDetailsService() {
	    return new DatabaseUserDetailService();
	  }
	  
	  //indica a Spring di rilevare il tipo di encoding utilizzato nella tabella utenti
	  //(eventualmente si può specificare un tipo particolare di encoding)
	  @Bean
	  PasswordEncoder pwdEncoder() {
	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	  }  
	  
	  //restituisce un DaoAuthenticationProvider (AuthenticationProvider basato sul DB)
	  @Bean
	  DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 
	    authProvider.setUserDetailsService(userDetailsService());
	    authProvider.setPasswordEncoder(pwdEncoder());
	 
	    return authProvider;
	  }  

}
