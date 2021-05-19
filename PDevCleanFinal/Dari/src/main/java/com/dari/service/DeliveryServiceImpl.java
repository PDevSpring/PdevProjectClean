package com.dari.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Delivery;
import com.dari.model.Fourniture;
import com.dari.repository.CartRepository;
import com.dari.repository.DeliveryRepository;
import com.dari.repository.FournitureRepository;
import com.dari.repository.UserRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired 
	DeliveryRepository delrep;
	@Autowired 
	UserRepository userrep;
	@Autowired 
	CartRepository cartrep;
	@Autowired 
	FournitureRepository fourrep;
	
	@Override
	public	Delivery adddelivery(Delivery del)
	{
		return delrep.save(del);
	}
	
	
	@Override
	public	Delivery modadressdelivery(Long iddel,String adr)
	{	Delivery del = delrep.findById(iddel).get();
		del.setAdress(adr);
		return delrep.save(del);
	}
	
	@Override 
	public Delivery getownertodeliver(Long fid) {
		return fourrep.findById(fid).get().getDelivery();
	}
	
	
	@Override
	public	Delivery finddeliverybyid(Long iddel)
	{	
		return delrep.findById(iddel).get();
	}
	
	@Override
	public	List<Delivery> finddeliverybyuserid(Long iduser)
	{	
		List<Delivery> delall= getalldeleviry();
		List<Delivery> delalluser = new ArrayList<>();
		for(Delivery del :delall) {
			if(del.getUser().getId()==iduser) {
				delalluser.add(del);
			}
		}
		
		return delalluser;
	}
	
	
	@Override
	public	void deletedeliverybyid(Long iddel)
	{	
		delrep.deleteById(iddel);
	}
	
	@Override 
	public List<Delivery> getalldeleviry  ()
	{
		return (List<Delivery>) delrep.findAll();
		
	}
	
}
