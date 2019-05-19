package s15816.association.normal.manytomany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bulletin {
	private String name;
	private String content;

	private List<Paper> papers = new ArrayList<>();

	public Bulletin(String name, String content) {
		this.name = name;
		this.content = content;
	}
	
	public void addPaper(Paper paper) {
		if (!papers.contains(paper)) {
			papers.add(paper);
			paper.addBulletin(this);
		}
	}
	
	public void removePaper(Paper paper) {
		if (papers.contains(paper)) {
			paper.removeBulletin(this);
			papers.remove(paper);
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

	@Override
	public String toString() {
		return name + ":\n\tpapers=" + papers.stream().map(b->b.getName()).collect(Collectors.toList());
	}
}
