package com.pratian.PatientService.Dto;

import java.util.List;

import com.pratian.PatientService.Entities.Prescription;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientWithPrescriptionDto 
{

	
	
	private String name;
	private long preId;
	private int days;
	private String medicine;
	private String comments;


}
