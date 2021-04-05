package com.dari.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dari.model.User;
import com.dari.model.UserDet;
import com.dari.repository.UserRepository;

@Service
public class UserDetService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
		
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 User user = this.userRepository.findByUserName(userName);
		 UserDet userDet = new UserDet(user); 
		 
		 return userDet ; 
	}

}
