
package com.dari.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Rent;
import com.dari.model.RentType;
import com.dari.model.Sell;
import com.dari.repository.RentRepository;
import com.dari.repository.SellRepository;
@Service
public class SellAndRentServiceImpl implements SellAndRentService{

public static final Logger L = LogManager.getLogger(SellAndRentServiceImpl.class);
	
	@Autowired
	SellRepository sellRepository;
	@Autowired
	RentRepository rentRepository;
	
////1er filtre : Séparation entre les annonces de vente et de Location
	
	@Override
	public List<Sell> SellAds() {
		List<Sell> wls=(List<Sell>)sellRepository.findAll();
		for (Sell s : wls) {
			L.info("Sell List +++"+s);
		}
		return wls;	
	}
	
	@Override
	public List<Rent> RentAds() {
		List<Rent> wls=(List<Rent>)rentRepository.findAll();
		for (Rent s : wls) {
			L.info("Rent List +++"+s);
		}
		return wls;
	}
	
	@Override
	public List<Rent> RentAdsTypeRent() {
		// TODO Auto-generated method stub
		List<Rent> list=(List<Rent>)rentRepository.findAll();
		List<Rent> list1= new ArrayList<>();
		for (Rent r : list){
			if (r.getRenttype().equals(RentType.RENT))
			{
				
				list1.add(r);
			}
		}
		L.info("Rent List +++"+list1);
		return list1;
	}
	
	
	@Override
	public List<Rent> RentAdsTypeHolidays()
	{
		List<Rent> list=(List<Rent>)rentRepository.findAll();
		List<Rent> list1= new ArrayList<>();
		for (Rent r : list){
			if (r.getRenttype().equals(RentType.HOLIDAYS_RENTING))
			{
			
				list1.add(r);
			}
		}
		L.info("Rent List"+list1);
		return list1;
	}
	
	@Override
	public List<Rent> RentAdsTypeTemp() {
		// TODO Auto-generated method stub
		List<Rent> list=(List<Rent>)rentRepository.findAll();
		List<Rent> list1= new ArrayList<>();
		for (Rent r : list){
			if (r.getRenttype().equals(RentType.TEMPORARY_RENTING))
			{
				
				list1.add(r);
			}
		}
		L.info("Rent list +++"+list1);
		return list1;
	}
	
}
