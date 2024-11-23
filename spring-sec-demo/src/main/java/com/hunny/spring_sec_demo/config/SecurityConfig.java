package com.hunny.spring_sec_demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;
    //Authentication
@Autowired
private JwtFilter jwtFilter;
    @Bean
    public AuthenticationProvider   authProvider(){

        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
provider.setUserDetailsService(userDetailsService);
provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }




    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
http.csrf(Customizer->Customizer.disable())
        .authorizeHttpRequests(request->request.requestMatchers("register").permitAll()
                .anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();

        //Imperitive way
// Customizer<CsrfConfigurer<HttpSecurity>> custCsrf= new Customizer<CsrfConfigurer<HttpSecurity>>() {
//    @Override
//    public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//        httpSecurityCsrfConfigurer.disable();
//    }
//};

//http.csrf(custCsrf);

        //      Lambda way
        //       http.csrf(customizer->customizer.disable());
//       http.authorizeHttpRequests(request->request.anyRequest().authenticated());
//http.formLogin(Customizer.withDefaults());
//http.httpBasic(Customizer.withDefaults());
    }

@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
}

}
