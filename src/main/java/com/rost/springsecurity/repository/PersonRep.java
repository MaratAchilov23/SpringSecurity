package com.rost.springsecurity.repository;

import com.rost.springsecurity.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRep extends JpaRepository<Person,Integer> {
   Optional<Person> findByUsername(String username);

}
