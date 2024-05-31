package com.turkcell.TurkcellCRM.identityService.dataAccess;

import com.turkcell.TurkcellCRM.identityService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
