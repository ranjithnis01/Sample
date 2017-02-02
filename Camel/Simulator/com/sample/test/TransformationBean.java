package com.sample.test;

import java.util.Date;

public class TransformationBean {
	private int interval;
	
	public int getInterval() {
		System.out.println("interval "+interval);
		return interval;
	}

	public void setInterval(int interval) {
		System.out.println("interval "+interval);
		this.interval = interval;
	}


	public String makeUpperCase(String body) throws InterruptedException {
		String transformedBody = body.toUpperCase();
		
		Thread.sleep(20000L);
		Date date = new Date();
		System.out.println("inside transformation bean"+date);
		return transformedBody;

		}
}
