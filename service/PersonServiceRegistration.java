package ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.models.Person;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.repository.PersonRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonServiceRegistration {
    private final
    PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public PersonServiceRegistration(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Person> getPersonWithUsername(String s){
        personRepository.findByUsername(s);
        return  personRepository.findByUsername(s);
    }
    @Transactional
    public void makeNewUser(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        personRepository.save(person);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void testPreAuthorize(){
        System.out.println("ADMIN IS INTO ME");
    }
}
