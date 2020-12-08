package com.example.hospitalfrontdesk.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SpecialistDto {
	
	private String type;
	private String specialistName;
	private String availableDay;
	private String availableTime;
	private String isAvailable;
	private Integer hospitalId;
	
	public SpecialistDto() {
		super();
	}

	public SpecialistDto(String type, String specialistName, String availableDay, String availableTime,
			String isAvailable, Integer hospitalId) {
		super();
		this.type = type;
		this.specialistName = specialistName;
		this.availableDay = availableDay;
		this.availableTime = availableTime;
		this.isAvailable = isAvailable;
		this.hospitalId = hospitalId;
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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "SpecialistDto [type=" + type + ", specialistName=" + specialistName + ", availableDay=" + availableDay
				+ ", availableTime=" + availableTime + ", isAvailable=" + isAvailable + ", hospitalId=" + hospitalId
				+ "]";
	}
	
	

}
