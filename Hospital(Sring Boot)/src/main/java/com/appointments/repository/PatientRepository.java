package com.appointments.repository;

import org.springframework.data.repository.CrudRepository;

import com.appointments.entity.AppointmentsEntity;
import com.appointments.entity.PatientEntity;

public interface PatientRepository extends CrudRepository<PatientEntity, Integer> 
{

	 public PatientEntity  findByPatientEmailAndPassword(String patientEmail,String password);
	
}
