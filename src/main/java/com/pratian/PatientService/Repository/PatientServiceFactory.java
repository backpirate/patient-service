package com.pratian.PatientService.Repository;

import com.pratian.PatientService.Service.AppointmentService;
import com.pratian.PatientService.Service.IPatientService;
import com.pratian.PatientService.Service.Impl.AppointmentServiceImpl;
import com.pratian.PatientService.Service.Impl.PatientServiceImpl;

public class PatientServiceFactory {

	public 	static AppointmentService appointmentService() {
		return new AppointmentServiceImpl();
	}
		
	
		public 	static IPatientService patientService() {
			return new PatientServiceImpl();
	}
	
}
