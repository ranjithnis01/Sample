package com.sample.camel.poc;

import javax.jms.DeliveryMode;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.Session;

public class MyReplyMessageListener implements MessageListener{
	MyReplyMessageListener(){
		super();
	}
	@Override
	public void onMessage(Message message) {
		System.out.println("inside reply listener"+message);
	}
}
