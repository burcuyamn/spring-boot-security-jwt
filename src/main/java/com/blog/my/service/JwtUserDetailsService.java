package com.blog.my.service;

import java.util.ArrayList;

import com.blog.my.dto.UserDTO;
import com.blog.my.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.blog.my.model.User user = userRepository.findByUsername(username).get();
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	public void authenticate(UserDetails userDetails, String password){
		if(!bcryptEncoder.matches(password, userDetails.getPassword())){
			throw new UsernameNotFoundException("Invalid password");
		}
	}
	
	public com.blog.my.model.User save(UserDTO user) {
		com.blog.my.model.User newUser = new com.blog.my.model.User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}
}