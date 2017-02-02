package com.sample.test;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class LoggingProcessor implements Processor{
	@Override

	public void process(Exchange exchange) throws Exception {
	Date date = new Date();
	System.out.println("INSIDE LOGGING" +date);

	}

}

