package com.dari.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.Message;
import com.dari.service.MessagesService;

@RestController
@RequestMapping("/App/clientarea")
public class MessagesController {
	
	@Autowired
	private MessagesService messagesService ; 
	
	@PostMapping("/sendTo")
	public String sending(@RequestHeader String Authorizations ,@RequestBody Message message) {
		String token = Authorizations.replaceFirst("Bearer ", "");
		messagesService.sendMessage(token, message);
		return "Your message was sent with success";
	}
	
	@GetMapping("/Messages")
	public Message retrieve(@RequestHeader String Authorizations) {
		String token = Authorizations.replaceFirst("Bearer ", "");
		List<Message> messages = messagesService.getAllUserMessages(token); 
		return (Message) messages ; 
	}
	
	@DeleteMapping("/Messages/Delete/{id}")
	public String Delete(@PathVariable long id) {
		messagesService.deleteMessage(id);
		return "Message Deleted";
	}
	
	@GetMapping("/Messages/{id}")
	public String reply(@RequestHeader String Authorizations,@PathVariable long id,@RequestBody Message message) {
		String token = Authorizations.replaceFirst("Bearer ", "");
		messagesService.Reply(token, message, id);
		return "Message Deleted";
	}

}
