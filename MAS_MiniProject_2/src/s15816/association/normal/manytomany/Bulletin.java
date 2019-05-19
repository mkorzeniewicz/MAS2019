package s15816.association.normal.manytomany;

import java.util.ArrayList;
import java.util.List;

public class Bulletin {
	private String name;
	private String content;
	
	private List<Paper> papers = new ArrayList<>();

	public Bulletin(String name, String content, Paper paper) {
		this.name = name;
		this.content = content;
		this.papers.add(paper);
	}
	
	public void addPaper(Paper paper) {
		if (!papers.contains(paper)) {
			papers.add(paper);
			paper.addBulletin(this);
		}
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
}
