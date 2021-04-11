package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.Bank;


@Repository
public interface BankRepository  extends CrudRepository<Bank, Long> {

	//Bank getBankByNamebank (Bank bank) ;
	/*
    @Query(value = "SELECT * FROM t_banks WHERE namebank=?1",nativeQuery=true)
	Bank getBankByName(String Namebank);

    @Query("SELECT * FROM Bank WHERE idbank=?1") 
	Bank getBankById(Long Idbank);
	
    
    @Query(value = "SELECT * FROM t_banks",nativeQuery=true) 
	List<Bank> getAllBanks();
*/	
	
	
    Bank findByNamebank(String namebank);
}
