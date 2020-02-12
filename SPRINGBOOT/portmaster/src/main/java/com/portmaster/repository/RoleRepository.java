package com.portmaster.repository;

import com.portmaster.entity.ERole;
import com.portmaster.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
