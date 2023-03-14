package com.nsgrigorjev.pp_3_1_4_bootstrap.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;
import com.nsgrigorjev.pp_3_1_4_bootstrap.services.MyUserDetailsService;

@Component
public class UserValidator implements Validator {

    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public UserValidator(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            myUserDetailsService.loadUserByUsername(user.getUsername());
        } catch(UsernameNotFoundException ignored) {
            return;
        }

        errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");
    }
}
