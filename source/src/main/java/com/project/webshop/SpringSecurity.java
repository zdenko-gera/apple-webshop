package com.project.webshop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/Index/**").permitAll()
                        .requestMatchers("/Webshop/**").permitAll()
                        .requestMatchers("/Product/**").permitAll()
                        .requestMatchers("*.css").permitAll()
                        .requestMatchers("pictures/**").permitAll()

                        .requestMatchers("/Login/**").permitAll()
                        .requestMatchers("/loginUser/**").permitAll()
                        .requestMatchers("/logout/**").permitAll()

                        .requestMatchers("/Signup/**").permitAll()
                        .requestMatchers("/registerUser/**").permitAll()

                        .anyRequest().permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/Login")
                        .defaultSuccessUrl("/index", true)
                        .failureUrl("/login?error=true")
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/Login")
                        .permitAll()
                );
        return http.build();
    }
}
