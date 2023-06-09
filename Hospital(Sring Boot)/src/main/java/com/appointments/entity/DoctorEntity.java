package com.appointments.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "doctor")
public class DoctorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int doctorId;
	
	@NonNull
	@Column
	private String doctorName;
	
	@NonNull
	@Column(unique = true)
	private String doctorEmail;
	
	@NonNull
	@Column
	private String contact;

	@NonNull
	@Column
	private String specialist;
	
	
	@NonNull
	@Column
	private String password;


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getDoctorEmail() {
		return doctorEmail;
	}


	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getSpecialist() {
		return specialist;
	}


	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public DoctorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "DoctorEntity [doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorEmail=" + doctorEmail
				+ ", contact=" + contact + ", specialist=" + specialist + ", password=" + password + "]";
	}
	
}


