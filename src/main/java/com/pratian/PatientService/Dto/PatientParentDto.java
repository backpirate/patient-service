package com.pratian.PatientService.Dto;

//import com.pratian.PatientService.Entities.Patient;
//import com.pratian.PatientService.Entities.PetParent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientParentDto 
{
	
	
	private String name;
	private int age;
	private String gender;
	
	private String parentName;
	private String address;
	private String email;
	private String mobileNo;
	//private long parentId;
	

}
