package com.sample.test;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CompletionProcessor implements Processor{
	@Override

	public void process(Exchange exchange) throws Exception {
		
	Date date = new Date();	
	System.out.println(exchange);
	System.out.println( "inside completion processor"+date);
	
	Thread.sleep(30000);
	Date date1 = new Date();
	System.out.println("inside completion at the end"+date1);
	
	}

}

