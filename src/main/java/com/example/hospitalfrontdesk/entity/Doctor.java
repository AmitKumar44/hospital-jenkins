package com.example.hospitalfrontdesk.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue
	@JsonIgnore
	private Integer doctorId;
	private String type;
	private String specialistName;
	private String availableDay;
	private String availableTime;
	private String isAvailable;
	@OneToOne
	@JoinColumn(name="Hospital_Id")
	private Hospital hospital;
	
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSpecialistName() {
		return specialistName;
	}
	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}
	public String getAvailableDay() {
		return availableDay;
	}
	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}
	public String getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", type=" + type + ", specialistName=" + specialistName
				+ ", availableDay=" + availableDay + ", availableTime=" + availableTime + ", isAvailable=" + isAvailable
				+ ", hospital=" + hospital + "]";
	}
	
	
	

}
