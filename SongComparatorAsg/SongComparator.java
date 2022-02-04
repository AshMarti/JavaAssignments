package ece325_lab_assignment5;

import java.util.*;

public class SongComparator implements Comparator<Song>{
	// override comparator: if s1 is more popular, list it first 
    public int compare(Song s1, Song s2)
    {
        return s2.getPopularity()-s1.getPopularity();
    }
}
