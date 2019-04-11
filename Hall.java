package emotionalSupport;

public class Hall extends Room {	
	public Hall(String name, int capacity) {
		super(name + " Hall", capacity, false);
	}
	
	@Override
	public boolean isPCReady() {
		return false;
	}
}
