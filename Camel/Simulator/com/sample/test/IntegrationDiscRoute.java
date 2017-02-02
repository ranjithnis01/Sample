package com.sample.test;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.CsvDataFormat;

public class IntegrationDiscRoute extends RouteBuilder {

@Override

public void configure() throws Exception {

	CsvDataFormat csv = new CsvDataFormat();
//	csv.setSkipFirstLine(true);
	
from("file:target/inbox")

.process(new LoggingProcessor())

.bean(new TransformationBean())

.unmarshal(csv)

//.split(body().tokenize(“,”))

.choice()

.when(body().contains("DVD"))

.to("file:target/outbox/dvd")

.when(body().contains("CD"))

.to("activemq:CD_Orders")

.otherwise()

.to("mock:others");

}

}
