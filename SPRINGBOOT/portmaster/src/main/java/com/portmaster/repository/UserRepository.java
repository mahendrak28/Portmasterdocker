package com.portmaster.repository;

import com.portmaster.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
