package birthcertificate.routebuilders;

import org.apache.camel.ExchangePattern;
import org.hibernate.ejb.criteria.expression.SearchedCaseExpression.WhenClause;
import org.springframework.stereotype.Component;

import birthcertificate.processors.BCProcessor;
import birthcertificate.processors.ProcessApplication;

@Component
public class RouteBuilder extends org.apache.camel.builder.RouteBuilder {

	@Override
	public void configure() throws Exception {

		from("activemq:acceptGrantApplication").process(
				new ProcessApplication());
		 from("direct:start").setExchangePattern(ExchangePattern.InOptionalOut).to("activemq:findUser");
	 
	}

}
