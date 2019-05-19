package s15816.association.normal.onetomany;

import java.util.ArrayList;
import java.util.List;

public class Paper {
	private String name;

	private List<Bulletin> bulletins = new ArrayList<>();

	public Paper(String name) {
		this.name = name;
	}
	
	public Paper(String name, Bulletin bulletin) {
		this.name = name;
		this.bulletins.add(bulletin);
	}

	public Paper(String name, List<Bulletin> bulletins) {
		this.name = name;
		this.bulletins.addAll(bulletins);
	}

	public void addBulletin(Bulletin bulletin) {
		if (!bulletins.contains(bulletin)) {
			bulletins.add(bulletin);
			bulletin.setPaper(this);
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
		return "Paper \n\tname=" + name + "\n\tbulletins=" + bulletins;
	}
	
}
