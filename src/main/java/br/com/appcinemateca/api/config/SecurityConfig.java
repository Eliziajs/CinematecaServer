package br.com.appcinemateca.api.config;

import br.com.appcinemateca.api.security.jwt.JwtConfigurer;
import br.com.appcinemateca.api.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class SecurityConfig {

	@Autowired
	private JwtTokenProvider tokenProvider;


	@Bean
	public PasswordEncoder passwordEncoder() {

		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_5());
		PasswordEncoder passwordEncoder =
				new DelegatingPasswordEncoder("pbkdf2", encoders);
		return passwordEncoder;
	}


	/**@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}**/


	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return (SecurityFilterChain) http
			.httpBasic().disable()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
					.authorizeHttpRequests()
					.requestMatchers("/auth/signin",
							"/auth/refresh",
							"/api-docs/**",
							"/swagger-ui.html**")
					.permitAll()
					.requestMatchers("/api/**").authenticated()
					.requestMatchers("/users").denyAll()
				.and()
					.cors()
				.and()
				.apply(new JwtConfigurer(tokenProvider));
	}
}
