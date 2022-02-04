package ece325_assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CollectionManager {
	
	// load the songs from "songs.txt" into a String array for use in
	// SongCollection and Album
	public static String[] LoadSongs() throws IOException {
		BufferedReader in = null;
		
		// array of song names
		String[] songs;
		try {
			in = new BufferedReader(new FileReader("songs.txt"));

			// find number of total song names and create that size of array
			songs = new String[Integer.parseInt(in.readLine())];
			
			// read each line and put the string (song name) into songs[]
			String line;
			int i = 0;
			while ((line = in.readLine()) != null) {
				songs[i] = line;
				i++;
			}
		} finally {
			// close the reader
			if (in != null) { in.close(); }
			}
		return songs;
	}

	public static void main(String[] args) throws IOException {
		// create new SongCollection object
		SongCollection songCollection = new SongCollection();
		
		// Load the songs from "songs.txt" into the string array
		String[] songs = LoadSongs();
		
		// create a new Song object for each song name and add it to the collection
		for (int i = 0; i < songs.length; i++) {
			Song song = new Song();
			song.nameSong(songs[i]);
			songCollection.addSongToCollection(song);
		}
		
		// print the names of all the songs in songCollection
		System.out.println(songCollection.toString());
		System.out.println("\n");
		
		// create album and print the names of all the tracks in the album
		Album album = new Album(songs);
		String output = album.toString();
		System.out.println(output);
		
	}
}
