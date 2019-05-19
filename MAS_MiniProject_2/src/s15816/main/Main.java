package s15816.main;

import java.util.Arrays;

import javax.sound.midi.Soundbank;

import s15816.association.qualif.AvailableCourse;
import s15816.association.qualif.Course;
import s15816.association.qualif.Student;
import s15816.association.whole.House;
import s15816.association.whole.House.Room;
import s15816.association.withattrib.Project;
import s15816.association.withattrib.ProjectWorker;
import s15816.association.withattrib.Worker;

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
		testAssociationWithQualif();
		testAssociationWholePart();
		
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
		
		System.out.println("-----------WITH ATTRIB----------");
		System.out.println();
		
		Project project_1 = new Project("project_1");
		Worker worker_1 = new Worker("worker_1");
		ProjectWorker projectWorker_1 = new ProjectWorker(project_1, worker_1);
		
		System.out.println(project_1);
		System.out.println();
		System.out.println(projectWorker_1);
		System.out.println();
		System.out.println(worker_1);
		System.out.println();
		System.out.println();
	}
	
	private static void testAssociationWithQualif() {

		System.out.println("-----------Association Qualif----------");
		System.out.println();
		
		Course course_1 = new Course(AvailableCourse.Mathematics, "course_1");
		Course course_2 = new Course(AvailableCourse.Language, "course_2");
		Student student_1 = new Student("s15816", "student_1");
		
		course_1.addStudent(student_1);
		student_1.addCourse(course_2);
		
		System.out.println();
		System.out.println(course_1);
		System.out.println();
		System.out.println(student_1);
		System.out.println();
		
		Course course = student_1.findCourseByQualif(AvailableCourse.Mathematics);
		System.out.println("Founded course:");
		System.out.println(course);
	}

	private static void testAssociationWholePart() {

		System.out.println();
		System.out.println("-----------Whole part----------");
		System.out.println();
		
		/*
		 * 1.Część nie może istnieć bez całości - prywatny kontruktor
		 * 2.Cześć nie może być współdzielona pomiędzy całościami - brak metody dodającej istniejącą część do całości
		 * 3.Część zostaje usunięta przy usuwaniu całości - nie możliwe do realizacji z Javą
		 */
		
		House house_1 = new House("house_1");
		Room room_1 = house_1.createRoom("room_1");
		Room room_2 = house_1.createRoom("room_2");
		
		System.out.println(house_1);
		
		house_1.removeRoom(room_1);
		
		System.out.println(house_1);
		
	}

}
