package ece325_assignment2;

public class Song {
	// the name of the song (can be alter
	private String title;
	
	// change/add the name of the song
	public void nameSong(String name) {
		title = name;
	}
	
	// get the name of the song
	public String getTitle() {
		return title;
	}
}