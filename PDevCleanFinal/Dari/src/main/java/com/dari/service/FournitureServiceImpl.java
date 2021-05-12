package com.dari.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Fourniture;
import com.dari.model.FournitureType;
import com.dari.repository.FournitureRepository;
import com.dari.repository.UserRepository;

@Service
public class FournitureServiceImpl implements FournitureService {

	@Autowired
	FournitureRepository fourrep;
	@Autowired
	UserRepository userrep;

	@Override
	public Fourniture AddFour(Fourniture f,Long userid) {
		FournitureType type = null;
		f.setType(type.Dispo);
		f.setUser(userrep.findById(userid).get());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
	     f.setPubDate(dateFormat.format(date));
		fourrep.save(f);
		return f;
	}
	
	@Override
	public void deleteFour (long FournitureId) {
	 	fourrep.deleteById(FournitureId);}
	
	@Override
	public Fourniture findFourniture (long id) {
		return fourrep.findById(id).get() ;
		}
	
	@Override
	public List<Fourniture> getallfourniture(){
		List<Fourniture> fours = (List<Fourniture>) fourrep.findAll();
		return fours;
	}
	
	
	
	
	@Override
	public Fourniture BuyFourniturebyid (long fid) {
		FournitureType type = null;
		Fourniture four = findFourniture(fid);
		if(four.getType() == type.Dispo)
		{
			if( four.getQuantity() == 1) 
			{
			four.setQuantity(0);
			four.setType(type.NotDispo);
			fourrep.save(four);
			}
			
			if( four.getQuantity() > 1) 
			{
			four.setQuantity(four.getQuantity()-1);
			fourrep.save(four);
			}
		
		return four;
		}
			
			else
			{
				return null ;
			}
		
	}
	/*
	public void changefourniturestatusbyid (long fid, FournitureType NotDispo) {
		
		findFourniture(fid).setType(NotDispo);
	}*/
}
