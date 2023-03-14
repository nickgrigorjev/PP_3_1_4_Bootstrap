package com.nsgrigorjev.pp_3_1_4_bootstrap.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;
import com.nsgrigorjev.pp_3_1_4_bootstrap.repositories.UsersRepository;

import java.util.Optional;
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public MyUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = usersRepository.findByUsername(username);

        if (users.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return users.get();
        }
    }

}
