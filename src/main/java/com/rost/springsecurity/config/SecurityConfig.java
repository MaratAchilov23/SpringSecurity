package com.rost.springsecurity.config;

import com.rost.springsecurity.security.AuthProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;



@EnableWebSecurity
public class SecurityConfig implements WebSecurityConfigurer {
    private final AuthProviderImpl auth;
    @Autowired
    public SecurityConfig(AuthProviderImpl auth) {
        this.auth = auth;
    }

    // Метод настраивает аутентификацию
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider((AuthenticationProvider) auth);
    }

    @Override
    public void init(SecurityBuilder securityBuilder) throws Exception {

    }

    @Override
    public void configure(SecurityBuilder securityBuilder) throws Exception {

    }
}
