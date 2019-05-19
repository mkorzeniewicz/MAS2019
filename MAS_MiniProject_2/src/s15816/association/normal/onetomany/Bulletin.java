package s15816.association.normal.onetomany;

public class Bulletin {
	private String name;
	private String content;

	private Paper paper;

	public Bulletin(String name, String content) {
		this.name = name;
		this.content = content;
	}

	public Bulletin(String name, String content, Paper paper) {
		this.name = name;
		this.content = content;
		this.paper = paper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		if (paper == null) {
			this.paper.removeBulletin(this);
			this.paper = null;
		} else {
			if (this.paper == null) {
				this.paper = paper;
				paper.addBulletin(this);
			} else {
				System.out.println("Association cannot be saved. " + this.name + " already is associated with " + this.paper.getName());
			}
		}
	}

	@Override
	public String toString() {
		if (this.paper == null) {
			return name;
		}
		return name + " in " + this.paper.getName();
	}

}
