package com.dari.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dari.model.Ads;
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
		
		Ads ad = adrepository.findByAdID(idAd);
		User usr= ad.getUser();
		List<Appointment> app=(List<Appointment>) apprepository.findAll();
		a.setUser(usr);
		a.setAd(ad);
		System.out.println(a);
		System.out.println(ad);

		for(Appointment aa:app) {
		
		if (aa.getDate().compareTo(a.getDate()) > 0) {
			System.out.println("conf");

			
			a.setState("confirmed");
			
		}
		else if (a.getDate().compareTo(a.getDate()) < 0) {
			System.out.println("conf1");

			a.setState("confirmed");
			}
		else {
			System.out.println("notconf1");

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
	
	@Override
	public List<Appointment> getappbyadid(Long id) {
		
		List<Appointment> Appall= retrieveAllAppointment();
		List<Appointment> adapp = new ArrayList<>();
		for(Appointment app : Appall) {
			if(app.getAd().getAdID() == id) {
				adapp.add(app);
			}
		}
		return adapp;
		
	}

	
}
