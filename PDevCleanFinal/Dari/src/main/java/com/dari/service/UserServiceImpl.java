package com.dari.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dari.model.User;
import com.dari.model.VerificationToken;
import com.dari.repository.UserRepository;
import com.dari.repository.VerificationTokenRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
    private UserRepository userRepository ; 
	@Autowired
	private VerificationTokenRepository verificationTokenRepository ; 
	@Autowired
	private MailSendService mailSendService ; 
	
	@Override
	public void addAdmin(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole("Admin");
		user.setCreated(Instant.now());
		user.setEnabled(true);
		userRepository.save(user); 
	}
	
	@Override
	public void addClient(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole("Client");
		user.setCreated(Instant.now());
		user.setEnabled(false);
		userRepository.save(user); 
		
		String token=generateVerificationToken(user); 
		mailSendService.sendEmail(user.getEmail(),"Please Click On The Link Bellow To Confirm : http://localhost:3000/App/Verif/"+token,"Please Confirm Your Account");
		
		
	}
	
	
	private String generateVerificationToken(User user) {
		String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
	}
	
	private void fetchUserAndEnable(VerificationToken verificationToken) {
        String username = verificationToken.getUser().getUserName();
        User user = userRepository.findByUserName(username);
        user.setEnabled(true);
        userRepository.save(user);
    }
	
	public void verifyAccount(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        fetchUserAndEnable(verificationToken);
    }
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users ; 
	}
	
	@Override
	public long getUserId(User user) {
		long id=0 ; 
		List<User> users =  getAllUsers() ;
		for (User user1:users) {
			if (user.getUserName().equals(user1.getUserName())) {
				id=user1.getId() ; 
			}
			
		}
		return id; 
	}
	
	@Override
	public String UserLogin(String userName , String password) {
		boolean state = false  ;
		String who = null ; 
		List<User> users =  getAllUsers() ;
		for(User user:users)
		{
			if (user.getUserName().equals(userName))
			{
			 state = new BCryptPasswordEncoder().matches(password, user.getPassword()) ; 
			 if (state == true ) { who = user.getRole() ; break ;} 
			 else return "Incorrect Password" ; 
			}
			else return "User Doen't Exist " ; 
		}
		
		
		return ("Hello" + who );    
	}
	
	@Override
	public String DeleteAccount(long id) {
		userRepository.deleteById(id);
		return "Deleted"; 
	}
	

}

