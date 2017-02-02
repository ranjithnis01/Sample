package com.sample.camel.poc;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ResponseProcessor implements Processor,MessageListener{

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("INSIDE RESPONSE PROCESSOR");
//		System.out.println("inside response"+exchange.getIn());
		//decide what to send to the to queue
//        Map<String, Object> headers = new HashMap<String, Object>();
//        headers.put("cheese", 123);
//        headers.put("JMSReplyTo", "TEST_REPLY");
//        headers.put("JMSCorrelationID", "CorrelationID-1234");
//        headers.put("JMSXGroupID", groupID);
//        exchange.getIn().setHeaders(headers);
//		   exchange.getOut().setHeaders(exchange.getIn().getHeaders());
//	        exchange.getOut().setBody("RESPONSE:::: James");
		
	}

	@Override
	public void onMessage(Message msg) {
		System.out.println(msg.toString());
		
	}

}
