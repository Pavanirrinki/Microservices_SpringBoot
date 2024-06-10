package java.com.example.demo.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.com.example.demo.Security.JWTAuthentificationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JWTAuthentificationFilter jwtAuthentificationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disables CSRF protection
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/users/register","/users/login","/tasks/**","/users/All_profiles","/send_email/**","/file_upload/**").permitAll() // Public routes
                .anyRequest().authenticated()          // Secured routes
            );                 // Enable logout
http.addFilterBefore(jwtAuthentificationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager
    (AuthenticationConfiguration authenticationConfiguration) 
    		throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
 @Bean  
 public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	 
 }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
