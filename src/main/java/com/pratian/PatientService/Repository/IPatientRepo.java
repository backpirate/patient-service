package com.pratian.PatientService.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.PatientService.Dto.PatientParentDto;
import com.pratian.PatientService.Dto.PatientWithAppointmentDto;
import com.pratian.PatientService.Dto.PatientWithPrescriptionDto;
import com.pratian.PatientService.Dto.PatientWithSymptomDto;
import com.pratian.PatientService.Dto.PatientWithTestDto;
import com.pratian.PatientService.Dto.PatientWithVitalDto;
import com.pratian.PatientService.Entities.Appointment;
import com.pratian.PatientService.Entities.Patient;
import com.pratian.PatientService.Entities.Prescription;

@Repository
public interface IPatientRepo extends JpaRepository<Patient, Long>{

	@Query(value = "select p from Patient p")
	public List<Patient> getPatientProfile();
	
	//public Patient findByPatient_PatientId(Long patientId);

	//@Query(value = "SELECT * FROM patient p INNER JOIN pet_parent pp ON p.patient_id=pp.patientId",nativeQuery = true)
	//@Query(value = "SELECT * FROM patient p INNER JOIN pet_parent pp ON p.parent_id=pp.parent_id where patient_id= :patientId",nativeQuery = true)
	//select ci from City ci where ci.cityId=:cityId
	//@Query(value = "select pp.* from Patient p INNER JOIN pet_parent pp ON p.parent_id=pp.parent_id where patient_id= :patientId",nativeQuery = true)
	//@Query(value ="select p.name from patient p INNER JOIN pet_parent pp where p.patient_id=:patientId",nativeQuery = true)
	//@Query(value="select * from pet_parent as pp join pp.patient as p where p.patient_id=:patientId",nativeQuery = true)
	//INNER JOIN Pet_Parent pp where p.patient_Id=:patientId",nativeQuery = true
	
	@Query(value ="SELECT new com.pratian.PatientService.Dto.PatientParentDto(p.name, p.age, p.gender, pp.parentName,pp.address,pp.email, pp.mobileNo) FROM PetParent pp JOIN pp.patients p WHERE p.patientId= :patientId")
	public List<PatientParentDto> getPatientInfo(@Param(value="patientId")Long patientId);

	
	@Query("SELECT new com.pratian.PatientService.Dto.PatientWithSymptomDto( p.name , s.symptomId ) FROM Patient p JOIN p.symptoms s WHERE p.patientId= :patientId")
	public List<PatientWithSymptomDto> getJoinInformation(@Param(value="patientId")Long patientId);
	
	//get Appointment details with patient id
	@Query("SELECT new com.pratian.PatientService.Dto.PatientWithAppointmentDto( p.name , a.appointmentId,a.status , a.reasonForVisit ) FROM Patient p JOIN p.appointments a WHERE p.patientId= :patientId")
	public List<PatientWithAppointmentDto> getAppointmentInfoWithPatientId(@Param(value="patientId")Long patientId);
	 
	
	
	//get prescription details with patient id
	@Query("SELECT new com.pratian.PatientService.Dto.PatientWithPrescriptionDto(p.name,pr.preId,pr.days,pr.medicine,pr.comments) FROM Patient p JOIN p.appointments a JOIN a.prescriptions pr WHERE p.patientId= :patientId")
	public List<PatientWithPrescriptionDto> getPrescriptionInfoWithPatientId(@Param(value="patientId")Long patientId);

	
	//get vitals details with patient id                                                                 
	@Query("SELECT new com.pratian.PatientService.Dto.PatientWithVitalDto(p.patientId,p.name,v.vitalId,v.heartBeat,v.temp,v.bp,v.lungsBpm) FROM Patient p JOIN p.appointments a JOIN a.vital v WHERE p.patientId= :patientId")
	public List<PatientWithVitalDto> getVitalInfoWithPatientId(@Param(value="patientId")Long patientId);

	
		//get vitals details with patient id                                                      
		@Query("SELECT new com.pratian.PatientService.Dto.PatientWithTestDto(p.patientId,p.name,t.testId,t.testdesc) FROM Patient p JOIN p.appointments a JOIN a.tests t WHERE p.patientId= :patientId")
		public List<PatientWithTestDto> getTestInfoWithPatientId(@Param(value="patientId")Long patientId);
	
	
	
	
	//	@Query(value = "select * from product where prod_id=id")//SQL
//	@Query(value = "select p from Product p where p.prodId=:id")//HQL//Or//JPQL
//	@Query(value="select a from Appointment a where a.status= :status")
//	public Appointment getAppointmentsByStatus(@Param(value="status")String status);

}
