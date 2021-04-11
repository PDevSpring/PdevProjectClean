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

@Service
public class FournitureServiceImpl implements FournitureService {

	@Autowired
	FournitureRepository fourrep;

	@Override
	public long AddFour(Fourniture f) {
		FournitureType type = null;
		f.setType(type.Dispo);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
	     f.setPubDate(dateFormat.format(date));
		fourrep.save(f);
		return f.getFournitureId();
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
		for(Fourniture f:fours  ) {
			System.out.println(f);
		}
		return fours;
	}
	
	
	
	
	@Override
	public Fourniture BuyFourniturebyid (long fid) {
		FournitureType type = null;
		Fourniture four = findFourniture(fid);
		if(four.getType() == type.Dispo){
			four.setType(type.NotDispo);
			fourrep.save(four);
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
