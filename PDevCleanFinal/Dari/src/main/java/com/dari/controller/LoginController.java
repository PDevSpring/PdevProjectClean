package com.dari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
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
@RequestMapping("/home")
public class LoginController {
	
	@Autowired
	private UserService userService ;
	@Autowired
	private AuthenticationManager authenticationManager ;
	@Autowired
	private JwtProvider jwtProvider ; 
	@Autowired
	private UserDetService userDetailsService ; 
	
	
	@GetMapping("/Login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {

		authenticate(loginRequest.getUsername(), loginRequest.getPassword());
					
		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

		final String jwt = jwtProvider.generateToken(userDetails);
		
		return ResponseEntity.ok(new LoginResponse(jwt));
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

}
