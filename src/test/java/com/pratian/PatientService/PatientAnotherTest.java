// package com.pratian.PatientService;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// //import org.mapstruct.Builder;
// import org.mockito.Mockito;
// import org.skyscreamer.jsonassert.JSONAssert;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.mock.web.MockHttpServletResponse;
// import org.springframework.test.context.junit.jupiter.SpringExtension;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.MvcResult;
// import org.springframework.test.web.servlet.RequestBuilder;
// import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
// import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
// import com.pratian.PatientService.Entities.Patient;
// import com.pratian.PatientService.Entities.Symptom;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.pratian.PatientService.Controller.PatientController;
// import com.pratian.PatientService.Entities.Appointment;
// import com.pratian.PatientService.Service.IPatientService;
// import com.pratian.PatientService.Service.AppointmentService;
// import com.pratian.PatientService.Service.ParentWithPet;

// //import lombok.Builder;
// //import lombok.Value;
// import lombok.Builder;
// import lombok.Singular;
// import java.util.Set;
// //import junit.framework.Test;
// import junit.framework.TestCase;
// import junit.framework.TestSuite;




// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
// import static org.hamcrest.Matchers.*;


// //import com.in28minutes.springboot.model.Course;
// //import com.in28minutes.springboot.service.StudentService;

// @ExtendWith(SpringExtension.class)
// @WebMvcTest(value = PatientController.class)

// //@WithMockUser
// public class PatientAnotherTest {

// 	//@Autowired
// 	@Autowired(required = false)
// 	private MockMvc mockMvc;
// 	//@Builder(access = AccessLevel.PACKAGE)
// 	@MockBean
	
	
// 	private IPatientService patientService;
// 	List<Patient>patients=new ArrayList();
// 	Patient patient = new Patient();

// 	Patient mockPatient = new Patient();
	
// 	//patient.add(Patient);
// //	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
// 	String examplePatientJson = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",\"allergies\":\"string\"}";

// 	@Test
// 	public void getPatientTest() throws Exception {

// 		Mockito.when(
// 				patientService.getPatientProfile()).thenReturn(patients);
				
// //				patientService.getPatientProfile());
// 		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
// 				"/patient/patients").accept(
// 				MediaType.APPLICATION_JSON);

// 		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

// 		System.out.println(result.getResponse());
// 		//String now = "{\"name\":\"string\",\"species\":\"string\",\"gender\":\"string\",\"reproductivity\":\"string\",\"booldGroup\":\"string\",,\"allergies\":\"string\"}";

// 		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

// 		//JSONAssert.assertEquals(now, result.getResponse()
// 		//		.getContentAsString());
// 	}

	
// //	@Test
// //	public void savePatientTest() throws Exception {
// //		Patient mockPatient = new Patient();
// //     //  Patient mockPatient = new Patient(1,"doggo","spenial","male","bad","a","dust");
// //		// studentService.addCourse to respond back with mockCourse
// //		Mockito.when(patientService.savePatientProfile(mockPatient)).thenReturn(mockPatient);
// //
// //		// Send course as body to /students/Student1/courses
// //		RequestBuilder requestBuilder = MockMvcRequestBuilders
// //				.post("/patient/patient/patientss")
// //				.accept(MediaType.APPLICATION_JSON)
// //				.content(examplePatientJson)
// //				.contentType(MediaType.APPLICATION_JSON);
// //
// //		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
// //
// //		MockHttpServletResponse response = result.getResponse();
// //
// //		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
// //
// //		assertEquals("http://localhost:8096/patient/patient/patients",
// //				response.getHeader(HttpHeaders.LOCATION));
// //
// //	}
// //	
// //	
// //	
// //	@Test
// //	
// //	@Builder
// //	
// //	public void savePatient() throws Exception {
// //	    Patient patient = new Patient() ;
// ////	    		.builder()
// ////	            .name("John Doe")
// ////	            .age(47)
// ////	            .species("spenial")
// ////	            .build();
// //
// ////	    Mockito.when(patientRecordRepository.save(record)).thenReturn(record);
// //		Mockito.when(patientService.savePatientProfile(Mockito.any(Patient.class))).thenReturn(mockPatient);
// //
// //	    MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/patient/patient/patientss")
// //	            .contentType(MediaType.APPLICATION_JSON)
// //	            .accept(MediaType.APPLICATION_JSON)
// //	            .content(this.mapper.writeValueAsString(patient));
// //
// //	    mockMvc.perform(mockRequest)
// //	            .andExpect(status().isOk())
// //	            .andExpect(jsonPath("$", notNullValue()))
// //	            .andExpect(jsonPath("$.name", is("John Doe")));
// //	    }
// //	
// //	
// //	@Test
// //	public void testAddEmployee() throws Exception {
// //
// //		// prepare data and mock's behaviour
// //		Employee empStub = new Employee(1l, "bytes", "tree", "developer", 12000);
// //		when(empService.save(any(Employee.class))).thenReturn(empStub);
// //
// //		// execute
// //		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
// //				.accept(MediaType.APPLICATION_JSON_UTF8).content(TestUtils.objectToJson(empStub))).andReturn();
// //
// //		// verify
// //		int status = result.getResponse().getStatus();
// //		assertEquals("Incorrect Response Status", HttpStatus.CREATED.value(), status);
// //
// //		// verify that service method was called once
// //		verify(empService).save(any(Employee.class));
// //
// //		Employee resultEmployee = TestUtils.jsonToObject(result.getResponse().getContentAsString(), Employee.class);
// //		assertNotNull(resultEmployee);
// //		assertEquals(1l, resultEmployee.getId().longValue());
// //
// //	}


// }
