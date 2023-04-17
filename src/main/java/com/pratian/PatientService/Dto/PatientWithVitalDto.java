package com.pratian.PatientService.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientWithVitalDto 
{
	
	private long PatientId;
	private String name;
	private long vitalId;
	private int heartBeat;
	private String temp;
	private int bp;
	private int lungsBpm;

}
