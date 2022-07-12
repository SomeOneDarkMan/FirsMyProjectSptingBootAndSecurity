package ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.models.Person;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.service.PersonDetailsService;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.service.PersonServiceRegistration;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.until.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private  final PersonValidator personValidator;
    private final PersonDetailsService personDetailsService;
    private final PersonServiceRegistration personServiceRegistration;
    @Autowired
    public AuthController(PersonValidator personValidator, PersonDetailsService personDetailsService, PersonServiceRegistration personServiceRegistration) {
        this.personValidator = personValidator;
        this.personDetailsService = personDetailsService;
        this.personServiceRegistration = personServiceRegistration;
    }

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("person")  Person person){

        return "/auth/registration";
    }
    @PostMapping("/registration")
    public String makeNewUser(@ModelAttribute @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person,bindingResult);
        if(bindingResult.hasErrors()){
            return "/auth/registration";
        }
        personServiceRegistration.makeNewUser(person);
        return "/auth/login";
    }

    @GetMapping("/login")
    public String getAuth(){

        return "/auth/login";
    }
    @PostMapping("/logout")
    public String getLogout(){

        return "/auth/login";
    }
}
