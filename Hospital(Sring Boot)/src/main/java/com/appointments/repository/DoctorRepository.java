package com.appointments.repository;

import org.springframework.data.repository.CrudRepository;

import com.appointments.entity.DoctorEntity;
import com.appointments.entity.PatientEntity;


public interface DoctorRepository extends CrudRepository<DoctorEntity, Integer> 
{

	public DoctorEntity  findByDoctorEmailAndPassword(String doctorEmail,String password);
}
