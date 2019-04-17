package emotionalSupport;

public class Lab extends Room 
{
	public Lab(String name, int capacity, Equipment labEquipment)
	{
		super(name, capacity);
		this.equipment = labEquipment;
	}
	
	public Lab(String name, int capacity)
	{
		this(name, capacity, Equipment.None);
	}
	
	public void setEquipment(Equipment e)
	{
		equipment = e;
	}
	
	public boolean isElectronicsLab()
	{
		return (equipment == Equipment.Electrical_Equipment);
	}
	
	public String toString() 
	{
		char[] CA = super.toString().toCharArray();
		CA[0] = 'L';
		return new String(CA);
	}
}
