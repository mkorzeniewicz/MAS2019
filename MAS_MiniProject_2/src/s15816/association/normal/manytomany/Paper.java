package s15816.association.normal.manytomany;

import java.util.ArrayList;
import java.util.List;

public class Paper {
	private String name;

	private List<Bulletin> bulletins = new ArrayList<>();

	public Paper(String name, Bulletin bulletin) {
		this.name = name;
		this.bulletins.add(bulletin);
	}

	public void addBulletin(Bulletin bulletin) {
		if (!bulletins.contains(bulletin)) {
			bulletins.add(bulletin);
			bulletin.addPaper(this);
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
}
