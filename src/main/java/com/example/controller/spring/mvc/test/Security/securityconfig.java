package com.example.controller.spring.mvc.test.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class securityconfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/TaskFormEditing", "/saveTaskEditedForm", "/Taskform" , "/saveTaskForm", "/DeleteTask" , "/taskModal" , "/KanbanBoard").authenticated()
                        .requestMatchers( "/cc" , "/webjars/**" , "/h2-console/**" , "/AddUser" , "/SaveUser" , "mainbutton").permitAll())
                .csrf((csrf) -> csrf.disable())
                .cors(AbstractHttpConfigurer::disable)
                .headers(AbstractHttpConfigurer::disable)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
      @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
      }
}
