package com.blog.my.controller;

import com.blog.my.config.JwtTokenUtil;
import com.blog.my.dto.UserDTO;
import com.blog.my.model.JwtRequest;
import com.blog.my.model.JwtResponse;
import com.blog.my.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestParam("username") String username,
                                                       @RequestParam("password")String password) throws Exception {

        //authenticate(username, password);

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(value = "/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<?> saveUser(@RequestParam("username") String username,
                                      @RequestParam("password")String password) throws Exception {
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);

        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
