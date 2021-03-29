package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.User;
import com.dari.service.UserService;


@RestController
@RequestMapping("/App")
public class UserController {

	
	@Autowired
	private UserService userService ; 
	
	
	/*@PostMapping("/register")
	public void Register(@RequestBody User user) {
		userRepository.save(user) ; 
	}*/
	
	@GetMapping("/registerAdmin")
	public String RegisterAdmin(@RequestBody User user) {
		userService.addAdmin(user);
		return "RegistrationDone! "; 
	}
	
	@GetMapping("/register")
	public String RegisterClient(@RequestBody User user) {
		userService.addClient(user);
		return "RegistrationDone! ";
	}
	
	@GetMapping("/Verif/{token}")
	public String VerifAccount(@PathVariable String token) {
		userService.verifyAccount(token);
		return "Account Confirmed"; 
	}
	
	
	
	
	
	@GetMapping("/all")
	public List<User> show() {
		List<User> users = userService.getAllUsers() ; 
		return users ; 
	}
	
	/*
	@GetMapping("/login")
		public String Login (@RequestBody User user) {
            return userService.UserLogin(user.getUserName(),user.getPassword()); 		
	}*/
	
	@GetMapping("/Delete")
	public String DeleteUser(@RequestBody User user) {
		long userid =  userService.getUserId(user) ; 
		return userService.DeleteAccount(userid) ; 
	}
	
}
