package emotionalSupport;

public class Hall extends Room {
	public Hall(Hall hall) {
		//super(new Room(hall.name, hall.getCapacity()));
		super((Room) hall);
	}
	
	public Hall(String name, int capacity) {
		super(name + " Hall", capacity, false);
	}
	
	@Override
	public boolean isPCReady() {
		return false;
	}
}
