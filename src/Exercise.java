import java.io.Serializable;

public class Exercise implements Serializable
{
	private String exerciseName;
	private String muscle;
	private String techLink;
	private String setsxReps;
	private int rest;
	private double weight;
	
	
	
	public Exercise() {
		
	}



	public Exercise(String exerciseName, String muscle, String techLink, String setsxReps, int rest, double weight) 
	{
		
		this.exerciseName = exerciseName;
		this.muscle = muscle;
		this.techLink = techLink;
		this.setsxReps = setsxReps;
		this.rest = rest;
		this.weight = weight;
	}

	
	
	public String getExerciseName() 
	{
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) 
	{
		this.exerciseName = exerciseName;
	}

	public String getMuscle() 
	{
		return muscle;
	}

	public void setMuscle(String muscle) 
	{
		this.muscle = muscle;
	}

	public String getTechLink() 
	{
		return techLink;
	}

	public void setTechLink(String techLink) 
	{
		this.techLink = techLink;
	}

	public String getSetsxReps() 
	{
		return setsxReps;
	}

	public void setSetsxReps(String setsxReps) 
	{
		this.setsxReps = setsxReps;
	}

	public int getRest() 
	{
		return rest;
	}

	public void setRest(int rest) 
	{
		this.rest = rest;
	}

	public double getWeight() 
	{
		return weight;
	}

	public void setWeight(double weight) 
	{
		this.weight = weight;
	}



	@Override
	public String toString() {
		return "Exercise [exerciseName=" + exerciseName + ", muscle=" + muscle + ", techLink=" + techLink
				+ ", setsxReps=" + setsxReps + ", rest=" + rest + ", weight=" + weight + "]";
	}
	

	
}
