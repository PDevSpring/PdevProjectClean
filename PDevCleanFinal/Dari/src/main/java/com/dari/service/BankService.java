package com.dari.service;

import java.util.List;

import com.dari.model.Agent;
import com.dari.model.Bank;


public interface BankService  {

	void addbank(Bank bank);
	
	Bank updateBank (Long bankID,Bank bank);
	
	void deleteBankByID(Long bankID);
	
	Bank getBankByName(String nameBank);
	
	Bank getBankById(Long id);
	
	List<Bank> getAllBank();

	Bank findnb(String namebank);
	
	Agent getagentbynamebank(String namebank);

	void addagent(Agent agent, Long idbank);

	List<Agent> getAllagents();

	void deleteAgentByID(Long agentID);

}
