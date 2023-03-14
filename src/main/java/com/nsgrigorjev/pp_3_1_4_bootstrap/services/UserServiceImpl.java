package com.nsgrigorjev.pp_3_1_4_bootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;
import com.nsgrigorjev.pp_3_1_4_bootstrap.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }
    public User show(int id){
        Optional<User> foundUser = usersRepository.findById(id);
        return foundUser.orElse(null);
    }

    @Transient
    public void create(User user){
        usersRepository.save(user);
    }

    public void update(User user){
        usersRepository.save(user);
    }

    public void delete(int id) {
        usersRepository.deleteById(id);
    }

    public User findByUserName(String name) {
        return usersRepository.findByUsername(name).get();
    }

}
