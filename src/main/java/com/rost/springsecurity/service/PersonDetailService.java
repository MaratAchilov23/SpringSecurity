package com.rost.springsecurity.service;

import com.rost.springsecurity.models.Person;
import com.rost.springsecurity.repository.PersonRep;
import com.rost.springsecurity.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailService implements UserDetailsService {
    private PersonRep personRep;

    public PersonDetailService(PersonRep personRep) {
        this.personRep = personRep;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person>person= personRep.findByUsername(username);
        if(person.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return new PersonDetails(person.get());
    }
}
