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
	
	@Override
	public List<Agent> getAllagents() {
		List<Agent> agents = (List<Agent>) agentRepository.findAll();
		return agents ; 
	}
	
	
	public void addbank(Bank bank) {
	
		 bankRepository.save(bank);
		 
		//return bank.getBankId();
		
	}
	
	
	public Bank updateBank (Long bankID,Bank bank) {
		Bank oldbank = bankRepository.findById(bankID).get();
		
		oldbank.setTaux(bank.taux);
		oldbank.setDescbank(bank.descbank);
		oldbank.setMargeInteretbank(bank.margeInteretbank);
		oldbank.setAdressbank(bank.adressbank);
		oldbank.setNamebank(bank.namebank);
		
		return bankRepository.save(oldbank);
	}
	
	@Override
	public void deleteBankByID(Long bankID) {
		Bank bank = bankRepository.findById(bankID).get();
		bankRepository.delete(bank);
		
	}
	
	@Override
	public void deleteAgentByID(Long agentID) {
		Agent agent = agentRepository.findById(agentID).get();
		agentRepository.delete(agent);
		
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
