package Project.recur;
/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		return passEncoder;
	}
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests(authorize -> authorize.requestMatchers(HttpMethod.POST, "/auth/sign-up")
						.permitAll().anyRequest().permitAll())
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}*/

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import Project.recur.service.UserSecurityService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserSecurityService userSecurityService;
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
		return passEncoder;
	}
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			/*.authorizeHttpRequests(authorize -> authorize
					.requestMatchers(HttpMethod.GET, "/api/hello").hasAuthority("CUSTOMER")        */
		.csrf((csrf) -> csrf.disable())
		 .authorizeHttpRequests(authorize -> authorize
				 	.requestMatchers(HttpMethod.GET, "/auth/login").authenticated()
				 	.requestMatchers(HttpMethod.POST, "/auth/switch-status").hasAuthority("EXECUTIVE") 
				 	.requestMatchers(HttpMethod.GET, "/api/hello").hasAuthority("CUSTOMER") 
					.requestMatchers(HttpMethod.POST, "/auth/sign-up").permitAll()  
				.anyRequest().permitAll()
			) 
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	AuthenticationManager authenticationManager() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userSecurityService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		ProviderManager providerManager = new ProviderManager(authenticationProvider);
		return providerManager;
	}
}
/*
 * AuthenticationManager            ProviderManager
 * 
 * 
 * DaoAuthenticationProvider        
 * 
 */

