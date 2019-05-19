package s15816.association.withattrib;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Project {
	private String name;

	private List<ProjectWorker> projectWorkers = new ArrayList<>();

	public Project(String name) {
		this.name = name;
	}
	
	public Project(String name, ProjectWorker projectWorker) {
		this.name = name;
		this.projectWorkers.add(projectWorker);
	}

	public Project(String name, List<ProjectWorker> projectWorkers) {
		this.name = name;
		for (ProjectWorker projectWorker : projectWorkers) {
			addProjectWorker(projectWorker);
		}
	}

	public void addProjectWorker(ProjectWorker projectWorker) {
		if (!projectWorkers.contains(projectWorker)) {
			projectWorkers.add(projectWorker);
			projectWorker.setProject(this);
		}
	}
	
	public void removeProjectWorker(ProjectWorker projectWorker) {
		if (projectWorkers.contains(projectWorker)) {
			projectWorkers.remove(projectWorker);
			projectWorker.setProject(null);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProjectWorker> getProjectWorkers() {
		return projectWorkers;
	}

	@Override
	public String toString() {
		return name + ":\n\tprojectWorkers=" + projectWorkers + "\n\tworkers=" + projectWorkers.stream().map(b->b.getWorker().getName()).collect(Collectors.toList());
	}
	
}
