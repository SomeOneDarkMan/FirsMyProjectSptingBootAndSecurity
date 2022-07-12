package ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.security.PersonDetails;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.service.PersonServiceRegistration;

@Controller
@RequestMapping("/helloWorld")
public class PersonController {
    final private PersonServiceRegistration personServiceRegistration;
     @Autowired
    public PersonController(PersonServiceRegistration personServiceRegistration) {
        this.personServiceRegistration = personServiceRegistration;
    }

    @GetMapping()
    public String helloWorld(){

        return "helloWorld";
    }
    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        personServiceRegistration.testPreAuthorize();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());

        return "helloWorld";
    }

}
