package emotionalSupport;

public class Block {
	private boolean[] occupied;
	private final int start;
	private final int end;
	
	public Block (int startTime) {
		start = startTime;
		end = start + 1;	
		occupied = new boolean[Room.getCount()];
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public boolean isOccupied(Room r) {
		return occupied[r.getId()];
	}
	
	public void fill(Room r) {
		occupied[r.getId()] = true;
	}
	
	public void free(Room r) {
		occupied[r.getId()] = false;
	}
}
