package com.pratian.PatientService.Service.Impl;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.PatientService.Dto.PatientParentDto;
import com.pratian.PatientService.Dto.PatientWithAppointmentDto;
import com.pratian.PatientService.Dto.PatientWithPrescriptionDto;
import com.pratian.PatientService.Dto.PatientWithSymptomDto;
import com.pratian.PatientService.Dto.PatientWithTestDto;
import com.pratian.PatientService.Dto.PatientWithVitalDto;
import com.pratian.PatientService.Entities.Appointment;
//import com.pratian.PatientService.Entities.Appointment;
import com.pratian.PatientService.Entities.Doctor;
import com.pratian.PatientService.Entities.Patient;
import com.pratian.PatientService.Entities.PetParent;
import com.pratian.PatientService.Entities.Symptom;
import com.pratian.PatientService.Exceptions.AppointmentNotFoundException;
//import com.pratian.PatientService.Exceptions.AppointmentAlreadyExistException;
//import com.pratian.PatientService.Exceptions.AppointmentNotFoundException;
import com.pratian.PatientService.Exceptions.DoctorAlreadyExistException;
import com.pratian.PatientService.Exceptions.DoctorNotFoundException;
import com.pratian.PatientService.Exceptions.PatientAlreadyExistException;
import com.pratian.PatientService.Exceptions.PatientNotFoundException;
import com.pratian.PatientService.Exceptions.PetParentNotFoundException;
import com.pratian.PatientService.Exceptions.SymptomAlreadyExistException;
import com.pratian.PatientService.Exceptions.SymptomNotFoundException;
import com.pratian.PatientService.Exceptions.petparentAlreadyExistException;
//import com.pratian.PatientService.Repository.AppointmentRepo;
import com.pratian.PatientService.Repository.DoctorRepo;
//import com.pratian.PatientService.Exceptions.paitentAlreadyExistException;
import com.pratian.PatientService.Repository.IPatientRepo;
import com.pratian.PatientService.Repository.PetParentRepo;
import com.pratian.PatientService.Repository.SymptomRepo;
import com.pratian.PatientService.Service.IPatientService;
import com.pratian.PatientService.Service.ParentWithPet;


@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private IPatientRepo patientRepo;
	
//	@Autowired
//	private AppointmentRepo appointmentRepo;
//	
	@Autowired
	private SymptomRepo symptomRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private PetParentRepo petparentRepo;
	
//	@Autowired
//	private PatientVitalMapper mapper;
	
	
	@Override
	public List<Patient> getPatientProfile() throws PatientNotFoundException  {
		List<Patient> patients=patientRepo.getPatientProfile();
		if(patients.isEmpty())
		{
			throw new PatientNotFoundException("patient profile not found");
		}
		return patients;
	}

	@Override
	public Patient savePatientProfile(Patient patient) throws PatientAlreadyExistException {
		Patient patient1 = null;
		if(patientRepo.existsById(patient.getPatientId())) {
			throw new PatientAlreadyExistException("Patient already exists. Please add another patient..");
		}
		else {
			patient1 =patientRepo.save(patient);
		}
		return patient1;
	}

