package com.rost.springsecurity.security;

import com.rost.springsecurity.service.PersonDetailService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {
    private PersonDetailService personService;

    public AuthProviderImpl(PersonDetailService personService) {
        this.personService = personService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails personDetails = personService.loadUserByUsername(username);
        String password = authentication.getCredentials().toString();
       if(! password.equals(personDetails.getPassword()))
           throw new BadCredentialsException("Bad credential");

      return new UsernamePasswordAuthenticationToken(personDetails,password, Collections.emptyList());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
