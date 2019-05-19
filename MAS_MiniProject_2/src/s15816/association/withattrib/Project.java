package s15816.association.withattrib;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import s15816.association.normal.onetomany.Bulletin;

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

	public void addProjectWorker(Bulletin bulletin) {
		if (!bulletins.contains(bulletin)) {
			bulletins.add(bulletin);
			bulletin.setPaper(this);
		}
	}
	
	public void removeProjectWorker(Bulletin bulletin) {
		if (bulletins.contains(bulletin)) {
			bulletins.remove(bulletin);
			bulletin.setPaper(null);
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bulletin> getBulletins() {
		return bulletins;
	}

	@Override
	public String toString() {
		return name + ":\n\tbulletins=" + bulletins.stream().map(b->b.getName()).collect(Collectors.toList());
	}
	
}
