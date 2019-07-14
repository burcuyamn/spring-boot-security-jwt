package com.blog.my.controller;

import com.blog.my.config.JwtTokenUtil;
import com.blog.my.dto.UserDTO;
import com.blog.my.model.JwtResponse;
import com.blog.my.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO userDTO) {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(userDTO.getUsername());
        userDetailsService.authenticate(userDetails, userDTO.getPassword());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(value = "/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
        UserDTO user = new UserDTO();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        return ResponseEntity.ok(userDetailsService.save(user));
    }
}
