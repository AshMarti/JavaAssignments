package ece325_lab_assignment4;

import java.util.*;

public class ZooShow {
	
	public static void main(String[] args) {
		// create the artist
		Artist artist = new Artist();
		
		// create the zoo
		Zoo zoo = new Zoo();
		
		// create a "dictionary"/HashMap to log how many times animals ask for food
		HashMap<ZooAnimal, Integer> feedingLog = new HashMap<>();
		
		// while there are animals that still need feeding,
		// randomly select an animal from the zoo
		// feed it
		while (!(zoo.allAnimalsFed())) {
			ZooAnimal nextanimal = zoo.getRandomAnimalToComeToStage();
			artist.startPlaying();
			System.out.println("\n" + nextanimal.getName() + " is asking for food...");
			try {
				artist.feed(nextanimal);
				// add animal to feeding log
				feedingLog.put(nextanimal, 1);
			} catch (NotPlayingException e) {
				e.printStackTrace();
			} catch (AlreadyFedException e) {
				e.printStackTrace();
				// if animal is already in feeding log, increase times asked for food
				if (feedingLog.containsKey(nextanimal)) {
					feedingLog.put(nextanimal, feedingLog.get(nextanimal) + 1);
				// if animal is already fed, but not in feeding log, add to feeding log
				// (checking if already fed that day, but maybe not by the artist)
				} else {
					feedingLog.put(nextanimal, 1);
				}
			}
		}
		
		System.out.println("\nAll animals have now been fed.");
		
		// print total feeding log
		System.out.println("\n\nFEEDING LOG:");
		for (ZooAnimal animal : feedingLog.keySet()) {
			System.out.println("Animal: " + animal.getName() + "\nTimes asked to be Fed: " + feedingLog.get(animal) + "\n");
		}
		
		// stop playing when all animals are fed
		artist.stopPlaying();
		
		System.out.println("\nEnd of show.");
	}
}
