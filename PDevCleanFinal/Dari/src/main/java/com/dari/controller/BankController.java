package com.dari.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.Agent;
import com.dari.model.Bank;

import com.dari.service.BankService;
import com.dari.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
@RequestMapping ("/Bank")
public class BankController {

	

	
	@Autowired
	UserService UsersService;
	@Autowired
	UserController UsersController;
	
	@Autowired
	private BankService bankService ; 
	
		//zid delete agent

	//http://localhost:3000/SpringMVC/servlet/Bank/addagent
	@PostMapping("/addagent/{bankId}")
	public Agent Addagent (@RequestBody Agent agent,@PathVariable("bankId") Long bankId) {
	bankService.addagent(agent,bankId);
	return agent;
	}
	
	//http://localhost:3000/SpringMVC/servlet/Bank/addBank
	@PostMapping("/addBank")
	public Bank AddB (@RequestBody Bank bank) {
	bankService.addbank(bank);
	return bank;
	}
	/*{
	    "bankId": 3 ,
    "namebank": "azer",
    "Descbank": 0,
    "Adressbank": "DAREK",
    "MargeInteretbank": 12.2 ,
    "taux": 12.0
    }
    
	 * 
	 * 
	 */
	
	@PutMapping("/updateBank")
	@ResponseBody
	public Bank updateBank (@RequestBody Bank bank) {
	return bankService.updateBank(bank);
	}
	
	@DeleteMapping("/deleteBank/{bankId}")
	public String deleteBankByID(@PathVariable("bankId") Long bankId) {
		Bank bank = bankService.getBankById(bankId);
		bankService.deleteBankByID(bankId);
		return "bank "+ bank.namebank +" has been deleted";
	}
	
	@GetMapping("/getBankById/{id}")
	@ResponseBody
	public Bank getBankById(@PathVariable("id") Long id) {
		return bankService.getBankById(id);
	}
	
	@GetMapping("/getallBanks")
	@ResponseBody
	public List<Bank> getAllBanks() {
		
	 	List<Bank> banks = bankService.getAllBank();
	 	return banks;
	}
	
	@GetMapping("/getBankname/{namebank}")
	@ResponseBody
	public Bank findbankname (@PathVariable("namebank") String namebank)
	{
		return bankService.findnb(namebank);
	}
	
	
	//http://localhost:3000/SpringMVC/servlet/Bank/getagent
	@JsonIgnore
	@GetMapping("/getagent/{nameBank}")
    @ResponseBody
    public List<Agent> getag (@PathVariable  String nameBank)
    {
    	
    	return (List<Agent>) bankService.getagentbynamebank(nameBank);
	
}
	
}
