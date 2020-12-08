package com.example.hospitalfrontdesk.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hospitalfrontdesk.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{
	
	public List<Doctor> findAllByHospitalIdAndType(Optional<Integer> hId, String specialistType);
	

}
