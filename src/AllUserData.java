import java.io.Serializable;
import java.util.Vector;

public class AllUserData implements Serializable
{
	
	private String userName;
	private String id;
	private int age;
	private String userGender;
	private int high;
	private String gainorlose;
	private int days;
	private String programName;
	private String programExplanation;
	private Vector<Exercise> exercise;
	private int caloriesPerDay;
	private int proteinPerDay;
	private double currentWeight;
	private String running;
	private String healthIssues;
	
	public AllUserData() 
	{
		exercise=new Vector<Exercise>();
		userName="unknown";
		
	}

	public AllUserData(String userName, String id, int age, String userGender, int high,String gainorlose,
			int days,String programName, String programExplanation, Vector<Exercise> exercise,
			double currentWeight,String running,String healthIssues) 
	{
		
		this.userName = userName;
		this.id = id;
		this.age = age;
		this.userGender = userGender;
		this.high = high;
		this.gainorlose = gainorlose;
		this.days=days;
		this.programName = programName;
		this.programExplanation = programExplanation;
		this.exercise = exercise;
		this.caloriesPerDay = (int) MathCal.CaloriesMaleNFemale(userGender, currentWeight, high, age, days, gainorlose);
		this.proteinPerDay = (int) MathCal.Protein(currentWeight,gainorlose);
		this.currentWeight = currentWeight;
		this.running=running;
		this.healthIssues=healthIssues;
	}

	public String getUserName() 
	{
		return userName;
	}


	public void setUserName(String userName) 
	{
		this.userName = userName;
	}


	public String getId() 
	{
		return id;
	}


	public void setId(String id) 
	{
		this.id = id;
	}


	public int getAge() 
	{
		return age;
	}


	public void setAge(int age) 
	{
		this.age = age;
	}


	public String getUserGender() 
	{
		return userGender;
	}


	public void setUserGender(String userGender) 
	{
		this.userGender = userGender;
	}


	public int getHigh() 
	{
		return high;
	}


	public void setHigh(int high) 
	{
		this.high = high;
	}


	public String getGainorlose() 
	{
		return gainorlose;
	}


	public void setGainorlose(String gainorlose) 
	{
		this.gainorlose = gainorlose;
	}


	public int getDays() 
	{
		return days;
	}

	public void setDays(int days) 
	{
		this.days = days;
	}

	public String getProgramName() 
	{
		return programName;
	}


	public void setProgramName(String programName) 
	{
		this.programName = programName;
	}


	public String getProgramExplanation() 
	{
		return programExplanation;
	}


	public void setProgramExplanation(String programExplanation) 
	{
		this.programExplanation = programExplanation;
	}


	public Vector<Exercise> getExercise() 
	{
		return exercise;
	}


	public void setExercise(Vector<Exercise> exercise) 
	{
		this.exercise = exercise;
	}


	public int getCaloriesPerDay() 
	{
		return caloriesPerDay;
	}


	public void setCaloriesPerDay(int caloriesPerDay) 
	{
		this.caloriesPerDay = caloriesPerDay;
	}


	public double getProteinPerDay() 
	{
		return proteinPerDay;
	}


	public void setProteinPerDay(int proteinPerDay) 
	{
		this.proteinPerDay = proteinPerDay;
	}


	public double getCurrentWeight() 
	{
		return currentWeight;
	}


	public String getRunning() 
	{
		return running;
	}


	public void setRunning(String running) 
	{
		this.running = running;
	}
	
	public String getHealthIssues() 
	{
		return healthIssues;
	}

	public void setHealthIssues(String healthIssues) 
	{
		this.healthIssues = healthIssues;
	}

	
	
	
	
	
	
	public void setCurrentWeight(double currentWeightNew) 
	{
		this.currentWeight = currentWeightNew;
		this.caloriesPerDay = (int) MathCal.CaloriesMaleNFemale(userGender, currentWeightNew, high, age, days, gainorlose);
		this.proteinPerDay = (int) MathCal.Protein(currentWeightNew,gainorlose);
	}


	public static AllUserData CreatAllUserDataSemple()
	{
		
		AllUserData obj=new AllUserData("Lior","123456789",20,"Male",185,"Gain",2,"FBW","<html><body>FBW = Full Body Workout, weekly training sessions in which the whole body is worked in one<br> workout, which increases muscle volume and body development in each workout.<br>Weekly arrangement:<br>W=workout, X=rest<br>Weekly session for 2 days a week: W X X W X X X<br>Weekly session for 3 days a week: W X W X W X X </body></html>",CreateExerciseVectorSample(),75.6,"Yes","Yes");
		
		//System.out.println(obj);
		
		return obj;
	}
	
	public static Vector<Exercise> CreateExerciseVectorSample(){
		
		Vector<Exercise> exerciseVec = new Vector<Exercise>();
		exerciseVec.add(new Exercise("Bench Press","Chest","https://www.youtube.com/watch?v=esQi683XR44","5 x 6",70,80.6));
		exerciseVec.add(new Exercise("Seated Dumbbell Press","Shoulders","https://www.youtube.com/watch?v=t2b8UdqmlFs","5 x 8",40,20));
		exerciseVec.add(new Exercise("Triceps Pushdown","Triceps","https://www.youtube.com/watch?v=esQi683XR44","7 x 6",30,50.5));
		exerciseVec.add(new Exercise("Squat","Legs","https://www.youtube.com/watch?v=t2b8UdqmlFs","7x8",50,40.6));

		return exerciseVec;
		
	}

	@Override
	public String toString() {
		return "AllUserData [userName=" + userName + ", id=" + id + ", age=" + age + ", userGender=" + userGender
				+ ", high=" + high + ", gainorlose=" + gainorlose + ", days=" + days + ", programName=" + programName
				+ ", programExplanation=" + programExplanation + ", exercise=" + exercise + ", caloriesPerDay="
				+ caloriesPerDay + ", proteinPerDay=" + proteinPerDay + ", currentWeight=" + currentWeight
				+ ", running=" + running + ", healthIssues=" + healthIssues + "]";
	}


	
	

}
