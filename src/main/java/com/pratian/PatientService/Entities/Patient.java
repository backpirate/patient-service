package com.pratian.PatientService.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long patientId;
	
	 private String name;
	    private String species;
	    private String gender;
	    private String reproductivity;
	    private Date dateOfBirth;
	    private int age;
	    private String booldGroup;
	    private String allergies;

	    @OneToMany(targetEntity = Appointment.class,cascade = CascadeType.ALL)
		@JoinColumn(name="patientId")
		private List<Appointment> appointments=new ArrayList<>();
	    

	    @OneToMany(targetEntity =Symptom.class,cascade = CascadeType.ALL)
		@JoinColumn(name="patientId")
		private List<Symptom> symptoms=new ArrayList<>();
	    
	    
	    ///////
//	    @OneToMany(targetEntity =Test.class,cascade = CascadeType.ALL)
//		@JoinColumn(name="patientId")
//		private List<Test> tests=new ArrayList<>();
//	    
//	    @OneToMany(targetEntity =Vital.class,cascade = CascadeType.ALL)
//		@JoinColumn(name="patientId")
//		private List<Vital> vitals=new ArrayList<>();
	    
	    
	    
	    
//	    last recorded vitals
//	    test recomendation
//	    prescription
	    
	    
////	    @ManyToOne(fetch=FetchType.EAGER,optional=false)
//	    @ManyToOne(cascade = CascadeType.ALL)
//	    @JoinColumn(name="parnetId")
//	    private PetParent petparent;

}
