package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserName(String username);
}
