package ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.models.Person;
import ru.Below.springcorse.FirsMyProjectSptingBootAndSecurity.service.PersonDetailsService;

import java.util.Collections;
import java.util.Optional;

@Component
@Deprecated//так как на нашем севере авторизация поэтому не используем
public class AuthProviderImpl implements AuthenticationProvider {
     private final PersonDetailsService personDetailsService;
    @Autowired
    public AuthProviderImpl(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       String username= authentication.getName();
       String password =authentication.getCredentials().toString();
       UserDetails personDetails=personDetailsService.loadUserByUsername(username);
        if (!password.equals(personDetails.getPassword()))
            throw new BadCredentialsException("Incorrect password");
        return new UsernamePasswordAuthenticationToken(personDetails,password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
