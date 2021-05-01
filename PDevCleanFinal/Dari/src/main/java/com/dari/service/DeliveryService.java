package com.dari.service;

import com.dari.model.Delivery;

public interface DeliveryService {

	Delivery finddeliverybyid(Long iddel);

	void deletedeliverybyid(Long iddel);

	Delivery modadressdelivery(Long iddel, String adr);

	
	Delivery adddelivery(Delivery del);

}
