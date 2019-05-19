package s15816.association.withattrib;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker {
	private String name;
	
	private List<ProjectWorker> projectWorkers = new ArrayList<>();

	public Worker(String name) {
		this.name = name;
	}
	
	public Worker(String name, ProjectWorker projectWorker) {
		this.name = name;
		addProjectWorker(projectWorker);
	}

	public Worker(String name, List<ProjectWorker> projectWorkers) {
		this.name = name;
		for (ProjectWorker projectWorker : projectWorkers) {
			addProjectWorker(projectWorker);
		}
	}

	public void addProjectWorker(ProjectWorker projectWorker) {
		if (!projectWorkers.contains(projectWorker)) {
			projectWorkers.add(projectWorker);
			projectWorker.setWorker(this);
		}
	}
	
	public void removeProjectWorker(ProjectWorker projectWorker) {
		if (projectWorkers.contains(projectWorker)) {
			projectWorkers.remove(projectWorker);
			projectWorker.setWorker(null);
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
		return name + ":\n\tprojectWorkers=" + projectWorkers + "\n\tprojects=" + projectWorkers.stream().map(b->b.getProject().getName()).collect(Collectors.toList());
	}
}
