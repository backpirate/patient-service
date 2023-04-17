package com.pratian.PatientService.Service;

import com.pratian.PatientService.Entities.Patient;
import com.pratian.PatientService.Entities.PetParent;

public interface ParentWithPet 
{
	public Patient getPatient();
	
	public PetParent getPetParent();

}
