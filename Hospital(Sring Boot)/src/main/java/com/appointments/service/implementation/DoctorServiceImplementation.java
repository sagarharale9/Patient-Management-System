package com.appointments.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointments.entity.DoctorEntity;
import com.appointments.entity.PatientEntity;
import com.appointments.exception.ResourceNotFoundException;
import com.appointments.repository.DoctorRepository;

import com.appointments.service.DoctorService;

@Service
public class DoctorServiceImplementation implements DoctorService

{

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public DoctorEntity addDoctor(DoctorEntity doctor) {
		DoctorEntity saveddoctor= doctorRepository.save(doctor);
		 return saveddoctor;
	}

	@Override
	public DoctorEntity getDoctorById(int doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<DoctorEntity> getAllDoctors() {
		return (ArrayList<DoctorEntity>)this.doctorRepository.findAll();
	}

	@Override
	public DoctorEntity updateDoctorById(int doctorId, DoctorEntity doctorEntity) {
		DoctorEntity updatedoctor=this.doctorRepository.findById(doctorId).orElseThrow(
				()-> new ResourceNotFoundException("Doctor","Doctor Id", doctorId));
				return this.doctorRepository.save(updatedoctor);
	}

	@Override
	public void deleteDoctorById(int doctorId) {
		DoctorEntity deleteDoctor= this.doctorRepository.findById(doctorId).orElseThrow(
				()-> new ResourceNotFoundException("Doctor","Doctor Id", doctorId));
		 this.doctorRepository.delete(deleteDoctor);
		
	}

	@Override
	public DoctorEntity cheackLogin(String doctorEmail, String password) {
		DoctorEntity doctorEntity=   this.doctorRepository.findByDoctorEmailAndPassword(doctorEmail, password);
			return doctorEntity;
	}

}
