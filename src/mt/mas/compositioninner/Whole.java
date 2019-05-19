package mt.mas.compositioninner;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the composition using an inner class.
 * @author Mariusz
 *
 */
public class Whole {
	private String wholeName;
	
	private List<Part> parts = new ArrayList<>();
	
	/**
	 * The constructor of the outer class (the whole).
	 * @param wholeName
	 */
	public Whole(String wholeName) {
		this.wholeName = wholeName;
	}
	
	/**
	 * Creates a new part and adds it to the list of parts.
	 * @param partName
	 * @return
	 */
	public Part createPart(String partName) {
		Part part = new Part(partName);
		parts.add(part);
		
		return part;
	}

	@Override
	public String toString() {
		return wholeName;
	}

	/**
	 * The inner class (the part).
	 * @author Mariusz
	 *
	 */
	public class Part {
		private String partName;
		// Because of Java inner class properties, we do not need a reference pointing at the whole.
		
		/**
		 * Inner class constructor.
		 * @param partName
		 */
		public Part(String partName) {
			this.partName = partName;
		}

		@Override
		public String toString() {
			return "Part: " + partName;
		}
	}
}
