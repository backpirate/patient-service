package com.pratian.PatientService.Entities;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long appointmentId;
	private Date date;
	private String status;
	private String reasonForVisit;
	
	
	@OneToMany(targetEntity = Prescription.class,cascade = CascadeType.ALL)
	@JoinColumn(name ="appointmentId")
	private List<Prescription> prescriptions=new ArrayList<>();
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="appointmentId")
	private List<Test> tests=new ArrayList<>();
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doctorId")
	private Doctor doctor;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vitalId")
	private Vital vital;
	

}

