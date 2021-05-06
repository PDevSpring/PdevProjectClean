package com.dari.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;

import com.dari.model.Agent;
import com.dari.model.LoansSimulationBank;

public interface LoansService {

	List<LoansSimulationBank> getAllLoans();

	List<LoansSimulationBank> getAllLoansByNameBank(String namebank);

	LoansSimulationBank getLoansById(Long id);

	LoansSimulationBank deleteLoanById(Long id);

	void confirmLoan(Long idloan);

	void unConfirmLoan(Long idloan);

	LoansSimulationBank approcheLoan();

	LoansSimulationBank addLoan(String namebank, int years, int AdID, double salaire, Long iduser) throws MailException, MessagingException;


	LoansSimulationBank simulate(String nameBank, int nbrAnnee, long idad, double salaire);

	




}
