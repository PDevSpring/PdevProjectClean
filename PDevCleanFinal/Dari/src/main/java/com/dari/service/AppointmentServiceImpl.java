package com.dari.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Appointment;
import com.dari.model.User;
import com.dari.repository.AdsRepository;
import com.dari.repository.AppointmentRepository;
import com.dari.repository.UserRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	AppointmentRepository apprepository;
	@Autowired
	UserRepository userrepository;
	@Autowired
	AdsRepository adrepository;
	
	@Override
	public List<Appointment> retrieveAllAppointment() {
		List<Appointment> app=(List<Appointment>) apprepository.findAll();
		return app;
	}
	
	@Override
	public Appointment addAppointment(Appointment a,Long idAd) {
		User usr= adrepository.findByAdID(idAd).getUser();
		List<Appointment> app=(List<Appointment>) apprepository.findAll();
		a.setUser(usr);

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
	public void deleteAppointment(Long id) {
		
		apprepository.deleteById(id);		

		
	}

	
}
