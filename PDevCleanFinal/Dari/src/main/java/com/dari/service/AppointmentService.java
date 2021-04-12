package com.dari.service;

import java.util.Date;
import java.util.List;

import com.dari.model.Appointment;

public interface AppointmentService {

	List<Appointment> retrieveAllAppointment();

	Appointment addAppointment(Appointment a, Date date);

	void deleteAppointment(String id);

}
