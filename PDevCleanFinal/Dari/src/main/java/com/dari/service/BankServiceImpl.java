package com.dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Agent;
import com.dari.model.Bank;
import com.dari.repository.AgentRepository;
import com.dari.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository bankRepository;
	@Autowired
	private AgentRepository agentRepository;
	
	
	@Override
	public List<Bank> getAllBank() {
		List<Bank> bank = (List<Bank>) bankRepository.findAll();
		return bank ; 
	}
	
	
	public void addbank(Bank bank) {
	
		 bankRepository.save(bank);
		 
		//return bank.getBankId();
		
	}
	
	
	public Bank updateBank (Bank bank) {
		return bankRepository.save(bank);
	}
	
	@Override
	public void deleteBankByID(Long bankID) {
		Bank bank = bankRepository.findById(bankID).get();
		bankRepository.delete(bank);
		
	}
	

	@Override
	public Bank getBankByName(String nameBank) {
		return  bankRepository.findByNamebank(nameBank);
		
	}
	
	@Override
	public Bank getBankById(Long id) {	
		Bank bank = bankRepository.findById(id).get();
		return bank;
		
	}


	@Override
	public Bank findnb(String namebank) {
	Bank bank = bankRepository.findByNamebank(namebank);
		return bank;
	}
	


	@Override
	public void addagent(Agent agent,Long idbank) {
		 Bank bank =bankRepository.findById(idbank).get();
		 agent.setBank(bank);
		 agentRepository.save(agent);
		 bank.setAgent(agent);
		 bankRepository.save(bank);
		
		 
		
	}
	
	@Override
	public Agent getagentbynamebank(String namebank)
	{
		Bank bank =  bankRepository.findByNamebank(namebank);
		Agent agent = bank.getAgent();
		return agent;
	}
	
}
