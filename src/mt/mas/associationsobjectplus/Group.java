package mt.mas.associationsobjectplus;

import mt.mas.ObjectPlusPlus;

/**
 * A test implementation of associations using ObjectPlusPlus.
 */
public class Group extends ObjectPlusPlus {
	private int number;
	
	/**
	 * Constructor.
	 *
	 */
	public Group(int number) {
		super();	// call the super constructor
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "Group: " + number;
	}			
}
