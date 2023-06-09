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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.appointments.entity.PatientEntity;
import com.appointments.exception.APIResponse;
import com.appointments.service.PatientService;


@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	 
	@Autowired
	private PatientService patientService; 

	//we can use any of the annotation
//	@RequestMapping (value = "/addPatient",method = RequestMethod.POST)
	@PostMapping("/addPatient")
	public ResponseEntity<PatientEntity> createAppointment(@RequestBody PatientEntity patientEntity) {

		PatientEntity createdPatient=patientService.addPatient(patientEntity);
		 return new ResponseEntity<PatientEntity>(createdPatient,HttpStatus.CREATED);
		 
	  }

		
	  @GetMapping("/getAllPatients")
	  public ResponseEntity<List<PatientEntity>> getAllPatients()
	  {
		  List<PatientEntity> patientList=this.patientService.getAllPatients();
		  return new ResponseEntity<List<PatientEntity>>(patientList,HttpStatus.OK) ;
	  }
	  @GetMapping("/getPatientById/{patientId}") //URI template variable
	  public ResponseEntity<PatientEntity> getPatientById(@PathVariable("patientId")int patientId)
	  {
		  PatientEntity patient=  this.patientService.getPatientById(patientId);
		  return new ResponseEntity<PatientEntity>(patient,HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/deletePatientById/{patientId}") //URI template variable
	  public ResponseEntity<APIResponse> deleteRecordById(@PathVariable("patientId")int patientId)
	  {
		  this.patientService.deletePatientbyId(patientId);
		  APIResponse response=new APIResponse();
		  response.setMessage("Patient is successfully deleted");
		  response.setSuccess(true);
		  return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
	  }
	  
	  @PutMapping("/updatePatient/{patientId}") //URI template variable
	  public ResponseEntity<PatientEntity> updatePatientById(@RequestBody PatientEntity patientEntity, @PathVariable("patientId")int patientId)
	  {
		  PatientEntity updatedStudent=   this.patientService.updatePatientById(patientId,patientEntity);
			 
			  return new ResponseEntity<PatientEntity>(updatedStudent,HttpStatus.OK);
	  }
	  
	  @GetMapping("/check")
		public ResponseEntity<PatientEntity> checkLogin(@RequestParam("email") String email,@RequestParam("password") String password)
		{
			System.out.println("Original     "+email+"    "+password);
			     //  JWT  2. RoutingGuards
			    String status="invalid";
			    // username="sagar@gmail.com";
			    // password="12345";
			    PatientEntity checkedPatientEntity=   this.patientService.checkLogin(email, password);
			    // System.out.println(checkedStudentEntity.getStudentEmail()+"-------------------"+checkedStudentEntity.getPassword());
			    
			     if(checkedPatientEntity!=null)
			     {
			    	 status="valid";
			     }

			     
			     return new ResponseEntity<PatientEntity>(checkedPatientEntity,HttpStatus.OK);
			   
}
}
