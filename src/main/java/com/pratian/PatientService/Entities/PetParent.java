package com.pratian.PatientService.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class PetParent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long parentId;
	
	
	private String parentName;
	private String email;
	private String mobileNo;
	private String address;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="parentId")
	private List<Patient> patients=new ArrayList<>();

}
