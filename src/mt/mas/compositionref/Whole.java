package mt.mas.compositionref;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Mariusz
 *
 */
public class Whole {
	private List<Part> parts = new ArrayList<>();
	
	private static Set<Part> allParts = new HashSet<>();
	
	private String name;
	
	public Whole(String name) {
		this.name = name;
	}
	
	/**
	 * Adds the given part to this whole.
	 * @param part
	 * @throws Exception 
	 */
	public void addPart(Part part) throws Exception {
		if(!parts.contains(part)) {
			// Check if the part has been already added to any wholes
			if(allParts.contains(part)) {
				throw new Exception("The part is already connected with a whole!");
			}
			
			parts.add(part);
			
			// Store on the list of all parts
			allParts.add(part);
		}
	}

	@Override
	public String toString() {
		String info = "Whole: " + name + "\n";
		for(Part part : parts) {
			info += "   " + part.name + "\n";
		}
		
		return info;
	}
}
