package s15816.association.withattrib;

public class ProjectWorker {

	private long salary;
	private Project project;
	private Worker worker;

	public ProjectWorker(Project project, Worker worker) {
		super();
		this.project = project;
		this.worker = worker;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public Project getProject() {
		return project;
	}

	public Worker getWorker() {
		return worker;
	}

	public void setProject(Project project) {
		if (project == null) {
			this.project.removeProjectWorker(this);
			this.project = null;
		} else {
			if (this.project == null) {
				this.project = project;
				project.removeProjectWorker(this);
			} else {
				System.out.println("Association cannot be saved.");
			}
		}
	}

	public void setWorker(Worker worker) {
		if (worker == null) {
			this.worker.removeProjectWorker(this);
			this.worker = null;
		} else {
			if (this.worker == null) {
				this.worker = worker;
				worker.removeProjectWorker(this);
			} else {
				System.out.println("Association cannot be saved.");
			}
		}
	}
}
