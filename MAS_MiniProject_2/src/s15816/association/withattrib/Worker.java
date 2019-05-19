package s15816.association.withattrib;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker {
	private String name;
	
	private List<ProjectWorker> projects = new ArrayList<>();

	public Worker(String name) {
		this.name = name;
	}
	
	public Worker(String name, ProjectWorker project) {
		this.name = name;
		this.projects.add(project);
	}

	public Worker(String name, List<ProjectWorker> projects) {
		this.name = name;
		for (ProjectWorker project : projects) {
			addProject(project);
		}
	}

	public void addProject(ProjectWorker project) {
		if (!projects.contains(project)) {
			projects.add(project);
			project.addWorker(this);
		}
	}
	
	public void removeProject(ProjectWorker project) {
		if (projects.contains(project)) {
			projects.remove(project);
			project.removeWorker(this);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name + ":\n\tprojects=" + projects.stream().map(b->b.getProject().getName()).collect(Collectors.toList());
	}
}
