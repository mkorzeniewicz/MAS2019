package mt.mas.associationsobjectplus;

import mt.mas.ObjectPlusPlus;

/**
 * A test implementation of associations using ObjectPlusPlus.
 */
public class Actor extends ObjectPlusPlus {
	private String name;
	
	/**
	 * The constructor.
	 */
	public Actor(String name) {
		super();	// call the super constructor
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Actor: " + name;
	}	
}
