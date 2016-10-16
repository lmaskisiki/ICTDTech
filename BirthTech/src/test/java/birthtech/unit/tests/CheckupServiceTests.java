/**
 * 
 */
package birthtech.unit.tests;

import static org.junit.Assert.*;

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

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.only;

import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import birthtech.entities.Checkup;
import birthtech.repositories.CheckupRepository;
import birthtech.services.CheckupService;

/**
 * @author lizo
 *
 */

@RunWith(MockitoJUnitRunner.class)
public class CheckupServiceTests {

	@InjectMocks
	private CheckupService SUT;
	@Mock
	private CheckupRepository checkupRepo;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		when(checkupRepo.save(Matchers.<Checkup> any())).thenReturn(
				GetCheckupList().get(0));
		when(checkupRepo.findAll()).thenReturn(GetCheckupList());
	}

	private List<Checkup> GetCheckupList() {
		Checkup checkup = new Checkup();
		checkup.setCheckupId(123);
		checkup.setComments("Patient is ok");
		checkup.setDate(new Date());
		checkup.setDelivered(true);
		checkup.setMartenalId(123);
		checkup.setNurse("Nurse");
		checkup.setPlace("Place");
		List<Checkup> list = new ArrayList<Checkup>();
		list.add(checkup);
		return list;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void given_valid_checkup_details_to_save_should_return_success() {
		Checkup c = new Checkup();
		c.setMartenalId(123);
		c.setNurse("Nurse");
		c.setComments("Comments");
		Checkup result = SUT.addCheckup(c);

		verify(checkupRepo, only()).save(c);
		Assert.assertNotNull(result);
		Assert.assertTrue(result.getMartenalId() == c.getMartenalId());
	}

	@Test
	public void given_invalid_checkup_details_should_throw_exception() {
		Checkup check = new Checkup();

		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Missing important fields");
		SUT.addCheckup(check);
	}

	@Test
	public void given_null_checkup_should_throw_nullpointer_exception() {
		Checkup check = null;

		exception.expect(NullPointerException.class);
		exception.expectMessage("Checkup object not initialized");
		SUT.addCheckup(check);
	}

}
