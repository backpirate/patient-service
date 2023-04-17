package com.pratian.PatientService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.PatientService.Dto.PatientParentDto;
import com.pratian.PatientService.Entities.Patient;
import com.pratian.PatientService.Entities.PetParent;
import com.pratian.PatientService.Exceptions.PatientAlreadyExistException;
import com.pratian.PatientService.Exceptions.PatientNotFoundException;
import com.pratian.PatientService.Repository.IPatientRepo;
import com.pratian.PatientService.Repository.PatientServiceFactory;
import com.pratian.PatientService.Service.IPatientService;


import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins= "http://localhost:3000")

@RestController
@RequestMapping("/patient")
public class PatientController 
{
	@Autowired
	private IPatientService service = PatientServiceFactory.patientService();

	
	@Autowired
	private IPatientRepo repo;
	

	
	
	@GetMapping("/patients")
	public ResponseEntity<?> get(){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getPatientProfile(), HttpStatus.OK);
		}
		catch (PatientNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@PostMapping("/patientss")
	@Operation(summary = "To save a product")
	public ResponseEntity<?> post(@RequestBody Patient patient){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.savePatientProfile(patient), HttpStatus.OK);
		} catch (PatientAlreadyExistException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/petparent/{patientId}")
	public ResponseEntity<?> get2(@PathVariable(value="patientId")Long patientId){
	
		ResponseEntity<?> 
		response = null;
		try {
			response = new ResponseEntity<>(service.viewPetParentProfile(patientId), HttpStatus.OK);
		}
		catch (PatientNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
//	@GetMapping("/getparent")
//	public List<PatientParentDto> getAllPetParent(){
//		return service.getAllPetParent();
//	}
//	
//	
//	@GetMapping("/patientsymptomDtos/{patientId}")
//	@Operation(summary = "To get list of productDtos")
//	public ResponseEntity<?> getDtos(@PathVariable(value="patientId")Long patientId) throws PatientNotFoundException{
//		ResponseEntity<?> response = null;
//		response = new ResponseEntity<>(service.viewSymptomsWithPatientId(patientId), HttpStatus.OK);
//		return response;
//	}
	
	@GetMapping("/getsymptominfo/{patientId}")
	public ResponseEntity<?> getJoinInformation(@PathVariable(value="patientId")Long patientId){
		ResponseEntity<?> response = null;
		try
		{
			response = new ResponseEntity<>(service.viewPetSymptomHistory(patientId), HttpStatus.OK);
		}
		catch (PatientNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
			
		
		return response;
	}
	
	
	@GetMapping("/getappointmentinfo/{patientId}")
	public ResponseEntity<?> getappointmentinfo(@PathVariable(value="patientId")Long patientId){
	
		ResponseEntity<?> 
		response = null;
		try {
			response = new ResponseEntity<>(service.viewPetAppointmentHistory(patientId), HttpStatus.OK);
		}
		catch (PatientNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/getprescriptioninfo/{patientId}")
	public ResponseEntity<?> getprescriptionfo(@PathVariable(value="patientId")Long patientId){
	
		ResponseEntity<?> 
		response = null;
		try {
			response = new ResponseEntity<>(service.viewPetPrescriptionHistory(patientId), HttpStatus.OK);
		}
		catch (PatientNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}
	@GetMapping("/getvitalinfo/{patientId}")
	public ResponseEntity<?> getvitalinfo(@PathVariable(value="patientId")Long patientId){
	
		ResponseEntity<?> 
		response = null;
		try {
			response = new ResponseEntity<>(service.viewPetVitalHistory(patientId), HttpStatus.OK);
		}
		catch (PatientNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}
	@GetMapping("/gettestinfo/{patientId}")
	public ResponseEntity<?> gettestinfo(@PathVariable(value="patientId")Long patientId){
	
		ResponseEntity<?> 
		response = null;
		try {
			response = new ResponseEntity<>(service.viewPetTestHistory(patientId), HttpStatus.OK);
		}
		catch (PatientNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}

		return response;
	}
	
	
	
	@PutMapping("/petEdit/{id}")
	  public ResponseEntity<Patient> updatePatient(@PathVariable("id") long id, @RequestBody Patient patient) {
	  Optional <Patient> patientData= repo.findById(id);
	  
		if (patientData.isPresent()) {
			Patient _patient = patientData.get();
			_patient.setName(patient.getName());
			_patient.setAge (patient.getAge());
			_patient.setGender (patient.getGender());
//			_petParent.setAddress (petParent.getAddress());


			return new ResponseEntity<>(repo.save( _patient), HttpStatus.OK);
			 } else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}
	
	
	
	
	
}
