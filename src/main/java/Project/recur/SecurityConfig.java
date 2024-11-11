package Project.recur;
import org.springframework.context.annotation.Bean;
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
}

