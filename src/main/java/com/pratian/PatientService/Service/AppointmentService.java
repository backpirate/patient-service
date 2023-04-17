package com.pratian.PatientService.Service;

import java.util.List;

import com.pratian.PatientService.Dto.DoctorWithAppointmentDto;
import com.pratian.PatientService.Entities.Appointment;
import com.pratian.PatientService.Entities.Doctor;
import com.pratian.PatientService.Exceptions.AppointmentAlreadyExistException;
import com.pratian.PatientService.Exceptions.AppointmentNotFoundException;
import com.pratian.PatientService.Exceptions.DoctorNotFoundException;

public interface AppointmentService {

	
	public List<Appointment> getAppointmentProfile() throws AppointmentNotFoundException;

	public Appointment saveAppointmentProfile(Appointment appointment) throws AppointmentAlreadyExistException;


	public List<DoctorWithAppointmentDto> getAppointmentInfoWithDoctorId(long doctorId) throws DoctorNotFoundException;

	public  Appointment editAppointmentDetails(Appointment appointmentedit) throws AppointmentNotFoundException;

	public void deleteAppointmentById(long id);

	
}
