package com.sample.camel.poc;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericErrorHandler implements Processor {

    @Override
    public void process(Exchange exchange) {
        Throwable cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
        if (cause != null) {
            String errorMessage = cause.getLocalizedMessage();
           System.out.println(errorMessage);
        }
    }
}
