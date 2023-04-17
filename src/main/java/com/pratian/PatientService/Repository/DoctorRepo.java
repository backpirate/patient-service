package com.pratian.PatientService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.PatientService.Dto.DoctorWithAppointmentDto;
import com.pratian.PatientService.Dto.PatientWithSymptomDto;
import com.pratian.PatientService.Entities.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

	@Query(value = "select d from Doctor d")
	public List<Doctor> getDoctorProfile();
																								
	@Query("SELECT new com.pratian.PatientService.Dto.DoctorWithAppointmentDto( d.doctorId, d.name , a.appointmentId , a.status, a.reasonForVisit ) FROM Doctor d JOIN d.appointments a WHERE d.doctorId= :doctorId")
	public List<DoctorWithAppointmentDto> getAppointmentInfoWithDoctorId(@Param(value="doctorId")Long doctorId);
	

}
