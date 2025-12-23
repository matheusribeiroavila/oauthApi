package com.userauthapi.userauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf((csrf) -> {
            csrf.disable(); //Desabilito as regras base do cross site, para configurar de forma customizada a baixo
        }).authorizeHttpRequests((auth) -> {
            auth.requestMatchers(HttpMethod.GET, "/open").permitAll()
                    .requestMatchers(HttpMethod.POST, "/user").permitAll()
                    .requestMatchers(HttpMethod.POST, "/login").permitAll()
                    .anyRequest().authenticated();// Customizando o que autorizo ou não
        }).addFilterBefore(new AuthFilter(), UsernamePasswordAuthenticationFilter.class); //Aplico o filtro antes da tela DAFAULT de login

        return http.build();
    }

}
