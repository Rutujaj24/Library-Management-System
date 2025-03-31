package com.LibraryManagement.LibMgm.Security;
import com.LibraryManagement.LibMgm.Entitiy.User;
import com.LibraryManagement.LibMgm.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        // Use userName instead of email
        userDetailsManager.setUsersByUsernameQuery(
                "SELECT user_name, password, enabled FROM \"lib_user\" WHERE user_name = ?"
        );

        userDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT user_name, role FROM \"lib_user\" WHERE user_name = ?"
        );

        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for now
                .authorizeHttpRequests(auth -> auth .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        .requestMatchers(HttpMethod.POST, "/books/**").hasAuthority("ADMIN") // Only ADMIN can add books
                        .requestMatchers(HttpMethod.DELETE, "/books/**").hasAuthority("ADMIN") // Only ADMIN can delete books
                        .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin(withDefaults()) // Enable form login
                .httpBasic(withDefaults()); // Enable basic auth

        return http.build();
    }


    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByEmail("admin").isEmpty()) {
                User admin = new User();
                admin.setUserName("admin");
                admin.setEmail("admin");
                admin.setPassword("{noop}admin123"); // ✅ No encoding for now
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }
        };
    }


}

