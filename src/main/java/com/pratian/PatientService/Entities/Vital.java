package com.pratian.PatientService.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Vital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long vitalId;
	
	private int heartBeat;
	private String temp;
	private int bp;
	private int lungsBpm;
	
	
	
	
	

}
