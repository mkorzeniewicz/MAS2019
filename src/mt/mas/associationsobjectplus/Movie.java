package mt.mas.associationsobjectplus;

import mt.mas.ObjectPlusPlus;

/**
 * A test implementation of associations using ObjectPlusPlus.
 */
public class Movie extends ObjectPlusPlus {
	private String title;
	
	/**
	 * The constructor
	 *
	 */
	public Movie(String title) {
		super();	// call the super constructor
		this.title = title;
	}

	@Override
	public String toString() {
		return "Movie: " + title;
	}		
}
