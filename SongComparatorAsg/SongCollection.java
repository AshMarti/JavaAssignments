package ece325_lab_assignment5;

import java.time.LocalDate;
import java.io.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * This class represents a Song. A Song has a title, release date, and a popularity score.
 * You are not allowed to change the code that is in between the indications, but you are allowed to add
 * code before and after the indicated lines.
 * 
 * @author Cor-Paul Bezemer
 *
 */
public class SongCollection {
	// not allowed to change anything after this until the indicated line
	private TreeSet<Song> collection;
	
	public SongCollection() {
		collection = new TreeSet<Song>();
	}
	
	public static LocalDate parseLocalDate(String str) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return LocalDate.parse(str, formatter);
	}
	
	public void addSong(Song s) {
		collection.add(s);
	}	
	
	public String toString() {
		String str = "[SongCollection: " + collection.size() + " songs: \n";
		for(Song s : collection) {
			str += "\t" + s + "\n";
		}
		return str + "]";
	}
	
	// you are allowed to make changes/add code after this
	// load details and create Song objects by scanning for name, popularity, and releaseDate
	public void loadSongs(String filename) throws Exception {
		BufferedReader in = null;
		Scanner s = null;
		// try to read line from file
		try {
			in = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = in.readLine()) != null) {
				// scan each line and separate
				String name;
				int popularity;
				LocalDate release;
				try {
					s = new Scanner(line);
					s.useDelimiter(",");
					// try to read line. If errors in line, skip line without adding song
					try {
						name = s.next();
						popularity = Integer.valueOf(s.next());
						release = parseLocalDate(s.next());
						Song song = new Song(name, release, popularity);
						addSong(song);
					} catch (Exception e) {
					}
					
				} finally {
					if (s != null) { s.close(); }
				}	
			}
		} finally {
			if (in != null) { in.close(); }
		}
	}
	
	public List<Song> sort(Comparator<Song> comp) {
		// create new TreeSet then copy collection to it with new comparator
		TreeSet<Song> sortedCollection = new TreeSet<Song>(comp);
		for (Song s : collection) {
			sortedCollection.add(s);
		}
		// convert to a List from a TreeSet
		List<Song> sortedList = new ArrayList<Song>(sortedCollection);
		return sortedList;
	}
	
	
	public static void main(String[] args) throws Exception {
		// load and print the natural list of songs here
		SongCollection collection = new SongCollection();
		collection.loadSongs("ece325_lab_assignment5/songs.txt");
		System.out.println(collection.toString());
		
		// sort the songs by popularity
		System.out.println("\nSorting by popularity... (most popular to least popular like in Spotify)\n");
		List<Song> sortedCollection = collection.sort(new SongComparator());
		
		// generate an output format for the sorted list
		String sorted = "[SongCollection: " + sortedCollection.size() + " songs: \n";
		for(Song s : sortedCollection) {
			sorted += "\t" + s + "\n";
		}
		sorted += "]";
		
		// print the sorted list
		System.out.println(sorted);
		
	}
}
