package com.sample.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SampleTest {
	
	public static void main(String...strings){
		
		Pattern p = Pattern.compile("(\\d+(\\.*\\d*))|([a-zA-Z]+)");
		Matcher m = p.matcher("2.5m");
		List<String> tokens = new ArrayList<String>();
		while(m.find())
		{
		  System.out.println("grou 1::"+m.group(1));
		  String token = m.group( 0 ); //group 0 is always the entire match   
		  tokens.add(token);
		  System.out.println("token::"+token);
		}
		System.out.println(tokens);
		
		//check it see if you have got both the tokens
		System.out.println(tokens.size());
		if(tokens.size() >1){
			System.out.println("converted number"+convertTo(tokens.get(0), tokens.get(1), "s"));
		}
	}
	
	public static TimeUnit getTimeUnit(String unit){
		switch(unit){
		case "ns":
			return TimeUnit.NANOSECONDS;
		case "ms":
			return TimeUnit.MILLISECONDS;
		case "mis":
			return TimeUnit.MICROSECONDS;
		case "s":
			return TimeUnit.SECONDS;
		case "m":
			return TimeUnit.MINUTES;
		case "h":
			return TimeUnit.HOURS;
		case "d":
			return TimeUnit.DAYS;
			
		}
		return null;
	}
	
	public static long convertTo(String strNumber,String fromUnit,String toUnit){
		
		long number = Long.parseLong(strNumber);
		TimeUnit toTimeUnit = getTimeUnit(toUnit);
		if(toTimeUnit != null){
			switch(fromUnit){
				case "ns":
					return getTimeUnit(toUnit).convert(number, TimeUnit.NANOSECONDS);
				case "ms":
					return getTimeUnit(toUnit).convert(number, TimeUnit.MILLISECONDS);
				case "mis":
					return getTimeUnit(toUnit).convert(number, TimeUnit.MICROSECONDS);
				case "s":
					return getTimeUnit(toUnit).convert(number, TimeUnit.SECONDS);
				case "m":
					return getTimeUnit(toUnit).convert(number, TimeUnit.MINUTES);
				case "h":
					return getTimeUnit(toUnit).convert(number, TimeUnit.HOURS);
				case "d":
					return getTimeUnit(toUnit).convert(number, TimeUnit.DAYS);
			}
		}
		return number;
	}
	
}
