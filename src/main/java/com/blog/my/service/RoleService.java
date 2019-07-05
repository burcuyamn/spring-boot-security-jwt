package com.blog.my.service;

import com.blog.my.model.role.Role;
import com.blog.my.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role findById(String oid){
        return roleRepository.findById(oid).get();
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }
}
