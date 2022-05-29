package com.miniOne.MiniOne.service.impl;

import com.miniOne.MiniOne.entity.Role;
import com.miniOne.MiniOne.repository.RoleRepo;
import com.miniOne.MiniOne.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role addRole(Role r) {
    return new Role();
    }
}
