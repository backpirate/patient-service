package com.pratian.PatientService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pratian.PatientService.Entities.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long>{

	@Query(value = "select a from Appointment a")
	public List<Appointment> getAppointmentProfile();

	
	@Query(value="select a from Appointment a where a.status= :status")
	public Appointment getAppointmentsByStatus(@Param(value="status")String status);
	
	
	
	
	
}
