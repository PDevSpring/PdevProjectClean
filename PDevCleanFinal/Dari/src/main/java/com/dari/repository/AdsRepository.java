package com.dari.repository;


import org.springframework.data.repository.CrudRepository;

import com.dari.model.Ads;


public interface AdsRepository  extends CrudRepository<Ads, Long> {

	Ads findByAdID(long AdID);
}
