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
public class PatientWithAppointmentDto 
{
	//private Long patientId;
	private String name;
	private long appointmentId;
	//private Date date;
	private String status;
	private String reasonForVisit;
	

}
