package com.pratian.PatientService.Dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientWithTestDto 
{

	private long PatientId;
	private String name;
	private long testId;
	private String testdesc;

}
