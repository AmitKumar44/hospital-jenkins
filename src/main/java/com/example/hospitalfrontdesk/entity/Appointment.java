package com.example.hospitalfrontdesk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer id;
	
	private String specialistName;
	private String patientName;
	private String appointmentDay;
	private String appointmentTime;
	
	
	
	public Appointment() {
		super();
	}
	
	public Appointment(String specialistName, String patientName, String appointmentDay,
			String appointmentTime) {
		super();
		this.specialistName = specialistName;
		this.patientName = patientName;
		this.appointmentDay = appointmentDay;
		this.appointmentTime = appointmentTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecialistName() {
		return specialistName;
	}
	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAppointmentDay() {
		return appointmentDay;
	}
	public void setAppointmentDay(String appointmentDay) {
		this.appointmentDay = appointmentDay;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	

}
