package emotionalSupport;

public class Lab extends Room {
	/*public Lab(Lab lab) {
		super((Room) lab);
	}*/
	
	public Lab(String name, int capacity, Equipment labEquipment) {
		super(name, capacity, false);
		this.equipment = labEquipment;
	}
	
	public Lab(String name, int capacity) {
		this(name, capacity, Equipment.None);
	}
	
	public void setEquipment(Equipment e) {
		equipment = e;
	}
	
	public boolean isElectronicsLab() {
		return (equipment == Equipment.Electrical_Equipment);
	}
}
