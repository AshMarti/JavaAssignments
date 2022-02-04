package ece325_lab_assignment4;

/**
 * The artist/band that is performing. You must finish this class.
 * @author corpaul
 *
 */
public class Artist implements ZooPerformer {
	/** 
	 * Indicates whether the artist is currently playing (= performing). 
	 */
	private boolean isPlaying;
	
	public Artist() {
		isPlaying = false;
	}
	
	/** 
	 * Feed the animal. Make sure to check whether we are allowed to feed this animal,
	 * and make sure to handle things correctly if we are not allowed to feed it. You are allowed
	 * to change this method's signature, if necessary.
	 * 
	 */
	public void feed(ZooAnimal animal) throws NotPlayingException, AlreadyFedException {
		// if animal is not fed and artist is playing...
		if (!(animal.isFedAlready()) && this.isPlaying) {
			animal.feed();
			System.out.println("Feeding successful!");
		// if artist is not playing...
		} else if (!(this.isPlaying)) {
			throw new NotPlayingException("Artist is not playing. Indigestion imminent if feeding proceeds!");
		// if animal has already been fed...
		} else if (animal.isFedAlready()) {
			throw new AlreadyFedException("This animal is greedy! Do not overfeed.");
		}
	}

	/**
	 * Sometimes, artists get distracted, so there is a 50% chance that they start
	 * playing when you call this method. 
	 * 
	 */
	public void startPlaying() {
		// if we are already playing, don't risk getting distracted again
		if (!isPlaying) {
			// 50% chance to start playing
			double distraction = Math.random();
			if (distraction < 0.5) {
				isPlaying = true;
				System.out.println("\nArtist starts playing...\n");
			}
		}
	}
	
	public void stopPlaying() {		
		isPlaying = false;
	}
	
}
