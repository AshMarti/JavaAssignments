package ece325_lab_assignment5;

import java.time.LocalDate;

/**
 * This class represents a Song. A Song has a title, release date, and a popularity score.
 * You are not allowed to change the code that is in between the indications, but you are allowed to add
 * code before and after the indicated lines.
 * 
 * @author Cor-Paul Bezemer
 *
 */
public class Song implements Comparable<Song>{ // you are allowed to change this line, if necessary
	// not allowed to change anything after this until the indicated line
	private String title;
	private LocalDate releaseDate;
	private int popularity;

	public Song(String title, LocalDate releaseDate, int popularity) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.popularity = popularity;
	}

	public String getTitle() {
		return this.title;
	}

	public LocalDate getReleaseDate() {
		return this.releaseDate;
	}

	public int getPopularity() {
		return this.popularity;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public void setPopularity(int p) {
		if(popularity > 0)
			popularity = p;
	}
	
	public String toString() {
		return "[Song: " + title + ", released on " + releaseDate + ", popularity: " + popularity + "]";
	}
	
	// allowed to change/add after this
	// override compareTo by comparing song titles alphabetically, then release dates chronologically
	public int compareTo(Song s) { 
		// if this song comes before s alphabetically, list first
	    if(title.compareTo(s.getTitle()) > 0){  
	    	return 1;
	    // if this song comes after s alphabetically, list second
	    } else if(title.compareTo(s.getTitle()) < 0){  
	        return -1;  
	     // if the songs have the same name, compare release dates
	    } else {  
	    	// if this song comes after s chronologically, list second
	    	if (releaseDate.isAfter(s.getReleaseDate())) {
	        	return 1;
	        // if this song comes before s chronologically, list first
	        } else if (releaseDate.isBefore(s.getReleaseDate())) {
	        	return -1;
	        // if these songs have the same release date (and name), they are equal
	        } else {
	        	return 0;
	        }
	    }  
	}
}
