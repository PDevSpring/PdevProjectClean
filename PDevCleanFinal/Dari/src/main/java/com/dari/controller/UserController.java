package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.User;
import com.dari.repository.UserRepository;
import com.dari.service.UserService;


@RestController
@RequestMapping("/App")
public class UserController {

	
	@Autowired
	private UserService userService ;
	@Autowired
	private UserRepository userRepository ; 

	
	@GetMapping("/adminArea/registerAdmin")
	public String RegisterAdmin(@RequestBody User user) {
		userService.addAdmin(user);
		return "RegistrationDone! "; 
	}
	
	@GetMapping("/adminArea/all")
	public List<User> show() {
		List<User> users = userService.getAllUsers() ; 
		return users ; 
	}
	
	@GetMapping("/adminArea/Delete")
	public String DeleteUser(@RequestBody User user) {
		long userid =  userService.getUserId(user) ; 
		return userService.DeleteAccount(userid) ; 
	}
	
	@GetMapping("/profil")
	public String wlc() {
		return "welcome To Your Profil ! " ; 
	}
	
	@GetMapping("/profil/search")
	public User findUser(String username) {
	User user = userRepository.findByUserName(username); 
	return user ; 
	}
	
	
}
