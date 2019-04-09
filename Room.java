package emotionalSupport;

public class Room {
	public enum Equipment {
		None,
		Computers,
		Electrical_Equipment
	}
	
	protected String name;
	private final int capacity;
	private boolean isOccupied;
	protected Equipment equipment;
	// Instructor	TBA
	// Course		TBA	 
	
	private static int Count = 0;
	
	// This "Copy" constructor will NOT increment the count
	public Room(Room room) {
		this.name = room.name;
		this.capacity = room.capacity;
		this.isOccupied = room.isOccupied;
		this.equipment = room.equipment;
	}

	public Room(String name, int capacity, boolean hasPCs) {
		this.name = name;
		this.capacity = capacity;
		this.equipment = (hasPCs)? Equipment.Computers : Equipment.None;
		this.isOccupied = false;	
		++Count;
	}
	
	public Room(String name, int capacity) {
		this(name, capacity, false);
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
	
	public boolean isOccupied() {
		return isOccupied;
	}

	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean canHold(int attendees) {
		return (attendees <= capacity);
	}
	
	public int forceFill(int attendees) {
		if (isOccupied)
			return attendees;
		if (attendees <= 0)
			return 0;
		isOccupied = true;
		if (canHold(attendees))
			return 0;
		return capacity - attendees;
	}
}
