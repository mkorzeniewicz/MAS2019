package s15816.association.qualif;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Course {
	private AvailableCourse courseKey;
	private String name;

	private List<Student> students = new ArrayList<>();

	public Course(AvailableCourse courseKey, String name) {
		this.courseKey = courseKey;
		this.name = name;
	}

	public void addStudent(Student student) {
		if (student == null) {
			System.out.println("Null student cannot be added");
			return;
		}
		if (!students.contains(student)) {
			students.add(student);
			student.addCourse(this);
		}
	}

	public void removeStudent(Student student) {
		if (students.contains(student)) {
			students.remove(student);
			student.removeCourse(courseKey);
		}
	}

	public AvailableCourse getCourseKey() {
		return courseKey;
	}

	public void setCourseKey(AvailableCourse courseKey) {
		this.courseKey = courseKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	@Override
	public String toString() {
		return "Course [courseKey=" + courseKey + ", name=" + name + "]\n\tstudents=" + students.stream().map(s->s.getIndex() + ":" + s.getName()).collect(Collectors.toList());
	}


	
}
