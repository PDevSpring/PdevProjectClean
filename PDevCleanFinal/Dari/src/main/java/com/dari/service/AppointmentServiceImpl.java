package com.dari.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dari.model.Appointment;
import com.dari.repository.AppointmentRepository;
import com.dari.repository.UserRepository;


public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	AppointmentRepository apprepository;
	@Autowired
	UserRepository userrepository;
	
	
	@Override
	public List<Appointment> retrieveAllAppointment() {
		List<Appointment> app=(List<Appointment>) apprepository.findAll();
		return app;
	}
	
	@Override
	public Appointment addAppointment(Appointment a,Date date) {
		List<Appointment> app=(List<Appointment>) apprepository.findAll();

		for(Appointment aa:app) {
		
		if (aa.getDate().compareTo(a.getDate()) > 0) {
			
			a.setState("confirmed");
			
		}
		else if (a.getDate().compareTo(a.getDate()) < 0) {
			a.setState("confirmed");
			}
		else {
			a.setState("not confirmed same date");
		}

	}
		apprepository.save(a);

		return a;
	}
	
	
	@Override
	public void deleteAppointment(String id) {
		
		apprepository.deleteById(Long.parseLong(id));		

		
	}

	
}
