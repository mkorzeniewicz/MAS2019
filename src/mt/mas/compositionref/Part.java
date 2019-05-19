package mt.mas.compositionref;

/**
 * @author Mariusz
 *
 */
public class Part {
	public String name;	// public for simplicity
	private Whole whole;
	
	/**
	 * Private constructor
	 * @param name
	 */
	private Part(Whole whole, String name) {
		this.name = name;
		this.whole = whole;
	}
	
	/**
	 * Creates a new part and connects it with the given whole.
	 * @param whole
	 * @param name
	 * @return
	 * @throws Exception when the whole does not exist (== null).
	 */
	public static Part createPart(Whole whole, String name) throws Exception {
		if(whole == null) {
			throw new Exception("The given whole does not exist!");
		}

		// Create a new part
		Part part = new Part(whole, name);
		
		// Add to the whole
		whole.addPart(part);
		
		return part;
	}
}
