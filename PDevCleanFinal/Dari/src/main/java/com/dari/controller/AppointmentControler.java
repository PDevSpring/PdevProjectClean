package com.dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*" )
@RestController
@RequestMapping("/App")
public class AppointmentControler {

	@Autowired AppointmentService appservice;
	
	@GetMapping("/allapps")
	  List<Appointment> all() {
	    return (List<Appointment>) appservice.retrieveAllAppointment();
}
	@PostMapping ("/newapp/{ID}")
	@ResponseBody
	Appointment Newappoi (@RequestBody Appointment app,@PathVariable("ID") Long adID) {
		System.out.println(adID);

		return appservice.addAppointment(app,adID);
	}
	
	@DeleteMapping("/deleteapp/{appid}")
	@ResponseBody
	public void deleteapp(@PathVariable("appid") Long id) {
	appservice.deleteAppointment(id);
	}
	

	@GetMapping("/allappsbyad/{adid}")
	  List<Appointment> getallAppbyAD(@PathVariable("adid") Long id) {
		System.out.println(id);

	    return (List<Appointment>) appservice.getappbyadid(id);
}
	
}
