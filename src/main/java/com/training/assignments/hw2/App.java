package com.training.assignments.hw2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRulesException;

/**
 * Hello world!
 *
 */
public class App 
{	
    public static void main( String[] args ) throws IOException
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
    	
    	String country = "America";
    	String city = "Chicago";
    	int offset = 8;
    	Boolean validZone = false;
    	BufferedReader userInput;
    	StringBuilder timeZoneID;
    	String timeZone = "America/Chicago";
    	
    	while (!validZone) {
    		try {
    			userInput = new BufferedReader( new InputStreamReader(System.in));
    		 	System.out.println("\nPlease input the name of the Country (EX: America ):");
    		 	country = userInput.readLine();
    	    
    			userInput = new BufferedReader( new InputStreamReader(System.in));
     		 	System.out.println("\nPlease input the name of the City (EX: Chicago ):");
     		 	city = userInput.readLine();
     		 	
	    		timeZoneID = new StringBuilder().append(country).append('/').append(city);
	    		timeZone = timeZoneID.toString();
	    		formatter.format(getZonedTime(timeZone));
	    		validZone = true;
	    	}
	    	catch(ZoneRulesException e){
	    		System.out.println("\nEither the Country or City names are not valid options.");
	    		validZone = false;
	    	}
    		
    	}
    	
    	
    	System.out.println(formatter.format(getZonedTime(timeZone)));
    	
    	System.out.println(formatter.format(getZonedTime(timeZone).plusHours(offset)));
    	
    	
    }
    
	private static LocalDateTime getZonedTime(String zoneId) {
		
    	ZonedDateTime dateAndTimeZoned = ZonedDateTime.now(ZoneId.of(zoneId));
    	
    	return dateAndTimeZoned.toLocalDateTime();
		
		
	}
}
