package com.nsgrigorjev.pp_3_1_4_bootstrap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nsgrigorjev.pp_3_1_4_bootstrap.models.User;

import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u join fetch u.roles where u.username =:username")
    Optional<User> findByUsername(@Param("username") String usermane);
}
