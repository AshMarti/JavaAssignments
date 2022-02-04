package ece325_lab_assignment4;

import java.time.LocalDate;

/**
 * Finish the implementation of this class. No need to add any instance variables or methods.
 *
 */
public class ZooAnimal {
	/**
	 * The last date on which this animal was fed.
	 */
	private LocalDate lastFeed;
	
	/**
	 * The name of the animal.
	 */
	private String name;
	
	public ZooAnimal(String name) {
		this.name = name;
	}
	
	public LocalDate getLastFeed() {
		return lastFeed;
	}
	
	
	/**
	 * Returns true iff the animal was fed already today.
	 * @return true if the animal was fed today
	 */
	public boolean isFedAlready() {
		// find today's date and return true if lastFeed is also today's date
		LocalDate today = LocalDate.now();
		if (this.lastFeed == null) {
			return false;
		} else if (today.compareTo(this.lastFeed) == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void feed() {
		// change the date of lastFeed to today's date
		this.lastFeed = LocalDate.now();
	}
	
	public String getName() {
		return name;
	}
}
