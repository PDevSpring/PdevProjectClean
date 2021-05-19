package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dari.model.Ads;

public interface FilterAds extends CrudRepository<Ads, Long>{
	

}
