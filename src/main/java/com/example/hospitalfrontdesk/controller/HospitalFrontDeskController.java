package com.example.hospitalfrontdesk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalfrontdesk.dto.SpecialistDto;
import com.example.hospitalfrontdesk.entity.Appointment;
import com.example.hospitalfrontdesk.service.HospitalFrontDeskService;

@RestController
public class HospitalFrontDeskController {
	
	@Autowired
	HospitalFrontDeskService hospitalFrontDeskService;

	
	@GetMapping("${specialistTypeUrl}")
	public List<SpecialistDto> getListOfSpecialists(@PathVariable String hospitalName, @PathVariable String specialistType) {
		
		return hospitalFrontDeskService.getListOfSpecialists(hospitalName, specialistType);
		
	}
	
	@PostMapping("${bookAppointmentUrl}")
	public Appointment createAppointment(@PathVariable String doctorName, @PathVariable String appointmentDay,
			@RequestParam(name = "patient", required = true) String patientName) {
		
		return hospitalFrontDeskService.createAppointment(doctorName, appointmentDay, patientName);
		
	}
	
	@GetMapping("${numberOfBedsUrl}")
	public String getNumberOfBedsAvailable(@PathVariable String hospitalName) {
		
		return hospitalFrontDeskService.fetchNumberOfBedsAvailable(hospitalName);
	}
	
	 

}
