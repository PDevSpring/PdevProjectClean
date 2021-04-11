package com.dari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Delivery;
import com.dari.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired 
	DeliveryRepository delrep;
	
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
	public	Delivery finddeliverybyid(Long iddel)
	{	
		return delrep.findById(iddel).get();
	}
	
	
	@Override
	public	void deletedeliverybyid(Long iddel)
	{	
		delrep.deleteById(iddel);
	}
	
	
}
