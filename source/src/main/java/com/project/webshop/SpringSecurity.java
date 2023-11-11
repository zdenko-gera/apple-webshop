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

    /**
     * Egy BCryptPasswordEncodert ad vissza
     * @return Egy BCryptPasswordEncodert ad vissza.
     */
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Na ez a csoda azt csinálja, hogy beállítja az alkalmazásban, hogy ki mit hogyan érhet el.
     * Ehhez a paraméterben kapott HttpSecurity-t használja. Ha hibát talál akkor Exceptiont dob.
     * Az authorizeRequests-ben állítja be, hogy a felhasználó melyik fájlokat érheti el. A * helyén bármi lehet, tehát a
     * *.css az bármelyik css fájlt jelenti. A .permitAll() fgv azt csinálja, hogy azt a fájlt, amelyikre ezt lefuttatjuk, azt
     * bárki elérheti. A .formLogin() azt valósítja meg, hogy az alap SpringSecurity-s login page helyett sajátot használunk.
     * A .loginPage() az egy olyan Stringet kap paraméterben ami a Login page neve (vagy amit a @GetMappingnek megadtunk annak a filenak)
     * A .defaultSuccessUrl() az, hogy sikeres bejelentkezés után hova irányítson át.
     * A .failureUrl() az, hogy sikertelen bejelentkezés esetén hova irányítson át.
     * A .permitAll() pedig, hogy ezeket mindenki elérje.
     * A .formLogout() esetén ezek ugyanezt csinálják
     * @param http Ennek állítja be a biztonsági beállításokat.
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/Index/**").permitAll()
                        .requestMatchers("/Webshop/**").permitAll()
                        .requestMatchers("/addToCart/**").permitAll()
                        .requestMatchers("/Productpage/**").permitAll()
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
