package com.pratian.PatientService.Controller;

import java.util.Optional;

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

import com.pratian.PatientService.Entities.Appointment;
import com.pratian.PatientService.Exceptions.AppointmentAlreadyExistException;
import com.pratian.PatientService.Exceptions.AppointmentNotFoundException;
import com.pratian.PatientService.Repository.AppointmentRepo;
import com.pratian.PatientService.Repository.PatientServiceFactory;
import com.pratian.PatientService.Service.AppointmentService;


@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/appointment")

public class AppointmentController {

	@Autowired
	private AppointmentService service = PatientServiceFactory.appointmentService() ;
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@GetMapping("/appointments")
	public ResponseEntity<?> get(){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getAppointmentProfile(), HttpStatus.OK);
		}
		catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	@PostMapping("/appointments")
//	@Operation(summary = "To save a Appointment")
	public ResponseEntity<?> post(@RequestBody Appointment appointment){
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.saveAppointmentProfile(appointment), HttpStatus.OK);
		} catch (AppointmentAlreadyExistException e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
//	@PutMapping("/appointmentedit")
//
////			@PutMapping("/appointmentedit")
//
//	//@Operation(summary = "To save a mobile")
//	public ResponseEntity<?> put(@RequestBody Appointment appointmentedit){
//		ResponseEntity<?> response = null;
//		try {
//			response = new ResponseEntity<>(service.editAppointmentDetails(appointmentedit), HttpStatus.OK);
//		} catch (AppointmentNotFoundException e) {
//			response = new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
//		}
//		return response;
//	}
	
	
	
	@PutMapping("/appointmentedit/{id}")
	  public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id, @RequestBody Appointment appointment) {
	  Optional <Appointment> appointmentData= appointmentRepo.findById(id);
	  
		if (appointmentData.isPresent()) {
			Appointment _appointment = appointmentData.get();
			_appointment.setDate(appointment.getDate());
			_appointment.setStatus (appointment.getStatus());
			_appointment.setReasonForVisit (appointment.getReasonForVisit()); 
			return new ResponseEntity<>(appointmentRepo.save( _appointment), HttpStatus.OK);
			 } else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}
	  
	
	@DeleteMapping("/appointment/{id}")
	   public void deleteEmployee(@PathVariable("id") int id) {
		service.deleteAppointmentById(id);
	   }
	
	
	
	
}
