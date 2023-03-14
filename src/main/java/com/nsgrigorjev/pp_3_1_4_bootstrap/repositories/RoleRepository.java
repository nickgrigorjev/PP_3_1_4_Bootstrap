package com.nsgrigorjev.pp_3_1_4_bootstrap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
