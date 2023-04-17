package com.pratian.PatientService.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data


public class Symptom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long symptomId;
	 
	private String symptomdesc;

}
