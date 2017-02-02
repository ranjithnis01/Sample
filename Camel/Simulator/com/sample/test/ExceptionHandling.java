package com.sample.test;

public class ExceptionHandling {
public static void main(String[] args) {
	try{
		
		
		throw new NullPointerException("nullpointer");
	}catch(NullPointerException mc){
		throw new NullPointerException(mc.getMessage());
	}
	catch(Exception ex){
		System.out.println("high level exception"+ex); 
	}
}
}
