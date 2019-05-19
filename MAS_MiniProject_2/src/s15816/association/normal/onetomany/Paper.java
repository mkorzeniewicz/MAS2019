package s15816.association.normal.onetomany;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		for (Bulletin bulletin : bulletins) {
			addBulletin(bulletin);
		}
	}

	public void addBulletin(Bulletin bulletin) {
		if (!bulletins.contains(bulletin)) {
			bulletins.add(bulletin);
			bulletin.setPaper(this);
		}
	}
	
	public void removeBulletin(Bulletin bulletin) {
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
