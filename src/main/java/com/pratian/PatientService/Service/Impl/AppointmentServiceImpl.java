package com.pratian.PatientService.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.PatientService.Dto.DoctorWithAppointmentDto;
import com.pratian.PatientService.Entities.Appointment;
import com.pratian.PatientService.Entities.Doctor;
import com.pratian.PatientService.Exceptions.AppointmentAlreadyExistException;
import com.pratian.PatientService.Exceptions.AppointmentNotFoundException;
import com.pratian.PatientService.Exceptions.DoctorNotFoundException;
import com.pratian.PatientService.Repository.AppointmentRepo;
import com.pratian.PatientService.Repository.DoctorRepo;
import com.pratian.PatientService.Service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Override
	public List<Appointment> getAppointmentProfile() throws AppointmentNotFoundException {
		List<Appointment> appointments=appointmentRepo.getAppointmentProfile();
		if(appointments.isEmpty())
		{
			throw new AppointmentNotFoundException("Appointment profile not found");
		}
		return appointments;
	}

	@Override
	public Appointment saveAppointmentProfile(Appointment appointment) throws AppointmentAlreadyExistException {
		Appointment appointment1 = null;
		if(appointmentRepo.existsById(appointment.getAppointmentId())) {
			throw new AppointmentAlreadyExistException("Patient already exists. Please add another patient..");
		}
		else {
			appointment1 =appointmentRepo.save(appointment);
		}
		return appointment1;
	}

	@Override
	public List<DoctorWithAppointmentDto> getAppointmentInfoWithDoctorId(long doctorId) throws DoctorNotFoundException{
		List<DoctorWithAppointmentDto> appointments=doctorRepo.getAppointmentInfoWithDoctorId(doctorId);
		if(appointments.isEmpty())
		{
			throw new DoctorNotFoundException("doctor profile not found");
		}
		return appointments;
	}

//	@Override
//	public Appointment editAppointmentDetails(Appointment appointmentedit) throws AppointmentNotFoundException {
//		  Appointment ap=null;
//	        if(appointmentRepo.existsById(appointmentedit.getAppointmentId())) {
//	            ap=appointmentRepo.findById(appointmentedit.getAppointmentId()).get();
//	            ap.setDate(appointmentedit.getDate());
//	            ap.setStatus(appointmentedit.getStatus());
////	            ap.setDetails(appointmentedit.getDetails());
//	            appointmentRepo.save(ap);
//	        }
//	       
//	        else{
//	           throw new AppointmentNotFoundException();
//	        }
//
//
//
//	       return ap;
//	}

	
	@Override
	public Appointment editAppointmentDetails(Appointment appointmentedit) throws AppointmentNotFoundException {
		// TODO Auto-generated method stub
		Appointment ap=null;
		if(appointmentRepo.existsById(appointmentedit.getAppointmentId())) {
			ap=appointmentRepo.findById(appointmentedit.getAppointmentId()).get();
			ap.setDate(appointmentedit.getDate());
//			ap.setDoctorId(appointmentedit.getDoctorId());
//			ap.setPrescription(appointmentedit.getPrescription());
			ap.setReasonForVisit(appointmentedit.getReasonForVisit());
			ap.setStatus(appointmentedit.getStatus());
//			ap.setTest(appointmentedit.getTest());
			appointmentRepo.save(ap);
		}
       
        else{
           throw new AppointmentNotFoundException();
        }

		return ap;
	}

	
	public void deleteAppointmentById(long id) {
		appointmentRepo.deleteById(id);
		

	}

	

	
}
