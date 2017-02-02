package com.sample.test;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.PollingConsumer;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.camel.poc.CommandExecutorImpl;

public class CamelStarter {
	/*public static void main(String[] args) throws Exception {

		CamelContext context = 
				new DefaultCamelContext();

		context.addRoutes(new IntegrationRoute());
//		context.addRoutes(new IntegrationDiscRoute());

		context.start();

		Thread.sleep(120000);

		context.stop();

		}*/
	
	public static void main(String[] args) throws Exception { 
		   ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml"); 
		   CamelContext camelContext = (CamelContext) context.getBean("firstCamelContext");	        
		   System.out.println(camelContext.getEndpoints()); 
		   camelContext.stopRoute("jmsListnerRoute");
//		   camelContext.
		   Endpoint endpoint = camelContext.getEndpoint("activemqCamel:queue:test_destination_input");
		   PollingConsumer consumer = endpoint.createPollingConsumer();
		   Exchange exchange = consumer.receive();
		   System.out.println(exchange);
		   camelContext.start();
		   CommandExecutorImpl impl = context.getBean(CommandExecutorImpl.class);
//		   CommandExecutorImpl impl = new CommandExecutorImpl();
		   impl.execute();
		   Thread.sleep(1200000);
		   camelContext.stop();
		}
}
