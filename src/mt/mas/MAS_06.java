package mt.mas;

import mt.mas.associationsobjectplus.Movie;
import mt.mas.compositionref.Part;
import mt.mas.compositioninner.*;
// import mt.mas.associationsref.*;
//import mt.mas.compositionref.*;
import mt.mas.associationsobjectplus.*;

/**
 * @author Mariusz Trzaska
 * Fill free to send me any remarks: mtrzaska@pjwstk.edu.pl
 */
public class MAS_06 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			// testIdAssociations();
//			testRefAssociations();
//			testQualifiedAssociations();
//			testCompositionRef();
//			testCompositionInnerCl();
			testAssociationsObjectPlus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A test for associations implemented using identifiers (not recommended)
	 * @throws Exception 
	 *
	 */
	 public static void testIdAssociations() throws Exception {
	 	var movie1 = new mt.mas.associationsid.Movie(1, "T1", new int[]{3, 4});  // The 'var' requires Java 10+
		var movie2 = new mt.mas.associationsid.Movie(2, "T3", new int[]{3});

		var actor1 = new mt.mas.associationsid.Actor(3, "AS", new int[]{1, 2});
		var actor2 = new mt.mas.associationsid.Actor(4, "MB", new int[]{1});
		var actor3 = new mt.mas.associationsid.Actor(5, "KL", new int[]{2});
		
		// Show information about the movie1
		System.out.println(movie1.title);
		for(int i = 0; i < movie1.actorIds.length; i++) {
			System.out.println("   " + mt.mas.associationsid.Actor.findActor(movie1.actorIds[i]).name);
		}

		 // Show information about the actor1
		System.out.println(actor1.name);
		for(int i = 0; i < actor1.movieIds.length; i++) {
			System.out.println("   " + mt.mas.associationsid.Movie.findMovie(actor1.movieIds[i]).title);
		}
	}
	
	/**
	 * A test for associations implemented using references (recommended)
	 * @throws Exception 
	 *
	 */
	public static void testRefAssociations() throws Exception {
		// Create new business objects (without connections)
		var movie1 = new mt.mas.associationsref.Movie("T1");
		var movie2 = new mt.mas.associationsref.Movie("T3");

		var actor1 = new mt.mas.associationsref.Actor("AS");
		var actor2 = new mt.mas.associationsref.Actor("MB");
		var actor3 = new mt.mas.associationsref.Actor("KL");
		
		// Add info about connections
		movie1.addActor(actor1);
		movie1.addActor(actor2);
		movie2.addActor(actor1);
		movie2.addActor(actor3);
		
		actor1.addMovieQualif(movie1);
		
		// Show info about movies
		System.out.println(movie1);
		System.out.println(movie2);

		// Show info about actors
		System.out.println(actor1);
		System.out.println(actor2);
		System.out.println(actor3);
	}	

	/**
	 * A test for a qualified association.
	 * @throws Exception 
	 *
	 */
	public static void testQualifiedAssociations() throws Exception {
		// Create new business objects (without connections)
		var movie1 = new mt.mas.associationsref.Movie("T1");
		var movie2 = new mt.mas.associationsref.Movie("T3");

		var actor1 = new mt.mas.associationsref.Actor("AS");
		var actor2 = new mt.mas.associationsref.Actor("MB");
		var actor3 = new mt.mas.associationsref.Actor("KL");

		// Add info about connections
		actor1.addMovieQualif(movie1);
		actor1.addMovieQualif(movie2);
		actor2.addMovieQualif(movie1);
		actor3.addMovieQualif(movie2);

		// Show info about actors
		System.out.println(actor1);
		System.out.println(actor2);
		System.out.println(actor3);
		
		// Get the info about the "T1" movie for the actor1
		var f = actor1.findMovieQualif("T1");
		System.out.println(f);			
	}

	/**
	 * A test for a composition implemented using references.
	 * @throws Exception 
	 *
	 */
	public static void testCompositionRef() throws Exception {
		// Create a new whole
		var whole1 = new mt.mas.compositionref.Whole("Whole 1");
		var whole2 = new mt.mas.compositionref.Whole("Whole 2");

		Part.createPart(whole1, "Part 01");
		var part2 = Part.createPart(whole1, "Part 02");

		// whole2.addPart(part2); // causes an exception because of a requirement about not sharing parts
		
		System.out.println(whole1);
	}

	/**
	 * A test for a composition implemented using inner classes.
	 *
	 */
	public static void testCompositionInnerCl() throws Exception {
		// Create a new whole
		Whole whole = new Whole("Whole 01");
		
		whole.createPart("Part 01");
		whole.createPart("Part 02");
		
		// A wrong result: creating a new part inside of the already existing whole, but without a connection between the whole and the part
		Whole.Part part = whole.new Part("Part 02");
		
		System.out.println(whole);
		System.out.println(part);
	}

	/**
	 * A test for associations implemented using the ObjectPlusPlus.
	 * @throws Exception 
	 *
	 */
	public static void testAssociationsObjectPlus() throws Exception {
		// Create new objects (no links)
		Actor a1 = new Actor("Arnold Schwarzenegger");
		Actor a2 = new Actor("Michael Biehn");
		Actor a3 = new Actor("Kristanna Loken");
		
		Movie f1 = new Movie("Terminator 1");
		Movie f3 = new Movie("Terminator 3");
		
		Group g1 = new Group(1);
		Group g2 = new Group(2);
		
		// Add info about links
		f1.addLink("actor", "movie", a1);
		// f1.addLink("actor", "movie", a2);
		f1.addLink("actor", "movie", a2, "MB");	// use the qualified association
		f3.addLink("actor", "movie", a1);
		f3.addLink("actor", "movie", a3);
		
		g1.addPart("part", "whole", a1);
		g1.addPart("part", "whole", a2);
		g2.addPart("part", "whole", a3);
		// g2.addPart("part", "whole", a1); // an exception because the part already belongs to another whole (group)


		// Show infos
		f1.showLinks("actor", System.out);
		f3.showLinks("actor", System.out);

		a1.showLinks("movie", System.out);

		g1.showLinks("part", System.out);
		
		// Test the qualified association
		System.out.println(f1.getLinkedObject("actor", "MB"));
	}				
}
