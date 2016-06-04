package infosource.open.services.access;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.apache.cxf.message.MessageContentsList;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;

import useraccount.soap.services.CreatePerson;
import useraccount.soap.services.Person;
import webframeapp.interfaces.FeedPost;

public class TransactionManager implements ITransactionManager {
	private ApplicationContext context;
	private CamelContext camelContext;

	private ProducerTemplate template = null;

	public TransactionManager() {

		try {
			this.context = new ClassPathXmlApplicationContext(
					"META-INF/service-endpoints.xml");
			this.camelContext = SpringCamelContext.springCamelContext(context);

			template = this.camelContext.createProducerTemplate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean createAccount(Person person) {

		try {
			template.start();
			MessageContentsList ms = new MessageContentsList();
			ms.add(person);
			template.requestBodyAndHeader("direct:UAService", ms, "methodName",
					"createPerson", String.class);
			template.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getNews() {
		String response = "";
		try {
			template.start();
			MessageContentsList ms = new MessageContentsList();
			response = template.requestBodyAndHeader("direct:NewsFeeds", ms,
					"methodName", "listPosts", String.class);
			JSONObject on = new JSONObject(response);
			Gson json = new Gson();
			FeedPost feeds = json.fromJson(
					(on.getJSONObject(
							"org.apache.cxf.message.MessageContentsList")
							.getJSONObject("list").getJSONObject("list")
							.getString("webframeapp.interfaces.FeedPost"))
							.toString(), FeedPost.class);
			System.out.println("\n \n the size now is:" + feeds);
			template.stop();
			response = json.toJson(feeds);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@Override
	public String getMyProfile(String username) {
		String response = "";
		try {
			template.start();
			MessageContentsList ms = new MessageContentsList();
			ms.add(username);
			response = template.requestBodyAndHeader("direct:UAService", ms,
					"methodName", "findByUsername", String.class);
			JSONObject on = new JSONObject(response);
			Gson json = new Gson();
			Person person = json.fromJson(
					(on.getJSONObject(
							"org.apache.cxf.message.MessageContentsList")
							.getJSONObject("list")
							.getString("useraccount.soap.services.Person"))
							.toString(), Person.class);
			template.stop();
			response = json.toJson(person);
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	@Override
	public String getHealthInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHomeAffairInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMyDocuments(String username) {
		String response = "";
		try {
			template.start();
			MessageContentsList ms = new MessageContentsList();
			ms.add(username);
			response = template.requestBodyAndHeader("direct:DocManEndpoint",
					ms, "methodName", "getFilesByOwner", String.class);

			template.stop();

		} catch (Exception e) {
			e.getMessage();
		}
		return response;

	}

	@Override
	public String fullProfile(String username) {
		String response = "";
		try {
			template.start();
			MessageContentsList ms = new MessageContentsList();
			ms.add(username);
			response = template.requestBodyAndHeader("direct:UAService", ms,
					"methodName", "findByUsername", String.class);
			template.stop();

		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

}
