package com.appointments.service.implementation;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.appointments.entity.AppointmentsEntity;
import com.appointments.entity.PatientEntity;
import com.appointments.repository.AppointmentsRepository;
import com.appointments.repository.PatientRepository;
import com.appointments.service.AppointmentsService;
import com.appointments.service.PatientService;
import com.appointments.exception.ResourceNotFoundException;


@Service
public  class PatientServiceImplementation  implements PatientService

{
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public PatientEntity addPatient(PatientEntity patient) {
		PatientEntity savedpatient= patientRepository.save(patient);
		 return savedpatient;
	}

	@Override
	public PatientEntity getPatientById(int PatientId) {
		PatientEntity PatientEntity=  this.patientRepository.findById(PatientId).orElseThrow(()-> new ResourceNotFoundException("App","App Id",PatientId));

		return PatientEntity;
	}

	@Override
	public ArrayList<PatientEntity> getAllPatients() {
		return (ArrayList<PatientEntity>) this.patientRepository.findAll();
	}

	@Override
	public PatientEntity updatePatientById(int PatientId, PatientEntity patientEntity) {
		PatientEntity updatedPatient=      this.patientRepository.findById(PatientId).orElseThrow(
				()-> new ResourceNotFoundException("Patient","Patient Id",PatientId));
		
		
		updatedPatient.setPatientName(patientEntity.getPatientName());
		updatedPatient.setPassword(patientEntity.getPassword());
		updatedPatient.setPatientEmail(patientEntity.getPatientEmail());
		updatedPatient.setPatientContact(patientEntity.getPatientContact());
		updatedPatient.setAddress(patientEntity.getAddress());
		updatedPatient.setPatientAge(patientEntity.getPatientAge());
		
		
		
		return this.patientRepository.save(updatedPatient);
	}

	@Override
	public void deletePatientbyId(int patientId) {
		PatientEntity getPatient=      this.patientRepository.findById(patientId).orElseThrow(
				()-> new ResourceNotFoundException("Patient","Patient Id",patientId));
		
		     this.patientRepository.delete(getPatient);		
		
	}

	@Override
	public PatientEntity checkLogin(String patientEmail, String password) {
		 PatientEntity patientEntity=   this.patientRepository.findByPatientEmailAndPassword(patientEmail, password);
			return patientEntity;
	}

	
				
				
		
	}
	
	
	


