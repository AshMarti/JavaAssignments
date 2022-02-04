package ece325_assignment1;

import java.util.*;
import java.lang.Math;

public class DaysUntilRelease {
	
	/**
	 * 	Calculate the number of days until releaseDate.
	 * @param releaseDate in the format yyyy-mm-dd (e.g., 2021-09-09)
	 * @return
	 */
	int calculateDaysUntilRelease(String releaseDate){
		// numOfDays is the value of days between today and the release date
		int numOfDays;
		
		// split the releaseDate string into [year, month, day]
		String[] date = releaseDate.split("-");
		
		// create new Calendar for release date, clear it, and set values to 
		// those in date[]. The value for month needs to decrease by 1 as January is
		// month 0 and not month 1, etc.
        Calendar release = Calendar.getInstance();
        release.clear();
        release.set(Integer.valueOf(date[0]), 
        		Integer.valueOf(date[1]) - 1, Integer.valueOf(date[2]));
        
        // create new Calendar for today's date
        Calendar today = Calendar.getInstance();
        
        // find milliseconds between today's date and Jan. 1, 1970
        long mSecondsToday = today.getTimeInMillis();
        
        // find milliseconds between release date and Jan. 1, 1970
        long mSecondsRelease = release.getTimeInMillis();
        
        // find difference between two dates in milliseconds
    	long numMSeconds = (mSecondsRelease - mSecondsToday);
    	
    	// divide by number of milliseconds in a day and round up
    	numOfDays = (int) Math.ceil((float) numMSeconds/86400000);
		
		return numOfDays;
	}
	
	public static void main(String[] args) {
		// allow user input of release date into variable releaseDate
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter the release date in the format yyyy-mm-dd: ");  
		String releaseDate = input.nextLine();
		
		// numOfDays will be the number of days between today and the release date
		DaysUntilRelease daysUntilRelease = new DaysUntilRelease();
		int numOfDays = daysUntilRelease.calculateDaysUntilRelease(releaseDate);
		
		// if the release date is today or is in the past
        if (numOfDays <= 0) {
        	System.out.println("Album was already released!");
        	
        // else if the release date is in the future
        } else if (numOfDays == 1){
        	System.out.println("Release will be in " + numOfDays + " day");
        } else {
        	System.out.println("Release will be in " + numOfDays + " days");
        }
	}
}
