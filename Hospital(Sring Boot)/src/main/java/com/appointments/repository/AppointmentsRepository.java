package com.appointments.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.appointments.entity.AppointmentsEntity;
import com.appointments.entity.PatientEntity;


public interface AppointmentsRepository extends CrudRepository<AppointmentsEntity, Integer> 
{

	@Query(value="select * from  appointments ap where ap.patient_Id=:pid",nativeQuery=true) 
	 public List<AppointmentsEntity> getAllAppointmentByPatientId(@Param("pid") int pid);
	
}
