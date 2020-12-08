package com.example.hospitalfrontdesk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.hospitalfrontdesk.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	
	@Query("SELECT h.id FROM Hospital h where h.hospitalName = :name")
	public Optional<Integer> findIdByName(@Param("name")String name);
	
	@Query("SELECT h.totalNoOfBeds FROM Hospital h where h.hospitalName = :name")
	public Integer findTotalNoOfBedsByName(@Param("name")String name);
	
	public Hospital findByHospitalName(String hospitalName);

}
