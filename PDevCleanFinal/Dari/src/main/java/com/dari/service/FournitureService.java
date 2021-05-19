package com.dari.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.dari.model.FileDB;
import com.dari.model.Fourniture;

public interface FournitureService {

	void deleteFour(long FournitureId);

	Fourniture findFourniture(long FournitureId);
	
	public List<Fourniture> getallfourniture();

	Fourniture BuyFourniturebyid(long fid);

	Fourniture AddFour(Fourniture f, Long userid);

	FileDB store(Fourniture f, MultipartFile file) throws IOException;

	FileDB getim(Long id);

	FileDB saveImage(FileDB p);

	Fourniture updateFourniture(Fourniture four);

	List<Fourniture> getOwner(Long userid);



	
	  
	 // float getfourniturepricebyid(long FournitureId);
	


	//FournitureType checkfourstatusbyid(long FournitureId);

	//FournitureType BuyFourniturebyid(long fourid, FournitureType NotDispo);

	//void changefourniturestatusbyid(long FournitureId, FournitureType NotDispo);
	
	//public FType checkfourstatusbyid (long FournitureId);
	
		//public float getfourniturepricebyid(long FournitureId);

}
