package com.sample.camel.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


public class CommandResponseManager implements Processor {

    @Override
    public void process(Exchange exchange) {
        Object body = exchange.getIn().getBody();
        System.out.println(body);
    }
}
