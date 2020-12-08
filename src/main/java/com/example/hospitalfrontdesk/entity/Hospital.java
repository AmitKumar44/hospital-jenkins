package com.example.hospitalfrontdesk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospital {
	
	@Id
	@GeneratedValue
	@Column(name="Hospital_Id")
	private Integer id;
	private String hospitalName;
	private Integer totalNoOfBeds;
	private Integer noOfBedsOccupied;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Integer getTotalNoOfBeds() {
		return totalNoOfBeds;
	}
	public void setTotalNoOfBeds(Integer totalNoOfBeds) {
		this.totalNoOfBeds = totalNoOfBeds;
	}
	public Integer getNoOfBedsOccupied() {
		return noOfBedsOccupied;
	}
	public void setNoOfBedsOccupied(Integer noOfBedsOccupied) {
		this.noOfBedsOccupied = noOfBedsOccupied;
	}
	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalName=" + hospitalName + ", totalNoOfBeds=" + totalNoOfBeds
				+ ", noOfBedsOccupied=" + noOfBedsOccupied + "]";
	}
	
	

}
