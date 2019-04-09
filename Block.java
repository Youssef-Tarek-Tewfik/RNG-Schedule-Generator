package emotionalSupport;

public class Block {
	public Room[] rooms;
	private final int start;
	private final int end;
	
	public Block (int startTime, Room[] rooms) {
		start = startTime;
		end = start + 1;
		this.rooms = rooms; 
	}
	
	public int getStart() {
		return start;
	}
	public int getEnd() {
		return end;
	}
	
}
