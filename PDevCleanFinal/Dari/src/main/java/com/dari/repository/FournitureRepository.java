package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.Fourniture;
@Repository
public interface FournitureRepository extends CrudRepository<Fourniture, Long> {

	}
