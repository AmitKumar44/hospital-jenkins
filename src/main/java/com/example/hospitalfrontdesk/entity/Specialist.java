package com.example.hospitalfrontdesk.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties
@PropertySource("classpath:application.properties")
public class Specialist {
	
	String[] specialistName;
	String[] availableDay;
	String[] availableTime;
	String name;
	public String[] getSpecialistName() {
		return specialistName;
	}
	public void setSpecialistName(String[] specialistName) {
		this.specialistName = specialistName;
	}
	public String[] getAvailableDay() {
		return availableDay;
	}
	public void setAvailableDay(String[] availableDay) {
		this.availableDay = availableDay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getAvailableTime() {
		return availableTime;
	}
	public void setAvailableTime(String[] availableTime) {
		this.availableTime = availableTime;
	}
	
	
	
	
	

}
