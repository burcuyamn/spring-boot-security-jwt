package com.blog.my.controller;

import com.blog.my.model.role.Role;
import com.blog.my.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/all")
    public ResponseEntity<List<Role>> all(){
        List<Role> roles = roleService.findAll();
        return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Role save(@RequestBody Role role){
        return roleService.save(role);
    }
}
