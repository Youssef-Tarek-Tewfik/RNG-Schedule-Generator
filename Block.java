package emotionalSupport;

public class Block {
	public Room[] rooms;
	private final int start;
	private final int end;
	
	public Block (int startTime, Room[] rooms) {
		start = startTime;
		end = start + 1;
		
		this.rooms = new Room[rooms.length];
		int i = 0;
		for (Room r : rooms) {
			if (r instanceof Lab)
				this.rooms[i++] = new Lab((Lab) r);
			
			else if (r instanceof Hall)
				this.rooms[i++] = new Hall((Hall) r);
			
			else 
				this.rooms[i++] = new Room(r);
		}
	}
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
}
