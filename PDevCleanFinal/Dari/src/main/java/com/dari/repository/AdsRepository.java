package com.dari.repository;


import java.util.List;
import java.util.Map;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dari.model.Ads;


public interface AdsRepository  extends CrudRepository<Ads, Long> {

	Ads findByAdID(long AdID);

	
}
