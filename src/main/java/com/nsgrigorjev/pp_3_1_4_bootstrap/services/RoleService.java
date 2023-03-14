package com.nsgrigorjev.pp_3_1_4_bootstrap.services;

import com.nsgrigorjev.pp_3_1_4_bootstrap.models.Role;

import java.util.List;


public interface RoleService {

    Role findRoleById(Integer id);
    List<Role> getAllRoles();
    List<Role> getUniqueRoles();
    void addRole(Role role);

}
