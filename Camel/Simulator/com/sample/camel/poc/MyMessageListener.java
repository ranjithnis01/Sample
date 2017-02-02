package com.sample.camel.poc;

import javax.jms.DeliveryMode;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.Session;

public class MyMessageListener implements MessageListener{
	JmsConsumer consumer;
	Session session;
	MyMessageListener(){
		super();
	}
	MyMessageListener(JmsConsumer consumer,Session session){
		super();
		this.consumer = consumer;
		this.session = session;
	}
	@Override
	public void onMessage(Message message) {
		this.consumer.addMsg(message);
		System.out.println(message);
		try{
        MessageProducer producer = session.createProducer(message.getJMSReplyTo());
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        
     // Create a messages
        TextMessage sendMessage = session.createTextMessage();
        sendMessage.setJMSCorrelationID(message.getJMSCorrelationID());
        System.out.println("Time it received message::"+System.currentTimeMillis());
        Thread.sleep(50000);
        // Tell the producer to send the message
        System.out.println("Sent message: "+ sendMessage.hashCode() + " : " + Thread.currentThread().getName()+"correlationId"+sendMessage.getJMSCorrelationID());
        System.out.println("sending message at::"+System.currentTimeMillis());
        producer.send(sendMessage);
		}catch(Exception ex){
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
}
