package com.appointments.service.implementation;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.appointments.entity.AppointmentsEntity;
import com.appointments.entity.DoctorEntity;
import com.appointments.entity.PatientEntity;
import com.appointments.repository.AppointmentsRepository;
import com.appointments.repository.DoctorRepository;
import com.appointments.repository.PatientRepository;
import com.appointments.service.AppointmentsService;

import antlr.collections.List;

import com.appointments.exception.ResourceNotFoundException;


@Service
public class AppointmentsServiceImplementation implements AppointmentsService 
{

	@Autowired
	private AppointmentsRepository appointmentRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	

//	@Autowired
//	private DoctorRepository doctorRepository;

	@Override
//	public AppointmentsEntity addAppointment(AppointmentsEntity appointmentEntity) {
//	PatientEntity patient =	this.patientRepository.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("patient", "patient Id", patientId));
//	appointmentEntity.setPatient(patient); 
	
	public AppointmentsEntity addAppointment(AppointmentsEntity appointmentEntity) {
		AppointmentsEntity savedApp= appointmentRepository.save(appointmentEntity);
		 return savedApp;

//	DoctorEntity doctor =	this.doctorRepository.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("doctor", "doctor Id", doctorId));
//	
//	appointmentEntity.setDoctor(doctor); 
	
	
	}

	@Override
	public ArrayList<AppointmentsEntity> getAllAppointments() {
ArrayList<AppointmentsEntity>appList=(ArrayList<AppointmentsEntity>) this.appointmentRepository.findAll();
		return appList;
	}

	@Override
	public AppointmentsEntity getAppointmentById(int appointmentId) {
		AppointmentsEntity appointmentsEntity=  this.appointmentRepository.findById(appointmentId).orElseThrow(()-> new ResourceNotFoundException("App","App Id",appointmentId));

		return appointmentsEntity;
	}

	@Override
	public AppointmentsEntity updateAppointmentById(int appointmentId, AppointmentsEntity appointmentEntity) {
		AppointmentsEntity updatedAppointmentsEntity=  this.appointmentRepository.findById(appointmentId).orElseThrow(()-> new ResourceNotFoundException("App","App Id",appointmentId));
		
		updatedAppointmentsEntity.setAppointmentId(appointmentEntity.getAppointmentId());
		updatedAppointmentsEntity.setPatient(appointmentEntity.getPatient());
		updatedAppointmentsEntity.setPatientDisease(appointmentEntity.getPatientDisease());
		updatedAppointmentsEntity.setAppointmentdate(appointmentEntity.getAppointmentdate());
		updatedAppointmentsEntity.setAppointmentime(appointmentEntity.getAppointmentime());
		
		
		return this.appointmentRepository.save(updatedAppointmentsEntity);		
	}

	@Override
	public void deleteAppointmentById(int appointmentId) {
		AppointmentsEntity appointmentsEntity=  this.appointmentRepository.findById(appointmentId).orElseThrow(()-> new ResourceNotFoundException("App","App Id",appointmentId));
		
		this.appointmentRepository.delete(appointmentsEntity);
	}

	@Override
	public java.util.List<AppointmentsEntity> getAllAppointmentsByPatients(int patientId) {
		return this.appointmentRepository.getAllAppointmentByPatientId(patientId);
	}

//	@Override
//	public List<AppointmentsEntity> getAllAppointmentsByPatients(int patientId) {
//	
	//	return this.appointmentRepository.getAllAppointmentByPatientId(patientId);
//		PatientEntity patient =  this.patientRepository.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("Patient","Patient Id",patientId));
//		return  this.appointmentRepository.findByPatient(patient);
//	}
	
	
	
}
