import java.io.BufferedReader;
import java.lang.Math;
import java.util.Scanner;
import java.io.FileReader;

public class BandNameGenerator {
	String[] adjectives;
	String[] nouns;

	boolean adjectivesLoaded = false;
	boolean nounsLoaded = false;

	String adjectivesFile;
	String nounsFile;

	// loads the arrays for adjectives and nouns from text files, checks if
	// arrays were loaded correctly, and generates a band name
	public BandNameGenerator(String adjectivesFile, String nounsFile) {
		// loads adjectives into array from adjectives.txt
		adjectives = loadTxt(adjectivesFile);
		// loads nouns into array from nouns.txt
		nouns = loadTxt(nounsFile);
	
		// checks if adjectives[] and nouns[] are loaded correctly
		loadAdjectives();
		loadNouns();
		
		// uses generate() to create random band name and prints to console
		String bandName = generate();
		System.out.println(bandName);
	}

	// checks if adjectives[] has been loaded correctly and updates 
	// adjectivesLoaded to true if it is
	public void loadAdjectives() {
		if (adjectives != null) {
			adjectivesLoaded = true;
		}
	}

	// checks if nouns[] has been loaded correctly and updates 
	// nounsLoaded to true if it is
	public void loadNouns() {
		if (nouns != null) {
			nounsLoaded = true;
		}
	}

	/**
	 * Randomly generates and returns a band name that consists of an adjective followed by a noun.
	 * Returns "UNINITIALIZED" if the adjectives or nouns were not (correctly) loaded. 
	 * @return The generated band name
	 */
	public String generate() {
		// bandName is the final random band name
		String bandName;
		// if both arrays were loaded correctly:
		if (adjectivesLoaded && nounsLoaded ) {
			// take random 0 <= x <= 1 and multiply by length of adjectives[] to get
			// random adjective (where x*length is the array index)
			int maxAdjectives = adjectives.length;
			String bandAdjective = adjectives[Math.abs((int)(Math.random()*maxAdjectives) - 1)];
		
			// take random 0 <= x <= 1 and multiply by length of nouns[] to get
			// random noun (where x*length is the array index)
			int maxNouns = nouns.length;
			String bandNoun = nouns[Math.abs((int)(Math.random()*maxNouns) - 1)];
			
		
			// add adjective and noun strings to create name
			bandName = bandAdjective + " " + bandNoun;
			
		// if the arrays were not correctly loaded:
		} else {
			bandName = "UNINITIALIZED";
		}

		return bandName;
	}
	
	/**
	 * We have not discussed I/O (reading/writing files) yet, so you can use this
	 * function to load the adjectives and nouns text files.
	 * 
	 * @param file: a String that contains the name of the file you want to read. 
	 * @return
	 */
	private String[] loadTxt(String file) {
		// Initialize the data we will return to a real array so our compiler won't complain.
		// Don't worry - later in the course we will look at better ways to do this. 
		String[] data = new String[0];
		
		// We did not talk about exceptions yet but for now read the following part as follows:
		// If an error occurs during the execution of the code in the try block, the program will 
		// execute the code in the catch block, otherwise it will skip the catch block. 
		try {
			// Create a stream to read from the file
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			int i = 0;
			// The first line of the file contains an integer that represents the number of rows,
			// the rest of the file contains one word on every line
			int totalLines = Integer.parseInt(in.readLine());
			data = new String[totalLines];
			// Read the file and store it in the data that we will return
			while ((line = in.readLine()) != null) {
				data[i] = line;
				i++;

			}
			// Only execute the following block if a problem occurred during reading the file
		} catch (Exception e) {
			// Print some details that should help you solve the problem.
			System.err.println("Problem while reading the data for file: " + file);
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Run the program and randomly generate 20 (no more, no less) band names every time you execute it.
	 * The names may be different across runs. 
	 * @param args
	 */
	public static void main(String[] args) {
		// finds 20 band names using the provided text files
		for (int i = 0; i < 20; i++) {
			String nounsFile = "BandNameGenerator/nouns.txt";
			String adjectivesFile = "BandNameGenerator/adjectives.txt";
			new BandNameGenerator(adjectivesFile, nounsFile);
		}

	}
	
}
