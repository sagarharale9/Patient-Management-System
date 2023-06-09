package com.appointments.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name = "patient")
public class PatientEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	
	@Column
	@NonNull
	private String  patientName;
	
	@Column
	@NonNull
    private int patientAge;
	
	
	@Column
	@NonNull
	private String patientContact;
	
	@Column(unique = true)
	@NonNull
    private String patientEmail;
	
	@Column
	@NonNull
	private String address;
	
	@Column
	@NonNull
	private String password;
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<AppointmentsEntity> applist= new ArrayList<AppointmentsEntity>();
	
	

	public List<AppointmentsEntity> getApplist() {
		return  applist;
	}
	
	

	public void setApplist(List<AppointmentsEntity> applist) {
		this.applist = applist;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PatientEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PatientEntity [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientContact=" + patientContact + ", patientEmail=" + patientEmail + ", address=" + address
				+ ", password=" + password + ", applist=" + applist + "]";
	}

	
	}

	

