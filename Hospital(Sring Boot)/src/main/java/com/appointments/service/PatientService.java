package com.appointments.service;

import java.util.*;

import com.appointments.entity.AppointmentsEntity;
import com.appointments.entity.PatientEntity;



public interface PatientService {

	public PatientEntity addPatient(PatientEntity patient);
	
	public PatientEntity getPatientById(int PatientId);
	
	public  List<PatientEntity> getAllPatients();
	
	public  PatientEntity updatePatientById(int PatientId,PatientEntity patientEntity);

	public void deletePatientbyId(int patientId);
	
	 public PatientEntity  checkLogin(String username,String password);
	
	
	
	
	
}
