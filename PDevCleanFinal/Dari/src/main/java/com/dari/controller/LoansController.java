package com.dari.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.Agent;
import com.dari.model.LoansSimulationBank;
import com.dari.model.User;
import com.dari.repository.AgentRepository;
import com.dari.repository.LoansRepository;
import com.dari.service.BankService;
import com.dari.service.LoansService;
import com.dari.service.MailService;
import com.dari.service.PdfService;
import com.fasterxml.jackson.annotation.JsonIgnore;


@RestController
@RequestMapping("/Loan")
public class LoansController {
	
	
	@Autowired
	private PdfService pdfservice;
	
	@Autowired
	private MailService mailservice;
	
	@Autowired
	BankService bankservice;
	
	@Autowired
	LoansService loanservice;
	
	@Autowired
	AgentRepository agrepository;
	
	@Autowired
	LoansRepository loanrepository;
	
	//autowired mail
	
	//simulate a loan
	
	@PostMapping("/Simulate/{idad}/{nameBank}/{years}/{salaire}")
	@ResponseBody
	public LoansSimulationBank Simulate(@PathVariable long idad,
										@PathVariable String nameBank,
										@PathVariable int years,
										@PathVariable double salaire)
	{
		LoansSimulationBank result= loanservice.simulate(nameBank, years, idad, salaire);
		return result;	
	}
	
	//http://localhost:3000/SpringMVC/servlet/loan/getagent
	@JsonIgnore
	@GetMapping("/getagent/{nameBank}")
    @ResponseBody
    public Agent getagent (@PathVariable  String nameBank)
    {
    	
    	return bankservice.getagentbynamebank(nameBank);
	
}
	//add simulation
		@PostMapping("/Sim/{idad}/{iduser}/{nameBank}/{years}/{salaire}")
		@ResponseBody
		public LoansSimulationBank Simulation(@PathVariable int idad,
											@PathVariable Long iduser,
											@PathVariable String nameBank,
											@PathVariable int years,
											@PathVariable double salaire) throws MailException, MessagingException
		{
			
			LoansSimulationBank loan=loanservice.addLoan(nameBank, years, idad, salaire, iduser);
			return loan;
			
		}
	
	
	
	//add simulation
	@PostMapping("/addloan/{idad}/{iduser}/{nameBank}/{years}/{salaire}")
	@ResponseBody
	public String addSimulation(@PathVariable int idad,
										@PathVariable Long iduser,
										@PathVariable String nameBank,
										@PathVariable int years,
										@PathVariable double salaire) throws MailException, MessagingException
	{
		
		loanservice.addLoan(nameBank, years, idad, salaire, iduser);
		return ("loan simulation added");
		
	}
	
	//get all simulations
	
	@GetMapping("/getAllloans")
    @ResponseBody
	public List<LoansSimulationBank> getAllSimulations()
	{	
		return loanservice.getAllLoans();
	}
	
	//get all simulations by bank 
	@GetMapping("/getAllloansBynameBank/{nameBank}")
    @ResponseBody
	public List<LoansSimulationBank> getAllSimulationsByNameBank(@PathVariable("nameBank") String nameBank ) {	
		return loanservice.getAllLoansByNameBank(nameBank);
	}
	
	// delete simulation by id
	@DeleteMapping("/deleteById/{id}")
	@ResponseBody 
	public Long deleteSimulationById(@PathVariable("id") Long id )
	{
			loanservice.deleteLoanById(id);
			return id;
	}
	
	// confirm simulation by id
	@PutMapping("/confirm/{id}")
	@ResponseBody 
	public void confirmSimulation(@PathVariable("id") Long id )throws MailException, MessagingException{
		loanservice.confirmLoan(id);
		}
	
	// Unconfirm simulation by id
	@PutMapping("/unconfirm/{id}")
	@ResponseBody 
	public void unconfirmSimulation(@PathVariable("id") Long id )throws MailException, MessagingException{
		loanservice.unConfirmLoan(id);
		}
	
	@PostMapping("/pdf/{idloan}")
	@ResponseBody
	public String pdf(@PathVariable long idloan) {
		
		 pdfservice.toPDF(idloan);
		 return "pdf generated";
	}
	
	@PostMapping("/mail/{idloan}")
	@ResponseBody
	public String emailwithpddf(@PathVariable long idloan) throws MailException, MessagingException {
		Agent agent =loanservice.getLoansById(idloan).getAgent();
		User user =loanservice.getLoansById(idloan).getUser();
		 mailservice.sendWithAttachment(user, agent, pdfservice.toPDF(idloan));
		 return "pdf generated";
	}
	
	
	
	
	
	
	
	
	
	
	

}
