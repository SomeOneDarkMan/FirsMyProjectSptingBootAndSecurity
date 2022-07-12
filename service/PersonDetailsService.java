package ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.models.Person;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.repository.PersonRepository;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.security.PersonDetails;

import java.util.Optional;


@Service
public class PersonDetailsService implements UserDetailsService{
    private final
    PersonRepository personRepository;
   @Autowired
    public PersonDetailsService( PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person=personRepository.findByUsername(username);

        if(person.isEmpty())
             throw new UsernameNotFoundException("User not found ");

        return new PersonDetails(person.get()) ;
    }

}
