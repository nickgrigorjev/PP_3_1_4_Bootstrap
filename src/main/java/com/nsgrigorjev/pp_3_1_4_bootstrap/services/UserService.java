package com.nsgrigorjev.pp_3_1_4_bootstrap.services;

import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;

import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    User show(int id);
    void create(User user);
    void update(User user);
    void delete(int id);
    public User findByUserName(String name);

}
