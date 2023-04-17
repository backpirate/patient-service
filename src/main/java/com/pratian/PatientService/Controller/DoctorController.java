package com.pratian.PatientService.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.pratian.PatientService.Entities.Appointment;
import com.pratian.PatientService.Entities.Doctor;
import com.pratian.PatientService.Exceptions.DoctorAlreadyExistException;
import com.pratian.PatientService.Exceptions.DoctorNotFoundException;
import com.pratian.PatientService.Exceptions.PatientNotFoundException;
import com.pratian.PatientService.Repository.DoctorRepo;
import com.pratian.PatientService.Repository.PatientServiceFactory;
import com.pratian.PatientService.Service.AppointmentService;
import com.pratian.PatientService.Service.IPatientService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/doctor")

public class DoctorController {
	
//	private static final Logger logger = LogManager.getLogger(DoctorController.class);

	private static final Logger LOGGER =LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	private DoctorRepo doctorRepo;

	@Autowired
	private IPatientService service = PatientServiceFactory.patientService();
	
	@Autowired
	private AppointmentService service1;
	
	@GetMapping("/doctors")
	public ResponseEntity<?> get(){
		
		ResponseEntity<?> response = null;
//		if (logger.isDebugEnabled()) {
		try {
			response = new ResponseEntity<>(service.getDoctorProfile(), HttpStatus.OK);
		}
		catch (DoctorNotFoundException e) {
			LOGGER.info("Get All Doctors : doctors doesnot exist");

			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		LOGGER.info("Get All Doctors : succeeded");

//		}
		return response;
	}
	
	
	@PostMapping("/doctorss")
	@Operation(summary = "To save a Doctors")
	public ResponseEntity<?> post(@RequestBody Doctor doctor){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.saveDoctorProfile(doctor), HttpStatus.OK);
		} catch (DoctorAlreadyExistException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

		}
		LOGGER.info(" Doctors added Successfully : succeeded");

		return response;
	}
	
	
	@GetMapping("doctors/{id}")
	@Operation(summary = "To get the product by using id")
	public ResponseEntity<?> getById(@PathVariable (value = "id") long id){
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(service.getDoctorById(id), HttpStatus.OK);
		LOGGER.info(" Doctors exist by this ID: succeeded");

		return response;
	}
	
	
	@GetMapping("/getappointmentinfo/{doctorId}")
	public ResponseEntity<?> getappointmentinfo(@PathVariable(value="doctorId")Long doctorId){
	
		ResponseEntity<?> 
		response = null;
		try {
			response = new ResponseEntity<>(service1.getAppointmentInfoWithDoctorId(doctorId), HttpStatus.OK);
		}
		catch (DoctorNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	@PutMapping("/doctoredit/{id}")
	  public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long id, @RequestBody Doctor doctor) {
	  Optional <Doctor> doctorData= doctorRepo.findById(id);
	  
		if (doctorData.isPresent()) {
			Doctor _doctor = doctorData.get();
			_doctor.setName(doctor.getName());
			_doctor.setSpeciality (doctor.getSpeciality());
			_doctor.setMobileNo (doctor.getMobileNo());
			_doctor.setEmail (doctor.getEmail());

			return new ResponseEntity<>(doctorRepo.save( _doctor), HttpStatus.OK);
			 } else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}
	
	
	
	
	
	@DeleteMapping("/doctors/{id}")
	   public void deleteDoctor(@PathVariable("id") int id) {
		service.deleteDoctorById(id);
	   }
	
	

}
