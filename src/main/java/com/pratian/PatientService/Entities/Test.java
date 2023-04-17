package com.pratian.PatientService.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long testId;
	
	private Date date;
	private String testdesc;
}
