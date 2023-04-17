package com.pratian.PatientService.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long doctorId;
	
	private String name;
	private long npiNo;
	private String speciality;
	private long mobileNo;
	private String email;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="doctorId")
	private List<Appointment> appointments=new ArrayList<>();
}
