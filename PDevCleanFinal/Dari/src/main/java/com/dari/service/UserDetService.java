package com.dari.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dari.model.User;
import com.dari.model.UserDet;
import com.dari.repository.UserRepository;

@Service
public class UserDetService implements UserDetailsService {
	
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("ghazi".equals(username)) {
			return new User("ghazi", "$2a$10$hsS38/SZ9a2Wte5KRsAFZezWayDkt7474fEkOsfI.ecRo2MQEiJDy",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}*/
	@Autowired
	private UserRepository userRepository;
		
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		 User user = this.userRepository.findByUserName(userName);
		 UserDet userDet = new UserDet(user); 
		 
		 return userDet ; 
	}

}
