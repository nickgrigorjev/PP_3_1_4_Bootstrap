package com.nsgrigorjev.pp_3_1_4_bootstrap.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.Role;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;
import com.nsgrigorjev.pp_3_1_4_bootstrap.repositories.UsersRepository;

import java.util.Set;

@Service
public class RegistrationService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = user.getRoles();
        roles.add(new Role("ROLE_USER"));
        user.setRoles(roles);
        usersRepository.save(user);
    }
}
