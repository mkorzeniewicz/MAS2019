package mt.mas.associationsid;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Mariusz
 *
 */
public class Movie {
	public int id;
	public String title; // public for simplicity
	
	public int[] actorIds;
	
	// private static ArrayList<Movie> extent = new ArrayList<Movie>();
	private static Map<Integer, Movie> extent = new TreeMap<>();
	
	/**
	 * The constructor.
	 */
	public Movie(int id, String title, int[] actorIds) {
		// Add to the extent
		// extent.add(this);
		extent.put(id, this);
		
		this.id = id;
		this.title = title;
		this.actorIds = actorIds;
	}
	
	/**
	 * Finds a movie with the given id.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public static Movie findMovie(int id) throws Exception {
		/* for(Movie movie : extent) {
			if(movie.id == id) {
				return movie;
			}
		}
		
		throw new Exception("Unable to find a movie with the id = " + id);*/
		
		return extent.get(id);
	}
}
