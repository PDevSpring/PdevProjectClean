package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dari.filter.JwtProvider;
import com.dari.model.User;
import com.dari.requests.LoginRequest;
import com.dari.requests.LoginResponse;
import com.dari.service.UserDetService;
import com.dari.service.UserService;


@RestController
@RequestMapping("/App")
public class UserController {

	
	@Autowired
	private UserService userService ; 
	@Autowired
	private AuthenticationManager authenticationManager ;
	@Autowired
	private JwtProvider jwtProvider ; 
	@Autowired
	private UserDetService userDetailsService ; 
	
	
	
	
	
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
	
	
	@GetMapping("/Login")
		public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {

			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), new BCryptPasswordEncoder().encode(loginRequest.getPassword())));
			}
			catch (BadCredentialsException e) {
				throw new Exception("Incorrect username or password", e);
			}


			final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

			final String jwt = jwtProvider.generateToken(userDetails);

			return ResponseEntity.ok(new LoginResponse(jwt));
		}
	
	
	
	
	
	
	@GetMapping("/all")
	public List<User> show() {
		List<User> users = userService.getAllUsers() ; 
		return users ; 
	}
	
	
	@GetMapping("/Delete")
	public String DeleteUser(@RequestBody User user) {
		long userid =  userService.getUserId(user) ; 
		return userService.DeleteAccount(userid) ; 
	}
	
}
