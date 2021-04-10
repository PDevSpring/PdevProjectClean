package com.dari.service;

import java.util.List;

import com.dari.model.Message;

public interface MessagesService {

	void sendMessage(String token, Message message);

	List<Message> getAllUserMessages(String token);

	void deleteMessage(long id);

	List<Message> getAllMessages();

	void Reply(String token, Message message, long id);


}
