package com.dari.service;

import java.util.List;

import com.dari.model.User;

public interface UserService  {

	void addAdmin(User user);

	void addClient(User user);

	List<User> getAllUsers();

	long getUserId(User user);

	String UserLogin(String userName, String password);

	String DeleteAccount(long id);
	
	void verifyAccount(String token);
	
	
	



	

	

	

}
