package com.dari.service;

import java.util.List;

import com.dari.model.Fourniture;
import com.dari.model.FournitureType;

public interface FournitureService {

	long AddFour(Fourniture f);

	void deleteFour(long FournitureId);

	Fourniture findFourniture(long FournitureId);
	
	public List<Fourniture> getallfourniture();

	Fourniture BuyFourniturebyid(long fid);

	
	  
	 // float getfourniturepricebyid(long FournitureId);
	


	//FournitureType checkfourstatusbyid(long FournitureId);

	//FournitureType BuyFourniturebyid(long fourid, FournitureType NotDispo);

	//void changefourniturestatusbyid(long FournitureId, FournitureType NotDispo);
	
	//public FType checkfourstatusbyid (long FournitureId);
	
		//public float getfourniturepricebyid(long FournitureId);

}
