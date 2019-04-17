package emotionalSupport;

import java.util.Objects;

public class Room {
	public enum Equipment {
		None,
		Computers,
		Electrical_Equipment
	}
	
	protected String name;
	private final int id;
	private final int capacity;
	protected Equipment equipment;	
	private static int Count = DataManager.AllRooms.size();
	
	// This "Copy" constructor will NOT increment the count
	/*public Room(Room room) {
		this.name = room.name;
		this.capacity = room.capacity;
		this.equipment = room.equipment;
	}*/

	public Room(String name, int capacity, boolean hasPCs)
        {
            this.name = name;
            this.capacity = capacity;
            this.equipment = (hasPCs)? Equipment.Computers : Equipment.None;
            id = Count++;
	}
	
	public Room(String name,int capacity) {
		this(name, capacity, false);
	}

        @Override
        public String toString() {
            return name + "/" + capacity + "/" + id;
        }
	
	public static int getCount() {
		return Count;
	}

	public boolean isPCReady() {
		return (equipment == Equipment.Computers);
	}
	
	public String getName() {
		return name;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public int getId() {
		return id;
	}

	public boolean canHold(int attendees) {
		return (attendees <= capacity);
	}
	
	public int forceFill(int attendees) {
		if (attendees <= 0)
			return 0;
		if (canHold(attendees))
			return 0;
		return capacity - attendees;
	}

    @Override
    public int hashCode()
    {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
	
	
}
