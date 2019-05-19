package mt.mas.associationsref;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A test tmplementation of associations using references.
 */
public class Actor {
	public String name;	// public for simplicity
	
	// For standard associations
	private List<Movie> movies = new ArrayList<>(); // implementation of the association, cardinality *
	
	// For qualified associations
	private Map<String, Movie> moviesQualif = new TreeMap<>();
	
//	private ArrayList<Actor> parents = new ArrayList<Actor>();
//	private ArrayList<Actor> children = new ArrayList<Actor>();
	
	/*
	 * The constructor.
	 */
	public Actor(String name) {
		this.name = name;
	}
	
	/**
	 * Adds an information about a movie.
	 * @param newMovie
	 */
	public void addMovie(Movie newMovie) {
		// Check if we already have the info
		if(!movies.contains(newMovie)) {
			movies.add(newMovie);
			
			// Add the reverse connection
			newMovie.addActor(this);
		}
	}

	/**
	 * DAdds an information about a movie (qualified association).
	 * @param newMovie
	 */
	public void addMovieQualif(Movie newMovie) {
		// Check if we already have the info
		if(!moviesQualif.containsKey(newMovie.title)) {
			moviesQualif.put(newMovie.title, newMovie);

			// Add the reverse connection
			newMovie.addActor(this);
		}
	}
	
	/**
	 * Finds a movie information based on the given title.*
	 */
	public Movie findMovieQualif(String title) throws Exception {
		// Check if we have the info
		if(!moviesQualif.containsKey(title)) {
			throw new Exception("Unable to find a movie: " + title);
		}
		
		return moviesQualif.get(title);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		var info = "Actor: " + name + "\n";
		
		// Add info about his/her movies
		for(Movie f : movies) {
			info += "   " + f.title + "\n";
		}
		
		return info;		
	}
}
