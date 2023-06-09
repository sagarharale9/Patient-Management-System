package com.appointments.service;

import java.util.*;
import com.appointments.entity.AppointmentsEntity;
import com.appointments.entity.DoctorEntity;
import com.appointments.entity.PatientEntity;

public interface AppointmentsService {

	public AppointmentsEntity addAppointment(AppointmentsEntity appointment);
	
	public  List<AppointmentsEntity> getAllAppointments();
	
	public AppointmentsEntity getAppointmentById(int appointmentId);
	
	public  AppointmentsEntity updateAppointmentById(int appointmentId, AppointmentsEntity appointmentEntity);
	
	public void deleteAppointmentById(int appointmentId);
	
	
	public  List<AppointmentsEntity> getAllAppointmentsByPatients(int patientId);
	
	

	
	
	
	
	
}
