package com.example.hospitalfrontdesk.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hospitalfrontdesk.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
	
	@Query("SELECT COUNT(p.id) FROM Patient p INNER JOIN p.hospital h where p.status = :status and h.id = :hospitalId")
	public int findNoOfPatientByStatus(@Param("status")String status, @Param("hospitalId") Integer hospitalId);

}
