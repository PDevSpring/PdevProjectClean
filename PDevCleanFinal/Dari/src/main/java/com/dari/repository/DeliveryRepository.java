package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.Delivery;
@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long>{

}
