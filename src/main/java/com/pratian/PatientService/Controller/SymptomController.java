package com.pratian.PatientService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.PatientService.Entities.Symptom;
import com.pratian.PatientService.Exceptions.SymptomAlreadyExistException;
import com.pratian.PatientService.Exceptions.SymptomNotFoundException;
import com.pratian.PatientService.Repository.PatientServiceFactory;
import com.pratian.PatientService.Service.IPatientService;

import io.swagger.v3.oas.annotations.Operation;


@CrossOrigin(origins= "http://localhost:3000")

@RestController
@RequestMapping("/symptom")

public class SymptomController {

	@Autowired
	private IPatientService service = PatientServiceFactory.patientService();

	
	@GetMapping("/symptoms")
	public ResponseEntity<?> get(){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getSymptoms(), HttpStatus.OK);
		}
		catch (SymptomNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	@PostMapping("/symptomss")
	@Operation(summary = "To save a Symptom")
	public ResponseEntity<?> post(@RequestBody Symptom symptom){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.saveSymptoms(symptom), HttpStatus.OK);
		} catch (SymptomAlreadyExistException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
}
