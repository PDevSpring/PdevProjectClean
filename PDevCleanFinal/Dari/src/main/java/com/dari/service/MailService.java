package com.dari.service;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import com.dari.model.Agent;
import com.dari.model.User;

public interface MailService {

	void Send(User user) throws MailException;

	void sendWithAttachment(User user, Agent agent, String attachement) throws MailException, MessagingException;

	void Sendd(String email, String body, String subject);

}
