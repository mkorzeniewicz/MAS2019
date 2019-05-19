package s15816.main;

import java.util.Arrays;



/**
 * @author s15816 Michał Korzeniewicz
 *
 *	Mini projekt 2 MAS 2019 Asocjacje
 *
 *	Zwykła
 *	Z atrybutem
 *	Kwalifikowana
 *	Kompozycja
 *
 *	W każdym wypadku: 
 *		liczności 1-* lub *-*
 *		automatyczne tworzenie połączenia zwrotnego
 *		aktualizacja asocjacji
 * 
 */
public class Main {

	public static void main(String[] args) {

		testNormalAssociation();
		testAssociationWithAttrib();
		testQualifiedAssociation();
		testComposition();
		
	}

	private static void testNormalAssociation() {
		testOneToMany();
		testManyToMany();
	}

	private static void testOneToMany() {
		System.out.println("\n\n---------------ONE TO MANY-------------\n");
		
		//creating paper with bulletins
		s15816.association.normal.onetomany.Bulletin bulletin_1 = new s15816.association.normal.onetomany.Bulletin("bulletin_1", "bulettin_1_content");
		s15816.association.normal.onetomany.Bulletin bulletin_2 = new s15816.association.normal.onetomany.Bulletin("bulletin_2", "bulettin_2_content");
		s15816.association.normal.onetomany.Paper paper_1 = new s15816.association.normal.onetomany.Paper("paper_1", Arrays.asList(bulletin_1, bulletin_2));
		
		System.out.println(paper_1);
		System.out.println();
		System.out.println(bulletin_1);
		System.out.println(bulletin_2);
		System.out.println();
		
		//checking the security
		s15816.association.normal.onetomany.Paper paper_2 = new s15816.association.normal.onetomany.Paper("paper_2");
		bulletin_1.setPaper(paper_2);
		
		//remove association
		paper_1.removeBulletin(bulletin_1);
		
		//add new association
		paper_2.addBulletin(bulletin_1);

		System.out.println(paper_1);
		System.out.println();
		System.out.println(bulletin_1);
		System.out.println(bulletin_2);
		System.out.println();
	}

	private static void testManyToMany() {
		System.out.println("\n\n---------------MANY TO MANY-------------\n");
		
		//create
		s15816.association.normal.manytomany.Bulletin bulletin_1 = new s15816.association.normal.manytomany.Bulletin("bulletin_1", "bulettin_1_content");
		s15816.association.normal.manytomany.Bulletin bulletin_2 = new s15816.association.normal.manytomany.Bulletin("bulletin_2", "bulettin_2_content");
		s15816.association.normal.manytomany.Paper paper_1 = new s15816.association.normal.manytomany.Paper("paper_1", Arrays.asList(bulletin_1, bulletin_2));
		s15816.association.normal.manytomany.Paper paper_2 = new s15816.association.normal.manytomany.Paper("paper_2", Arrays.asList(bulletin_1, bulletin_2));
		
		System.out.println(paper_1);
		System.out.println(paper_2);
		System.out.println();
		System.out.println(bulletin_1);
		System.out.println(bulletin_2);
		System.out.println();
		System.out.println("Remove bulletin from paper_1");
		
		//remove
		paper_1.removeBulletin(bulletin_1);
		System.out.println(paper_1);
		System.out.println(bulletin_1);
	}

	private static void testAssociationWithAttrib() {
		s15816.association.withattrib.Project project_1 = new s15816.association.withattrib.Project("project_1");
		
		s15816.association.withattrib.Worker worker_1 = new s15816.association.withattrib.Worker("worker_1");
		
		project_1.addWorker(worker_1);
	}

	private static void testQualifiedAssociation() {
		
	}

	private static void testComposition() {
		
	}

}
