package com.dari.service;

import java.util.Date;
import java.util.List;

import com.dari.model.Appointment;

public interface AppointmentService {

	List<Appointment> retrieveAllAppointment();


	void deleteAppointment(Long id);



	Appointment addAppointment(Appointment a, Long idAd);


	List<Appointment> getappbyadid(Long id);

}
