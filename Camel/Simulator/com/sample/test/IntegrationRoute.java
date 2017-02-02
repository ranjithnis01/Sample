package com.sample.test;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.OnCompletionProcessor;

public class IntegrationRoute extends RouteBuilder {

@Override

public void configure() throws Exception {

from("file:target/inbox")

                      .process(new LoggingProcessor())
                      .bean(new TransformationBean(),
                                  "makeUpperCase")
                      .onCompletion().bean(new CompletionProcessor())
//                      	.to("file:target/outbox/complete")                                  
                      .choice()
//                      .when(body().contains("CAMEL")).transacted().bean(new CAMELProcessor())
                      .when(body().contains("CAMEL"))
                      	.to("file:target/outbox/dvd")
                      .when(body().contains("CD"))
                      	.to("file:target/outbox/cd")
                      .otherwise()
                      .to("file:target/outbox/mock");

}

}
