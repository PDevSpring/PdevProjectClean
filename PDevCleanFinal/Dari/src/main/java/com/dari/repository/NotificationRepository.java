package com.dari.repository;


import org.springframework.data.repository.CrudRepository;

import com.dari.model.Notification;

public interface NotificationRepository  extends CrudRepository<Notification, Integer> {

	

}
