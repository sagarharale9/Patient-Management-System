package com.appointments.service;

import java.util.ArrayList;

import com.appointments.entity.DoctorEntity;

public interface DoctorService {

public DoctorEntity addDoctor(DoctorEntity doctor);
	
public DoctorEntity getDoctorById(int DoctorId);
	
public  ArrayList<DoctorEntity> getAllDoctors();
	
public  DoctorEntity updateDoctorById(int DoctorId, DoctorEntity doctorEntity);
	
public void deleteDoctorById(int doctorId);

public DoctorEntity cheackLogin(String username,String pword);
	
}
