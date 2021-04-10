package com.dari.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.filter.JwtProvider;
import com.dari.model.Message;
import com.dari.repository.MessagesRepository;

@Service
public class MessagesServiceImpl implements MessagesService {
	
	@Autowired
	private MessagesRepository messagesRepository ; 
	@Autowired
	private JwtProvider jwtProvider ; 
	
	@Override
	public void sendMessage(String token,Message message) {
		message.set_from(jwtProvider.extractUsername(token));
		messagesRepository.save(message); 
	}
	
	@Override
	public List<Message> getAllMessages() {
		List<Message> allmessages = (List<Message>) messagesRepository.findAll();
		return allmessages; 
	}	
	
	@Override
	public List<Message> getAllUserMessages(String token) {
		List<Message> messages = new ArrayList<Message>() ;
		List<Message> allmessages = getAllMessages();
		for (Message message:allmessages) {
			if (message.get_from().equals(jwtProvider.extractUsername(token))) {
				messages.add(message);
			}
		}
		return messages; 
	}	
	
	@Override
	public void deleteMessage(long id) {
		messagesRepository.deleteById(id);
	}
	
	public String getSender(long id) {
		List<Message> allmessages = getAllMessages();
		String sender = null ; 
		for (Message message:allmessages) {
			if (message.getMessageId()==id) {
				sender = message.get_from();
			}
		}
		return sender ; 
	}
	
	@Override
	public void Reply(String token,Message message,long id) {
		message.set_from(jwtProvider.extractUsername(token));
		message.set_to(getSender(id));
		messagesRepository.save(message); 
	}
	
	
	

}
