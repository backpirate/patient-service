package com.pratian.PatientService.Service;

import java.util.List;

import com.pratian.PatientService.Dto.PatientParentDto;
import com.pratian.PatientService.Dto.PatientWithAppointmentDto;
import com.pratian.PatientService.Dto.PatientWithPrescriptionDto;
import com.pratian.PatientService.Dto.PatientWithSymptomDto;
import com.pratian.PatientService.Dto.PatientWithTestDto;
import com.pratian.PatientService.Dto.PatientWithVitalDto;
import com.pratian.PatientService.Entities.Appointment;
//import com.pratian.PatientService.Entities.Appointment;
import com.pratian.PatientService.Entities.Doctor;
import com.pratian.PatientService.Entities.Patient;
import com.pratian.PatientService.Entities.PetParent;
import com.pratian.PatientService.Entities.Symptom;
import com.pratian.PatientService.Exceptions.AppointmentNotFoundException;
//import com.pratian.PatientService.Exceptions.AppointmentAlreadyExistException;
//import com.pratian.PatientService.Exceptions.AppointmentNotFoundException;
import com.pratian.PatientService.Exceptions.DoctorAlreadyExistException;
import com.pratian.PatientService.Exceptions.DoctorNotFoundException;
import com.pratian.PatientService.Exceptions.PatientAlreadyExistException;
import com.pratian.PatientService.Exceptions.PatientNotFoundException;
import com.pratian.PatientService.Exceptions.PetParentNotFoundException;
import com.pratian.PatientService.Exceptions.SymptomAlreadyExistException;
import com.pratian.PatientService.Exceptions.SymptomNotFoundException;
import com.pratian.PatientService.Exceptions.petparentAlreadyExistException;


public interface IPatientService {
	
	//  Feature 46: view all pet profile
	public List<Patient> getPatientProfile() throws PatientNotFoundException;

	public Patient savePatientProfile(Patient patient) throws PatientAlreadyExistException ;
	
	public  Patient editPatientDetails(Patient patientEdit) throws PatientNotFoundException;


//	public List<Appointment> getAppointmentProfile() throws AppointmentNotFoundException;
//
//	public Appointment saveAppointmentProfile(Appointment appointment) throws AppointmentAlreadyExistException;

	public List<Symptom> getSymptoms() throws SymptomNotFoundException;
	
	public Symptom saveSymptoms(Symptom symptom) throws SymptomAlreadyExistException;

    //	Feature 60: view all doctor profile
	public List<Doctor> getDoctorProfile() throws DoctorNotFoundException;
	
	public Doctor saveDoctorProfile(Doctor doctor) throws DoctorAlreadyExistException ;
	
	public Doctor getDoctorById(long id); //GET

	public void deleteDoctorById(long id);
	
	public  Doctor editDoctorDetails(Doctor doctoredit) throws DoctorNotFoundException;

	public  PetParent editPetParentDetails(PetParent petParentEdit) throws PetParentNotFoundException;



public List<PetParent> getPetParentProfile() throws PetParentNotFoundException;
	
	public PetParent savePetParentProfile(PetParent petparent) throws petparentAlreadyExistException;
	
	//feature 49 view pet parent profile
		public List<PatientParentDto> viewPetParentProfile(long patientId) throws PatientNotFoundException;
		
		//feature
		public List<PatientWithSymptomDto> viewPetSymptomHistory(long patientId)throws PatientNotFoundException;
		
	//feature 57
	public List<PatientWithAppointmentDto> viewPetAppointmentHistory(long patientId) throws PatientNotFoundException;
	
	//feature
	public List<PatientWithPrescriptionDto> viewPetPrescriptionHistory(long patientId) throws PatientNotFoundException;
	
	//feature
	public List<PatientWithVitalDto> viewPetVitalHistory(long patientId) throws PatientNotFoundException;
	
	
    //feature
	public List<PatientWithTestDto> viewPetTestHistory(long patientId) throws PatientNotFoundException;
	
	
	

}
