package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dari.model.Message;

@Repository
public interface MessagesRepository extends CrudRepository<Message, Long> {

}
