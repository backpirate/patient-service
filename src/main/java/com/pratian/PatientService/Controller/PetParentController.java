package com.pratian.PatientService.Controller;

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
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.PatientService.Entities.Doctor;
import com.pratian.PatientService.Entities.PetParent;
//import com.pratian.PatientService.Entities.PetParent;
import com.pratian.PatientService.Exceptions.PetParentNotFoundException;
import com.pratian.PatientService.Exceptions.petparentAlreadyExistException;
import com.pratian.PatientService.Repository.PatientServiceFactory;
import com.pratian.PatientService.Repository.PetParentRepo;
import com.pratian.PatientService.Service.IPatientService;

import io.swagger.v3.oas.annotations.Operation;

//import io.swagger.v3.oas.annotations.Operation;


@CrossOrigin(origins= "http://localhost:3000")

@RestController
@RequestMapping("/petParent")
public class PetParentController 
{
	@Autowired
	private IPatientService service = PatientServiceFactory.patientService();

	
	@Autowired
	private PetParentRepo petParentRepo;
	
	
	@GetMapping("/PetParents")
	public ResponseEntity<?> get(){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getPetParentProfile(), HttpStatus.OK);
		}
		catch (PetParentNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	@PostMapping("/PetParents")
	@Operation(summary = "To save a petparent")
	public ResponseEntity<?> post(@RequestBody PetParent petparent)
	{
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.savePetParentProfile(petparent), HttpStatus.OK);
		} catch (petparentAlreadyExistException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	
	@PutMapping("/petParentEdit/{id}")
	  public ResponseEntity<PetParent> updatePetParent(@PathVariable("id") long id, @RequestBody PetParent petParent) {
	  Optional <PetParent> petParentData= petParentRepo.findById(id);
	  
		if (petParentData.isPresent()) {
			PetParent _petParent = petParentData.get();
			_petParent.setParentName(petParent.getParentName());
			_petParent.setMobileNo (petParent.getMobileNo());
			_petParent.setEmail (petParent.getEmail());
			_petParent.setAddress (petParent.getAddress());


			return new ResponseEntity<>(petParentRepo.save( _petParent), HttpStatus.OK);
			 } else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}
	

}
