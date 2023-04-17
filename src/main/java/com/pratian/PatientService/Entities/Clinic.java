package com.pratian.PatientService.Entities;

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

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@Entity
public class Clinic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long clinicId;
	
	private String clinicaddr;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "clinicId")
	private List<Doctor> doctor;

}
