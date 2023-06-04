package com.demo.service;

import com.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

    List<Role> findAll();

    Role findByName(String name);

    void save(Role role);

    Role findById(Long id);

}
