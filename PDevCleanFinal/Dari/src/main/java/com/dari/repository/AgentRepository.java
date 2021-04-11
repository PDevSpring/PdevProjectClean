package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.Agent;


@Repository
public interface AgentRepository  extends CrudRepository<Agent,Long>  {

	//@Query("SELECT * FROM dari.banks b join dari.Agents a on a.idag=b.agentb_idag WHERE b.namebank= :Bankname")
	//Agent getAgentnamebank(@Param("Bankname")String namebank);
}
