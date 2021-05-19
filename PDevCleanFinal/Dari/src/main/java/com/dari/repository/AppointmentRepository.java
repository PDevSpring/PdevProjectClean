package com.dari.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dari.model.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
