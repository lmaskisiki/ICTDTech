package infosource.aggregators;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class SearchAggregation  implements AggregationStrategy{

	@Override
	public Exchange aggregate(Exchange arg0, Exchange arg1) {
		System.out.println("\n \n Aggregator reached!! \n \n");
		
		 String nweMsg =arg0.getIn().getBody(String.class);
		 String oldMsg =arg1.getIn().getBody(String.class);
		 
		 arg0.getIn().setBody(nweMsg+"\n"+oldMsg);
		 
		return arg0;
	}

}
