package com.pratian.PatientService.Dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientWithSymptomDto 
{
	
	private String name;
	private long symptomId;

}
