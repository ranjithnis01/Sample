package com.sample.camel.poc;

import org.apache.camel.CamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * main class for responsible for camel contexts
 * @author sbotla
 *
 */
public class CamelMain {
	
	/**
	 * uncomment contexts required based on need
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml"); 
		   
			/**
			 * this is for jms third party test
			 */
			CamelContext camelContext = (CamelContext) context.getBean("camelJmsConsumerContext");	        
			System.out.println(camelContext.getEndpoints()); 
			camelContext.start();
		   
		   
			/**
			* this is for sample language test. 
			*/
			CamelContext camelSampleLanguageTestContext = (CamelContext) context.getBean("sampleLanguageContext");	        
			System.out.println(camelSampleLanguageTestContext.getEndpoints()); 
			camelSampleLanguageTestContext.start();
			Thread.sleep(1200000);
			camelSampleLanguageTestContext.stop();
		}catch(Exception ex){
			System.out.println(ex);
			ex.printStackTrace();
		}
	}
}
