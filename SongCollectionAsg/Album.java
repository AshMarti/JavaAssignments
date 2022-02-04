package ece325_assignment2;

import java.util.ArrayList;

public class Album {
	private ArrayList<Song> album;
	
	// create album
	public Album(String[] songs) {
		album = new ArrayList<Song>();
		
		// for every song in the list of song names...
		for (String song : songs) {
			// if album does not contain song with same name, add song to album
			Song s = new Song();
			s.nameSong(song);
			if (!containsSongName(s)) {
				addSongToAlbum(s);
			}
		}
	}
	
	// public method than can be accessed to ask if a song name is already in the album
	public boolean containsSongName(Song s) {
		return equals(s);
	}
	
	// private method that compares the title of s to the names of all songs in the list
	private boolean equals(Song s) {
		boolean equals = false;
		for (Song track : album) {
			if ((track.getTitle()).equals(s.getTitle())) {
				equals = true;
				break;
			}
		}
		return equals;
	}
	
	// add a song to the album
	public void addSongToAlbum(Song s) {
		album.add(s);
	}
	
	// get the size of the album
	public int getNumberOfSongs() {
		return album.size();	}
	
	// get whether the album contains a specific song object or not
	protected boolean contains(Song s) {
		return album.contains(s);
	}
	
	// create string of all track names and their corresponding numbers
	public String toString() {
		String str = "[Album: \n";
		int index = 1;
		for(Song s : album) {
			str += "\t Track #" + Integer.toString(index) + " " + s.getTitle() + "\n";
			index++;
		}
		str += "]";
		return str;
	}
	
}
