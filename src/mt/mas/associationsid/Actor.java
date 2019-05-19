package mt.mas.associationsid;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	private int id;
	public String name;	// public for simplicity
	
	public int[] movieIds;
	
	private static List<Actor> extent = new ArrayList<>();
	
	/*
	 * The constructor.
	 */
	public Actor(int id, String name, int[] movieIds) {
		// Add to the extent
		extent.add(this);
		
		this.id = id;
		this.name = name;
		this.movieIds = movieIds;
	}
	
	/**
	 * Finds an actor with the given id.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Actor findActor(int id) throws Exception {
		for(Actor actor : extent) {
			if(actor.id == id) {
				return actor;
			}
		}
		
		throw new Exception("Unable to find an actor with the id = " + id);
	}
}
