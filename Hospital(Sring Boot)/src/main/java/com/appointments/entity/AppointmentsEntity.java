package com.appointments.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.lang.NonNull;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "appointments")
public class AppointmentsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;	
	
	private int doctorId;
	
	private String patientDisease;
	 
	private String appointmentdate;
	
	
	private String appointmentime;
	
	
	private String status;
	
    
    @ManyToOne
    @JoinColumn(name="patientId")
    @JsonBackReference
	private PatientEntity patient;
    
//    
//    @ManyToOne
//    @JoinColumn(name="doctorId")
//    @JsonBackReference
//	private DoctorEntity doctor;
//
//	public DoctorEntity getDoctor() {
//		return doctor;
//	}
//
//
//	public void setDoctor(DoctorEntity doctor) {
//		this.doctor = doctor;
//	}
//
	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}


	public String getPatientDisease() {
		return patientDisease;
	}


	public void setPatientDisease(String patientDisease) {
		this.patientDisease = patientDisease;
	}


	public String getAppointmentdate() {
		return appointmentdate;
	}


	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}


	public String getAppointmentime() {
		return appointmentime;
	}


	public void setAppointmentime(String appointmentime) {
		this.appointmentime = appointmentime;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public PatientEntity getPatient() {
		return patient;
	}


	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}


	public AppointmentsEntity(int appointmentId, int doctorId, String patientDisease, String appointmentdate,
			String appointmentime, String status, PatientEntity patient) {
		super();
		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.patientDisease = patientDisease;
		this.appointmentdate = appointmentdate;
		this.appointmentime = appointmentime;
		this.status = status;
		this.patient = patient;
	}


	public AppointmentsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "AppointmentsEntity [appointmentId=" + appointmentId + ", doctorId=" + doctorId + ", patientDisease="
				+ patientDisease + ", appointmentdate=" + appointmentdate + ", appointmentime=" + appointmentime
				+ ", status=" + status + ", patient=" + patient + "]";
	}
    
    
   

	
	
	
	



	

	
}
