package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
	

}
