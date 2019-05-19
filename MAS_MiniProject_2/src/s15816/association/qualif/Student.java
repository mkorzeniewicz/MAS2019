package s15816.association.qualif;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Student {
	private String index;
	private String name;
	
	private Map<AvailableCourse, Course> courses = new HashMap<>();

	public Student(String index, String name) {
		this.index = index;
		this.name = name;
	}
	
	public void addCourse(Course course) {
		if (course == null) {
			System.out.println("Null course cannot be added");
			return;
		}
		if (!courses.containsKey(course.getCourseKey())) {
			courses.put(course.getCourseKey(), course);
			course.addStudent(this);
		}
	}
	
	public void removeCourse(AvailableCourse courseKey) {
		if (courses.containsKey(courseKey)) {
			courses.get(courseKey).removeStudent(this);
			courses.remove(courseKey);
		}
	}
	
	public Course findCourseByQualif(AvailableCourse courseKey) {
		return courses.get(courseKey);
	}
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<AvailableCourse, Course> getCourses() {
		return courses;
	}

	@Override
	public String toString() {
		return "Student [index=" + index + ", name=" + name + "]\n\tcourses=" + courses.entrySet().stream().map(b->b.getValue().getName()).collect(Collectors.toList());
	}
}
