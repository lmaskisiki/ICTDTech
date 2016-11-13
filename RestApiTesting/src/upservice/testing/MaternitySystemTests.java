package upservice.testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
public class MaternitySystemTests {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		RestAssured.baseURI="http:192.168.43.12:8181";
		RestAssured.basePath="/cxf/martservice";
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
