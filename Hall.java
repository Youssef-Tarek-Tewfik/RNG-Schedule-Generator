package emotionalSupport;

public class Hall extends Room 
{	
	public Hall(String name, int capacity) 
	{
		super(name + " Hall", capacity, false);
	}
	
	@Override
	public boolean isPCReady() 
	{
		return false;
	}
	
	@Override
	public String toString() 
	{
		char[] CA = super.toString().toCharArray();
		CA[0] = 'H';
		return new String(CA);
	}
}
