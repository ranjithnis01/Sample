package com.sample.test;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CAMELProcessor implements Processor{
	@Override

	public void process(Exchange exchange) throws Exception {
	Date date = new Date();
	System.out.println("Received Order: date" +date+

	exchange.getIn().getBody(String.class));

	}

}

