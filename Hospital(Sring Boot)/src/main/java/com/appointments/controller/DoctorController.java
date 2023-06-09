package com.appointments.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appointments.entity.DoctorEntity;
import com.appointments.entity.PatientEntity;
import com.appointments.exception.APIResponse;
import com.appointments.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

	@Autowired
	private DoctorService doctorservice; 

	//we can use any of the annotation
//	@RequestMapping (value = "/addPatient",method = RequestMethod.POST)
	@PostMapping("/addDoctor")
	public ResponseEntity<DoctorEntity> createAppointment(@RequestBody DoctorEntity doctorEntity) {

		DoctorEntity createdPatient=doctorservice.addDoctor(doctorEntity);
		 return new ResponseEntity<DoctorEntity>(createdPatient,HttpStatus.CREATED);
		 
	  }
	  @GetMapping("/getAllDoctors")
	  public ResponseEntity<List<DoctorEntity>> getAllDoctors()
	  {
		  List<DoctorEntity> doctorList=this.doctorservice.getAllDoctors();
		  return new ResponseEntity<List<DoctorEntity>>(doctorList,HttpStatus.OK) ;
	  }
	  @GetMapping("/getDoctorById/{DoctorId}") //URI template variable
	  public ResponseEntity<DoctorEntity> getPatientById(@PathVariable("DoctorId")int doctorId)
	  {
		  DoctorEntity doctor =  this.doctorservice.getDoctorById(doctorId);
		  return new ResponseEntity<DoctorEntity>(HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/deleteDoctorById/{DoctorId}") //URI template variable
	  public ResponseEntity<APIResponse> deleteRecordById(@PathVariable("DoctorId")int doctorId)
	  {
		  this.doctorservice.deleteDoctorById(doctorId);
		  APIResponse response=new APIResponse();
		  response.setMessage("Doctor is successfully deleted");
		  response.setSuccess(true);
		  return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
	  }
	  
	  @PutMapping("/updateDoctor/{DoctorId}") //URI template variable
	  public ResponseEntity<DoctorEntity> updateDoctorById(@RequestBody DoctorEntity doctorEntity, @PathVariable("DoctorId")int doctorId)
	  {
		  DoctorEntity updatedDoctor=   this.doctorservice.updateDoctorById(doctorId,doctorEntity);
			 
			  return new ResponseEntity<DoctorEntity>(updatedDoctor,HttpStatus.OK);
	  }
	  @GetMapping("/check")
		public ResponseEntity<DoctorEntity> checkLogin(@RequestParam("email") String email,@RequestParam("password") String password)
		{
			System.out.println("Original     "+email+"    "+password);
			     //  JWT  2. RoutingGuards
			    String status="invalid";
			    // username="sagar@gmail.com";
			    // password="12345";
			    DoctorEntity checkedPatientEntity=   this.doctorservice.cheackLogin(email, password);
			    // System.out.println(checkedStudentEntity.getStudentEmail()+"-------------------"+checkedStudentEntity.getPassword());
			    
			     if(checkedPatientEntity!=null)
			     {
			    	 status="valid";
			     }

			     
			     return new ResponseEntity<DoctorEntity>(checkedPatientEntity,HttpStatus.OK);
			   
}
}
