package ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.models.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);

}
