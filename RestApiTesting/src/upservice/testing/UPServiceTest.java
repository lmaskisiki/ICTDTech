package upservice.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.path.json.JsonPath.from;

public class UPServiceTest {

	private Response response;

	@org.junit.BeforeClass
	public static void BeforeClass() {
		RestAssured.baseURI = "http://192.168.43.12:8181";
		RestAssured.basePath = "/cxf/upservice";
	}

	@Test
	public void should_return_http_status_code_200() {
		String username = "admin";
		response = when().get("/basic/" + username).then().extract().response();

		assertTrue(response.statusCode() == 200);
	}

	@Test
	public void posting_existing_entry_should_return_action_could_not_be_completed_message_with_exception_message() {
		Person accountDetails = new Person();
		accountDetails.setFirstName("TesterUser1");
		accountDetails.setLastName("TesterUser2");
		accountDetails.setCell("0117144432");
		accountDetails.setEmail("email@test.com");
		accountDetails.setGender("male");
		accountDetails.setUsername("tester");
		accountDetails.setPassword("tester@tester");
 		accountDetails.setIdNumber("901010");
  		Gson gson = new Gson();
		response = given().with().body(gson.toJson(accountDetails)).contentType(ContentType.JSON).when()
				.post("/createaccount").then().extract().response();

		assertEquals(response.statusCode(), 200);
		assertTrue(response.asString().contains("Action could not be completed"));
	}

	@Test
	public void posting_unmatching_json_object_should_faild_with_action_could_not_be_completed_message() {
		String body = "{ \"firstName\" :\"name1\" , \"mobile\" : \"0778888888\"  }";
		response = given().body(body).contentType(ContentType.JSON).when().post("/createaccount").then().extract()
				.response();

		assertEquals(response.statusCode(), 200);
		assertTrue(response.asString().contains("javax.naming.directory.InvalidAttributeValueException"));
	}

	@Test
	public void given_valid_username_and_profile_mode_as_docs_should_return_only_document_records() {
		response = given().contentType(ContentType.JSON).when().get("/docs/admin").then().extract().response();

		assertEquals(response.statusCode(), 200);
		assertNotNull((from(response.asString()).getList("documents")));
		assertNull((from(response.asString()).getList("personalDetails")));

	}

	@Test
	public void given_valid_username_and_basic_profile_mode_should_return_user_details() {
		String username = "admin";
		response = when().get("/basic/" + username).then().contentType(ContentType.JSON).extract().response();

		ArrayList<Map<String, ?>> jsonAsArrayList = from(response.asString()).get("personalDetails");

		assertNotNull(jsonAsArrayList);
		assertTrue(jsonAsArrayList.get(0).containsKey("firstName"));
		assertTrue(jsonAsArrayList.get(0).containsKey("lastName"));
		assertEquals(jsonAsArrayList.get(0).get("username"), username);
	}

	@Test
	public void given_valid_username_and_profile_mode_as_full_should_return_user_details_and_document_records() {
		String username = "admin";
		response = when().get("/full/" + username).then().contentType(ContentType.JSON).extract().response();

		ArrayList<Map<String, ?>> userDetails = from(response.asString()).get("personalDetails");
		ArrayList<Map<String, ?>> documentRecords = from(response.asString()).get("documents");

		Assert.assertTrue(userDetails.get(0).containsKey("firstName"));
		Assert.assertTrue(userDetails.get(0).containsKey("lastName"));
		Assert.assertEquals(userDetails.get(0).get("username"), username);
	}
}
