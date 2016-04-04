package infosource.routebuilders;

import infosource.aggregators.SearchAggregation;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SearchBuilder  extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// from("activemq:topic:topic/clientSearch").aggregate().header("id").completionTimeout(500).to("activemq:topic:testTopic");
		 from("activemq:go").aggregate(header("id"), new  SearchAggregation()).to("activemq:topic:testTopic");

	}

}
