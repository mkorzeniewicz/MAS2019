package s15816.association.whole;

import java.util.ArrayList;
import java.util.List;

public class House {
	private String name;
	
	private List<Room> rooms = new ArrayList<>();
	
	public House(String name) {
		this.name = name;
	}

	public Room createRoom(String name) {
		Room room = new Room(name);
		rooms.add(room);
		
		return room;
	}

	public void removeRoom(Room room) {
		if (room == null) {
			return;
		}
		if (rooms.contains(room)) {
			rooms.remove(room);
		}
	}
	
	@Override
	public String toString() {
		return name + ": \n\trooms: " + rooms;
	}

	public class Room {
		private String name;

		public Room(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Room: " + name;
		}
	}
}
