package com.sample.camel.poc;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class CommandExecutorImpl implements MessageListener{
	@Autowired
    private ProducerTemplate producer;
//    private CommandResponseManager commandResponseManager;

    public void execute(){
        try {
        	
            Exchange inputExchange = producer.getDefaultEndpoint().createExchange(ExchangePattern.InOut);
            inputExchange.getIn().setBody("I am satish");
          Map<String, Object> headers = new HashMap<String, Object>();

          headers.put("JMSReplyTo", "TEST_REPLY");
          headers.put("JMSCorrelationID", "CorrelationID-1234");
          inputExchange.getIn().setHeaders(headers);
//            inputExchange.getIn().setHeader("JMSReplyTo", "");
            System.out.println("COMMANDEXECUTORIMPL"+inputExchange.getIn());
            producer.send(inputExchange);
            

//            return null;
        } catch (Exception e) {
        	e.printStackTrace();
//            throw new CommandExecutionException(e.getMessage(), e);
        }
    }
    public ProducerTemplate getProducer() {
        return producer;
    }

    public void setProducer(ProducerTemplate producer) {
        this.producer = producer;
    }
	@Override
	public void onMessage(Message msg) {
		System.out.println(msg.toString());
//		System.out.println();
		
	}

    /*public CommandResponseManager getCommandResponseManager() {
        return commandResponseManager;
    }

    public void setCommandResponseManager(CommandResponseManager commandResponseManager) {
        this.commandResponseManager = commandResponseManager;
    }*/
}
