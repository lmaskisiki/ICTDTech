package infosource.open.services.routing;

import infosource.processors.JsonBuilder;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AggregateUserProfile implements AggregationStrategy {
	JSONObject object = new JSONObject();

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null) {
			return newExchange;
		}
		JsonBuilder json = new JsonBuilder(oldExchange.getIn()
				.getBody(String.class), newExchange.getIn()
				.getBody(String.class));
		oldExchange.getIn().setBody(json.results);	
		System.out.println("\n \n inside aggregation strategy \n");
		return oldExchange;
	}

}
