package com.dari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.LoansSimulationBank;
@Repository
public interface LoansRepository  extends CrudRepository <LoansSimulationBank, Long> {

	@Query(value="SELECT * FROM T_Loans l join Banks b on l.bank_idbank=b.idbank WHERE b.namebank=?1",nativeQuery=true)
	List<LoansSimulationBank> getAllLoansByNameBank(String Namebank);


}
