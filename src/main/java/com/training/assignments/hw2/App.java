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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List; 


/**
 * Java 8 lambdas (done), 
 * stream functions {
 * 		filter (done)
 * 		map (done)
 * 		findFirst (done)
 * 		count (done)
 * }
 * Date/Time (done)
 * current time in different time zones (done)
 * Arithmetic: + 8 hrs to current date time (done)
 */

public class App 
{	
    public static void main( String[] args ) throws IOException
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
    	
    	String country = "America";
    	String city = "Chicago";
    	String response = "";
    	Integer idNumber = 0;
    	int offset = 8;
    	Boolean validZone = false;
    	Boolean validInput = false;
    	BufferedReader userInput;
    	StringBuilder timeZoneId;
    	String timeZone = "America/Chicago";
    	List<TimeStampWithZone> timeStamps = new ArrayList<TimeStampWithZone>();
    	
    	
    	while (!validZone) {
    		try {
    			validInput = false;
    			
    			userInput = new BufferedReader( new InputStreamReader(System.in));
    		 	System.out.println("\nPlease input the name of the Country (EX: America ):");
    		 	country = userInput.readLine();
    	    
    			userInput = new BufferedReader( new InputStreamReader(System.in));
     		 	System.out.println("\nPlease input the name of the City (EX: Chicago ):");
     		 	city = userInput.readLine();
     		 	
	    		timeZoneId = new StringBuilder().append(country).append('/').append(city);
	    		timeZone = timeZoneId.toString();
	    		timeStamps.add(
	    				new TimeStampWithZone(formatter.format(getZonedTime(timeZone)), timeZoneId.toString(), idNumber)
	    				);
	    		
	    		validZone = true;
	    	}
	    	catch(ZoneRulesException e){
	    		System.out.println("\nEither the Country or City names are invalid options.");
	    		validZone = false;
	    	}
    		
    		if (validZone) { idNumber++; }
    		
    		while (!validInput) {
	    		userInput = new BufferedReader( new InputStreamReader(System.in));
	    		System.out.println("\nEnter another TimeZone? (Y/N):");
	    		response = userInput.readLine();
    		
	    		if (response.equals("Y") || response.equals("y")) { validZone = false; validInput = true; }
	    		else if (response.equals("N") || response.equals("n")) { validZone = true; validInput = true; }
    		}
    		
    		
    		
    	}
    	System.out.println(
    	Stream.of(timeStamps.toArray())
    	.findFirst()
        .toString()
        );
    	
    	List<String> allTimeZones = timeStamps.stream()
                .map( e -> e.getTimeZone() )
                .distinct()
                .collect(Collectors.toList());
    	
    	System.out.println(allTimeZones + " There are " + timeStamps.stream().count() + " timezones entered.");
    	
    	List<Integer> evenNumbers = timeStamps.stream()
                .filter(n -> n.getIdNumber() % 2 == 0)
                .map(n -> n.getIdNumber())
                .collect(Collectors.toList());
    	
    	System.out.println(evenNumbers + " all the even numbered ids from the list of time stamps");
    	

    	
    	System.out.println(formatter.format(getZonedTime(timeZone)));
    	
    	System.out.println(formatter.format(getZonedTime(timeZone).plusHours(offset)));
    	
    	
    	
    	
    }
    
	private static LocalDateTime getZonedTime(String zoneId) {
		
    	ZonedDateTime dateAndTimeZoned = ZonedDateTime.now(ZoneId.of(zoneId));
    	
    	return dateAndTimeZoned.toLocalDateTime();
		
		
	}
}
