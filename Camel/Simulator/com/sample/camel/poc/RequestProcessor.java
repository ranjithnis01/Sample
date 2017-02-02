package com.sample.camel.poc;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RequestProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("INSIDE REQUEST PROCESSOR"+exchange.getIn());
		//decide what to send to the to queue
//		exchange.getIn().setBody("REQUEST:::: James");
//        Map<String, Object> headers = new HashMap<String, Object>();
//        headers.put("cheese", 123);
//        headers.put("JMSReplyTo", "TEST_REPLY");
//        headers.put("JMSCorrelationID", "CorrelationID-1234");
//        headers.put("JMSXGroupID", groupID);
//        exchange.getIn().setHeaders(headers);
//        exchange.getOut().setHeaders(headers);
//        exchange.getOut().setBody("REQUEST:::: James");
	}

}
