package infosource.messaging.router;

import infosource.messaging.models.Labour;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import birthcertificate.ews.soap.BatchApplication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BatchApplicationProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Message msg = exchange.getIn();
		JSONObject jres = new JSONObject(msg.getBody(String.class));
		JSONArray jArray = jres.getJSONObject("list").getJSONArray(
						"infosource.messaging.models.Labour");
		Gson gson = new GsonBuilder().registerTypeAdapter(
				Date.class, new GsonUTCdateAdapter()).create();
		Labour[] response = gson.fromJson(jArray.toString(),
				Labour[].class);
		BatchApplication app= new BatchApplication();
		app.setArg0(gson.toJson(response));
		List<Labour> list = Arrays.asList(response);
		System.out.println("nnnnnnnnnn \n"
				+ list.get(0).getBirthPlace());
		 msg.setBody(app,BatchApplication.class);
		// );
	 exchange.setOut(msg);
	}


}
