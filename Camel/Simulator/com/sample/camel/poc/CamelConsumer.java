package com.sample.camel.poc;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Converter;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CamelConsumer implements Processor{

	/*@Converter public Processor toProcessor(final MessageListener listener){
		  return new Processor(){
		    public void process(Exchange exchange) throws Exception {
				MyMessageListener	listener = new MyMessageListener();
				Message message=toMessage(exchange);
				listener.onMessage(message);
		    }
		    @Override public String toString(){
		    	return "Processor of MessageListener: " + listener;
		    }
		  }
		;
		}*/

	@Converter
	public void process(Exchange exchange) throws Exception {
//		Processor proc = toProcessor(new MyMessageListener());
//		proc.process(exchange);
		System.out.println("inside the camelConsumer processor");
		System.out.println(exchange);
		System.out.println(exchange.getIn().getHeader("JMSCorrelationId"));
		System.out.println(exchange.getProperty("deliveryUUID"));
		
		for(String header : exchange.getIn().getHeaders().keySet()){
			System.out.println("header:"+header+" value:"+exchange.getIn().getHeader(header));
		}
		
		for(String prop : exchange.getProperties().keySet()){
			System.out.println("Property:"+prop+"value:"+exchange.getProperty(prop));
		}
		
		try{
			// Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

//            connection.setExceptionListener(this);

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        MessageProducer producer = session.createProducer((Destination) exchange.getIn().getHeader("JMSReplyTo"));
	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	        
	     // Create a messages
	        TextMessage sendMessage = session.createTextMessage();
	        sendMessage.setJMSCorrelationID((String) exchange.getProperty("deliveryUUID"));

	        // Tell the producer to send the message
	        System.out.println("Sent message: "+ sendMessage.hashCode() + " : " + Thread.currentThread().getName()+"correlationId"+sendMessage.getJMSCorrelationID());
	        producer.send(sendMessage);
			}catch(Exception ex){
				System.out.println(ex);
				ex.printStackTrace();
			}		
	}
}
