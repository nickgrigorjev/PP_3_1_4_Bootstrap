package com.nsgrigorjev.pp_3_1_4_bootstrap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.Role;
import com.nsgrigorjev.pp_3_1_4_bootstrap.repositories.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getUniqueRoles() {
        return roleRepository.findAll().stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Role findRoleById(Integer id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
