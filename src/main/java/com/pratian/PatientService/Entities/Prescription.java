package com.pratian.PatientService.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long preId;
	
	
	private int days;
	private String medicine;
	private String comments;

}
