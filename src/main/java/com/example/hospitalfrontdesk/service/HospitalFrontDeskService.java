package com.example.hospitalfrontdesk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.example.hospitalfrontdesk.dto.SpecialistDto;
import com.example.hospitalfrontdesk.entity.Appointment;
import com.example.hospitalfrontdesk.entity.Doctor;
import com.example.hospitalfrontdesk.entity.Hospital;
import com.example.hospitalfrontdesk.exception.HospitalNotFoundException;
import com.example.hospitalfrontdesk.exception.SpecialistNotFoundException;
import com.example.hospitalfrontdesk.repository.AppointmentRepository;
import com.example.hospitalfrontdesk.repository.DoctorRepository;
import com.example.hospitalfrontdesk.repository.HospitalRepository;


@Service
@PropertySource(value="classpath:specialist.properties")
public class HospitalFrontDeskService {
	
	@Value("${specialistname}")
	String[] specialistName;
	
	@Value("${availableDay}")
	String[] availableDay;
	
	@Value("${availableTime}")
	String[] availableTime;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private HospitalRepository hospitalRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	
	public Appointment createAppointment(String doctorName, String appointmentDay, String patientName) {
		
		int doctorIndex = -1;
		for(int i =0; i<specialistName.length; i++) {
			if(specialistName[i].equalsIgnoreCase(doctorName))
				doctorIndex = i;
		}
		
		if(doctorIndex==-1)
			throw new SpecialistNotFoundException("Specialist "+doctorName + " is not available.");
		
		Boolean isDoctorAvailable = availableDay[doctorIndex].equalsIgnoreCase(appointmentDay) ? true:false;
		
		Appointment appointment = new Appointment();
		if(isDoctorAvailable) {
			appointment.setAppointmentDay(appointmentDay);
			appointment.setAppointmentTime(availableTime[doctorIndex]);
			appointment.setPatientName(patientName);
			appointment.setSpecialistName(doctorName);
			appointmentRepository.save(appointment);
		} else {
			throw new SpecialistNotFoundException("Specialist : "+doctorName+" is not available on: "+appointmentDay);
		}
		return appointment;
	}
	
	@Cacheable(cacheNames = "hospital", key = "#hospitalName")
	public Optional<Integer> getHospitalId(String hospitalName) {
		System.out.println("Fetching hospitalId from DB");
		Optional<Integer> hospitalId = hospitalRepository.findIdByName(hospitalName);
		if(!hospitalId.isPresent())
			throw new HospitalNotFoundException("Hospital name: "+hospitalName + " doesn't exist. Please provide a valid Hospital Name.");
	
		return hospitalId;
	}
	
	@Cacheable(cacheNames = "hospital", key = "#hospitalName + #type")
	public List<SpecialistDto> getListOfSpecialists(String hospitalName, String type){
		System.out.println("Fetching from properties file.");
		
		Optional<Integer> hId = getHospitalId(hospitalName);
		List<Doctor> doctor = doctorRepository.findAllByHospitalIdAndType(hId, type);
		if(doctor.size()==0) {
			throw new HospitalNotFoundException(type + " type specialist not available in hospital " + hospitalName);
		}
		
		List<SpecialistDto> response = new ArrayList<>();
		for(Doctor d:doctor) {
			SpecialistDto specialistResponse = new SpecialistDto();
			
			specialistResponse.setType(d.getType());
			specialistResponse.setSpecialistName(d.getSpecialistName());
			specialistResponse.setAvailableDay(d.getAvailableDay());
			specialistResponse.setAvailableTime(d.getAvailableTime());
			specialistResponse.setIsAvailable(d.getIsAvailable());
			specialistResponse.setHospitalId(d.getHospital().getId());
			
			response.add(specialistResponse);
		}
		return response;
		
	}

	public Hospital getHospitalDetails(String hospitalName) {
		
		Hospital hospitalDetails = Optional.ofNullable(hospitalRepository.findByHospitalName(hospitalName))
				.orElseThrow(() -> new HospitalNotFoundException("Invalid hospital name:"+hospitalName));
		
		return hospitalDetails;
	}
	
	@Cacheable(cacheNames = "hospital", key="#hospitalName")
	public String fetchNumberOfBedsAvailable(String hospitalName) {
		System.out.println("Fetching number of beds from DB");
		Hospital hospital = getHospitalDetails(hospitalName);
		
		if(hospital.getNoOfBedsOccupied()==hospital.getTotalNoOfBeds())
			throw new HospitalNotFoundException("No beds available");
		
		Integer noOfBeds = hospital.getTotalNoOfBeds() - hospital.getNoOfBedsOccupied();
		return "Number of beds available is : " + noOfBeds;
	
	}

}
