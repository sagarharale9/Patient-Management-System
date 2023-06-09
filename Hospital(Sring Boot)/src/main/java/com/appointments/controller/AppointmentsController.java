package com.appointments.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.entity.AppointmentsEntity;
import com.appointments.entity.PatientEntity;
import com.appointments.exception.APIResponse;
import com.appointments.service.AppointmentsService;



@RestController
@RequestMapping("/api/appointments")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = { "http://localhost:4200"})
public class AppointmentsController {
	 
	@Autowired
	private AppointmentsService appointmentsService; 

	//we can use any of the annotation
//	@RequestMapping (value = "/addAppointment/{patientId}")
//	public ResponseEntity<AppointmentsEntity> createAppointment(@RequestBody AppointmentsEntity appointmentEntity, @PathVariable("patientId") int patientId)                   
//	{
//
//		AppointmentsEntity createdAppointment=appointmentsService.addAppointment(appointmentEntity, patientId);
//		 return new ResponseEntity<AppointmentsEntity>(createdAppointment,HttpStatus.CREATED);
	@PostMapping("/addAppointment")
		 public ResponseEntity<AppointmentsEntity> createAppointment(@RequestBody AppointmentsEntity appointmentEntity) {

		AppointmentsEntity createdAppointment=appointmentsService.addAppointment(appointmentEntity);
				 return new ResponseEntity<AppointmentsEntity>(createdAppointment,HttpStatus.CREATED); 

	  }

	  
	
	
	  @GetMapping("/getAllAppointments")
	  public ResponseEntity<List<AppointmentsEntity>> getAllAppointments()
	  {
		  List<AppointmentsEntity> appointmentList=this.appointmentsService.getAllAppointments();
		  return new ResponseEntity<List<AppointmentsEntity>>(appointmentList,HttpStatus.OK) ;
	  }
	  
	  
	  
	  
	  
	  
	  
	  @GetMapping("/getAppointment/ {doctorId}") //URI templet variable
	  public ResponseEntity<AppointmentsEntity> getAppointmentById(@PathVariable("doctorId")int doctorId)
	  {
		  AppointmentsEntity student=  this.appointmentsService.getAppointmentById(doctorId);
		  return new ResponseEntity<AppointmentsEntity>(student,HttpStatus.OK);
	  }
	  
	  @GetMapping("/getAppointment/{patientId}") //URI templet variable
	  public ResponseEntity<AppointmentsEntity> getAppointmentById1(@PathVariable("patientId")int patientId)
	  {
		  AppointmentsEntity patient=  this.appointmentsService.getAppointmentById(patientId);
		  return new ResponseEntity<AppointmentsEntity>(patient,HttpStatus.OK);
	  }
	  
	  
	  
	  
	  
	  @DeleteMapping("/deleteAppointmentById/{doctorId}") //URI template variable
	  public ResponseEntity<APIResponse> deleteRecordById(@PathVariable("doctorId")int doctorId)
	  {
		  this.appointmentsService.deleteAppointmentById(doctorId);
		  APIResponse response=new APIResponse();
		  response.setMessage("Patient is successfully deleted");
		  response.setSuccess(true);
		  return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
	  }
	  
	  @GetMapping("/getAllAppByPatient/{patientId}")
		public ResponseEntity<ArrayList<AppointmentsEntity>>  getAllCoursesByStudnet(@PathVariable("patientId") int patientId)
		{
			ArrayList<AppointmentsEntity>  appointmentList = (ArrayList<AppointmentsEntity>) this.appointmentsService.getAllAppointmentsByPatients(patientId);
			
			return new ResponseEntity<ArrayList<AppointmentsEntity>>(appointmentList,HttpStatus.OK);
			
		}
//	  
//	  @PutMapping("/updateStudent/{studentId}") //URI template variable
//	  public ResponseEntity<StudentEntity> updateStudentById(@RequestBody StudentEntity studentEntity, @PathVariable("studentId")int studentId)
//	  {
//		  StudentEntity updatedStudent=   this.studentService.updateStudentById(studentId,studentEntity);
//		 
//		  return new ResponseEntity<StudentEntity>(updatedStudent,HttpStatus.OK);
//	  }
	
	
}
