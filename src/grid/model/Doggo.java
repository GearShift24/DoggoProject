package grid.model;

public class Doggo 
{

	private String breed;
	
	public String getBreed()
	{
		return breed;
	}
	
	public void setBreed(String breed)
	{
		this.breed = breed;
	}
	
	//toString changes object to a readable string
	public String toString()
	{
		String description = "The dogs breed is " + breed;
		return description;
	}
	
	public Doggo()
	{
		this.breed = "doge";
	}
	
	
}