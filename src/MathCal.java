
public class MathCal 
{

	public static double CaloriesMaleNFemale(String gender,double weight,int high,int age,int intescivity,String gainOrLose)
	{
		double BMR;
		double calories;

		if(gender.equals("Male"))
		    BMR=66.47+(13.75*weight)+(5.003*high)-(6.755*age);
		
		else
			BMR=655.1+(9.563*weight)+(1.85*high)-(4.646*age);
		
		
		if(intescivity==2||intescivity==3)
			calories= BMR*1.375;
		else
		{
			if(intescivity==4)
				calories= BMR*1.55;
			else
				calories= BMR*1.725;
		}
		
		if(gainOrLose.equals("Gain"))
			return calories+(calories*0.1);
		else
			return calories-(calories*0.1);
		
	}
	
	
	public static int Protein(double weight,String gainOrLose)
	{
		int protein;
		
		if(gainOrLose.equals("Gain"))
		{
			protein=(int)(weight*1.6);
			return (int) protein;
		}
		else
		{
			protein=(int) (weight*1.8);
			return (int) protein;
		}
		
	}
	
	
	
	
}