//	@Override
//	public List<Appointment> getAppointmentProfile() throws AppointmentNotFoundException {
//		List<Appointment> appointments=appointmentRepo.getAppointmentProfile();
//		if(appointments.isEmpty())
//		{
//			throw new AppointmentNotFoundException("Appointment profile not found");
//		}
//		return appointments;
//	}
//
//	@Override
//	public Appointment saveAppointmentProfile(Appointment appointment) throws AppointmentAlreadyExistException {
//		Appointment appointment1 = null;
//		if(appointmentRepo.existsById(appointment.getAppointmentId())) {
//			throw new AppointmentAlreadyExistException("Patient already exists. Please add another patient..");
//		}
//		else {
//			appointment1 =appointmentRepo.save(appointment);
//		}
//		return appointment1;
//	}

	@Override
	public List<Symptom> getSymptoms() throws SymptomNotFoundException {
		List<Symptom> symptoms=symptomRepo.getSymptoms();
		if(symptoms.isEmpty())
		{
			throw new SymptomNotFoundException("Symptoms profile not found");
		}
		return symptoms;
	}

	@Override
	public Symptom saveSymptoms(Symptom symptom) throws SymptomAlreadyExistException  {
		Symptom symptom1 = null;
		if(symptomRepo.existsById(symptom.getSymptomId())) {
			throw new SymptomAlreadyExistException("Symptom already exists. Please add another patient..");
		}
		else {
			symptom1 =symptomRepo.save(symptom);
		}
		return symptom1;
	}

	@Override
	public List<Doctor> getDoctorProfile() throws DoctorNotFoundException {
		List<Doctor> doctors=doctorRepo.getDoctorProfile();
		if(doctors.isEmpty())
		{
			throw new DoctorNotFoundException("Doctors profile not found");
		}
		return doctors;
	}

	@Override
	public Doctor saveDoctorProfile(Doctor doctor) throws DoctorAlreadyExistException {
		Doctor doctor1 = null;
		if(doctorRepo.existsById(doctor.getDoctorId())) {
			throw new DoctorAlreadyExistException("Doctor profile already exists. Please add another Doctor profile..");
		}
		else {
			doctor1 =doctorRepo.save(doctor);
		}
		return doctor1;
	}

	
	
	@Override
	public List<PatientParentDto> viewPetParentProfile(long patientId) throws PatientNotFoundException {
		List<PatientParentDto> patients=patientRepo.getPatientInfo(patientId);
		if(patients==null)
		{
			throw new PatientNotFoundException("patient not found");
		}
		return patients;
	}
	@Override
	public List<PetParent> getPetParentProfile() throws PetParentNotFoundException {
		List<PetParent> petparents=petparentRepo.getPetParentProfile();
		if(petparents.isEmpty())
		{
			throw new PetParentNotFoundException("PetParent profile not found");
		}
		return petparents;
	}

	@Override
	public PetParent savePetParentProfile(PetParent petparent) throws petparentAlreadyExistException {
		PetParent petparent1 = null;
		if(petparentRepo.existsById(petparent.getParentId())) {
			throw new petparentAlreadyExistException("PetParent profile already exists. Please add another PetParent profile..");
		}
		else {
			petparent1 =petparentRepo.save(petparent);
		}
		return petparent1;	
		}

	@Override
	public List<PatientWithAppointmentDto> viewPetAppointmentHistory(long patientId) throws PatientNotFoundException {
		List<PatientWithAppointmentDto> patients=patientRepo.getAppointmentInfoWithPatientId(patientId);
		if(patients.isEmpty())
		{
			throw new PatientNotFoundException("Patient profile not found");
		}
		return patients;
	}

	
	@Override
	public List<PatientWithVitalDto> viewPetVitalHistory(long patientId) throws PatientNotFoundException {
		List<PatientWithVitalDto> patients=patientRepo.getVitalInfoWithPatientId(patientId);
		if(patients.isEmpty())
		{
			throw new PatientNotFoundException("Patient profile not found");
		}
		return patients;
	}

	@Override
	public List<PatientWithTestDto> viewPetTestHistory(long patientId) throws PatientNotFoundException {
		List<PatientWithTestDto> patients=patientRepo.getTestInfoWithPatientId(patientId);
		if(patients.isEmpty())
		{
			throw new PatientNotFoundException("Patient profile not found");
		}
		return patients;
	}

	@Override
	public List<PatientWithPrescriptionDto> viewPetPrescriptionHistory(long patientId) throws PatientNotFoundException {
		List<PatientWithPrescriptionDto> patients=patientRepo.getPrescriptionInfoWithPatientId(patientId);
		if(patients.isEmpty())
		{
			throw new PatientNotFoundException("Patient profile not found");
		}
		return patients;
	}

	@Override
	public List<PatientWithSymptomDto> viewPetSymptomHistory(long patientId) throws PatientNotFoundException {
		List<PatientWithSymptomDto> patients=patientRepo.getJoinInformation(patientId);
		if(patients.isEmpty())
		{
			throw new PatientNotFoundException("Patient profile not found");
		}
		return patients;
	}

	@Override
	public Doctor getDoctorById(long id) {
		Doctor doctor = doctorRepo.findById(id).get(); //in-built method //or
//		Product product = prodRepo.getProductById(id); //Custom Query //or
//		Product product = prodRepo.findById(id).orElseThrow(()-> new ProductNotFoundException("Product does not exist with this id"));
		return doctor;
	}

	@Override
	public void deleteDoctorById(long id) {
		doctorRepo.deleteById(id);
		
	}

	
	
	
	@Override
	public Doctor editDoctorDetails(Doctor doctoredit) throws DoctorNotFoundException {
		
		Doctor d =null;
		if(doctorRepo.existsById(doctoredit.getDoctorId())) {
			d=doctorRepo.findById(doctoredit.getDoctorId()).get();
			d.setName(doctoredit.getName());
			d.setNpiNo(doctoredit.getNpiNo());
			d.setSpeciality(doctoredit.getSpeciality());
			d.setMobileNo(doctoredit.getMobileNo());
			d.setEmail(doctoredit.getEmail());
//			ap.setTest(appointmentedit.getTest());
			doctorRepo.save(d);
		}
       
        else{
           throw new DoctorNotFoundException();
        }

		return d;
	}

	@Override
	public PetParent editPetParentDetails(PetParent petParentEdit) throws PetParentNotFoundException {
		PetParent pp =null;
		if(petparentRepo.existsById(petParentEdit.getParentId())) {
			pp=petparentRepo.findById(petParentEdit.getParentId()).get();
			pp.setParentName(petParentEdit.getParentName());
			pp.setEmail(petParentEdit.getEmail());
			pp.setMobileNo(petParentEdit.getMobileNo());
			pp.setAddress(petParentEdit.getAddress());
			petparentRepo.save(pp);
		}
       
        else{
           throw new PetParentNotFoundException();
        }

		return pp;
	}

	@Override
	public Patient editPatientDetails(Patient patientEdit) throws PatientNotFoundException {
		Patient p =null;
		if(patientRepo.existsById(patientEdit.getPatientId())) {
			p=patientRepo.findById(patientEdit.getPatientId()).get();
			p.setName(patientEdit.getName());
			p.setAge(patientEdit.getAge());
			p.setGender(patientEdit.getGender());
			patientRepo.save(p);
		}
       
        else{
           throw new PatientNotFoundException();
        }

		return p;
		
		
	}
	
	
	
	

	
	
	
	
	
	}