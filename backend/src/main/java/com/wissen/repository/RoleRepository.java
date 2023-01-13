package com.wissen.repository;

import com.wissen.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    public Role findByRoleName(String name);

    public Role getRoleByRoleName(String name);
}
