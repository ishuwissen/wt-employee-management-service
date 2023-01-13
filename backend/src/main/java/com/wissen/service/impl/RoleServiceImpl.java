package com.wissen.service.impl;

import com.wissen.entity.Role;
import com.wissen.repository.RoleRepository;
import com.wissen.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation class for role service.
 *
 * @author Vishal Tomar
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Role> getAllRoles() {
        return this.roleRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role getRoleByName(String name) {
        return this.roleRepository.getRoleByRoleName(name);
    }
}
