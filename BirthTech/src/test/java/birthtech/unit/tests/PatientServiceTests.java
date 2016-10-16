package birthtech.unit.tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
 import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
 import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
 import org.mockito.runners.MockitoJUnitRunner;
 

 
import static org.mockito.Mockito.*;
import birthtech.entities.Patient;
import birthtech.enums.EmploymentEnum;
 import birthtech.repositories.MartenalRepository;
import birthtech.services.PatientService;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTests {
	@InjectMocks
	private PatientService SUTservice;
	@Mock
	private MartenalRepository repo;
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void BeforeTest() {
		MockitoAnnotations.initMocks(this);
		when(repo.save(Matchers.<Patient> any())).thenReturn(
				mock(Patient.class));
		when(repo.findAll()).thenReturn(GetPatientList());
	}

	@Test
	public void given_valid_details_should_suucessfully_save_patient() {
		Patient patient = new Patient();
		patient.setIdnumber(123);
		patient.setSurname("Surname");
		patient.setNames("Name");

		boolean result = SUTservice.addMaternity(patient);
		Assert.assertEquals(true, result);
	}

	@Test
	public void when_getting_all_patients() {
		List<Patient> results = SUTservice.getMartenal();

		// verify(repo, atLeast(2)).findAll();
		verify(repo, only()).findAll();
		Assert.assertNotNull(results);
		Assert.assertTrue(results.get(0).getIdnumber() == GetPatientList().get(
				0).getIdnumber());
	}

	@Test
	public void when_search_yields_no_match_should_return_null() {
		Patient patient = SUTservice.getMaternityByFullname("Surname Name");
		verify(repo, only()).findAll();
		Assert.assertNull(patient);
	}

	@Test
	public void should_throw_exception_when_null_patient_is_given() {
		Patient patient = null;

		exception.expect(NullPointerException.class);
		exception.expectMessage("Null Reference");
		SUTservice.addMaternity(patient);
	}

	@Test
	public void given_mssing_identifies_should_throw_exception_01() {
		Patient p = new Patient();
		p.setEmployementStatus(EmploymentEnum.UNEMPLOYED.name());
		p.setRegistration(new Date());
		p.setNurse("Nurse Name");

		exception.expect(NullPointerException.class);
		exception.expectMessage("Null or Empty Idenfifier Detected");
		SUTservice.addMaternity(p);
	}

	@After
	public void tearDown() {
		System.out.println("Done");

	}
	// Test Data -- patient list
	public List<Patient> GetPatientList() {
		List<Patient> patientList = new ArrayList<Patient>();
		Patient p = new Patient();
		p.setIdnumber(123);
		patientList.add(p);
		return patientList;
	}
}
