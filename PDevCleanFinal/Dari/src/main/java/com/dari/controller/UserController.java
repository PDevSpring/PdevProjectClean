package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	
	@PostMapping("/adminArea/registerAdmin")
	public String RegisterAdmin(@RequestBody User user) {
		userService.addAdmin(user);
		return "RegistrationDone! "; 
	}
	
	@GetMapping("/adminArea/all")
	public List<User> show() {
		List<User> users = userService.getAllUsers() ; 
		return users ; 
	}
	
	@DeleteMapping("/adminArea/Delete/{id}")
	public String DeleteUser(@PathVariable long id) { 
		return userService.DeleteAccount(id) ; 
	}
	
	@GetMapping("/profil")
	public String wlc() {
		return "welcome To Your Profil ! " ; 
	}
	
	@GetMapping("/profil/search")
	public User findUser(@RequestBody String username) {
	User user = userRepository.findByUserName(username); 
	if (user.getRole().equals("Client")) {
		return user ;
	}
	else return null  ; 
	}
	
	@PutMapping("/profil/change/{id}")
	public String updateAccount(@PathVariable long id,@RequestBody User user) {
		return userService.UpdateAccount(id, user); 
	}
	
	
}
