package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dari.model.Appointment;
import com.dari.service.AppointmentService;

@RestController
@RequestMapping("/App")
public class AppointmentControler {

	@Autowired AppointmentService appservice;
	
	
	@GetMapping("/test")
	public String test() {
		return "working fine ! " ; 
	}
	
	@GetMapping("/allapps")
	  List<Appointment> all() {
	    return (List<Appointment>) appservice.retrieveAllAppointment();
}
	@PostMapping ("/newapp/{ID}")
	@ResponseBody
	Appointment Newappoi (@RequestBody Appointment app,@PathVariable("ID") Long adID) {
		return appservice.addAppointment(app,adID);
	}
	
	@DeleteMapping("/deleteapp/{appid}")
	@ResponseBody
	public void deleteapp(@PathVariable("appid") Long id) {
	appservice.deleteAppointment(id);
	}
	
}
