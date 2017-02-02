package com.sample.test.inter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatternValidator {
//public static final String validatorIdentifierName="^[^\\x00-\\x1f\\s_%]*[^\\x00-\\x08\\x0a-\\x1f_%\\x7f]+[^\\x00-\\x1f\\s_%]*$";
public static final String validatorIdentifierName="^([^\\x00-\\x1f\\s%][^\\x00-\\x08\\x0a-\\x1f%\\x7f]*[^\\x00-\\x1f\\s%])|([^\\x00-\\x1f\\s%])$";
private static final Logger LOG = LoggerFactory.getLogger(PatternValidator.class);
	public static void main(String[] args) throws InterruptedException {
		String str = "a*";
		PatternValidator validator = new PatternValidator();
		LOG.info("test message {}", validator);
		System.out.println(str.matches(validatorIdentifierName));
		
		System.out.println(System.currentTimeMillis());
		Thread.sleep(5000);
		System.out.println(System.currentTimeMillis());
	}

}
