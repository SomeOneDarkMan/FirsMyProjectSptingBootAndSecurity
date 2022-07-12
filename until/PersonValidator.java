package ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.until;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.models.Person;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.service.PersonServiceRegistration;
@Component
public class PersonValidator implements Validator {
    private final PersonServiceRegistration personServiceRegistration;
    @Autowired
    public PersonValidator(PersonServiceRegistration personServiceRegistration) {
        this.personServiceRegistration = personServiceRegistration;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person=(Person) target;
        if(!personServiceRegistration.getPersonWithUsername(person.getUsername()).isEmpty()){
            errors.rejectValue("username", "", "такой пользователь уже сузествует");
        }

    }
}
