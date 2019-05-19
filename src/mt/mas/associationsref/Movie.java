package mt.mas.associationsref;

import java.util.ArrayList;
import java.util.List;

/**
 * A test tmplementation of associations using references.
 */
public class Movie {
	public String title; // public for simplicity
	
	private List<Actor> actors = new ArrayList<>(); // implementation of the association, cardinality: *
	
	/**
	 * The constructor.
	 */
	public Movie(String title) {
		this.title = title;
	}
	
	/**
	 * Adds an actor.
	 * @param newActor
	 */
	public void addActor(Actor newActor) {
		// Check if we have the information already
		if(!actors.contains(newActor)) {
			actors.add(newActor);
			
			// Add the reverse connection
			newActor.addMovie(this);
		}
	}

	@Override
	public String toString() {
		var info = "Movie: " + title + "\n";
		
		// Add info about titles of his/her movies
		for(Actor a : actors) {
			info += "   " + a.name + "\n";
		}
		
		return info;		
	}	
}
