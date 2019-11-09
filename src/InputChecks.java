import javax.swing.JRadioButton;
import static java.lang.Character.*;

public class InputChecks 
{


	///////////////////////////////////////////////////////////////////////////////////
	
	public static boolean InputCheckID (String TxtIDc)
	{	  	 
		
		boolean digit;
			if(TxtIDc.length()!=9)
				return false;
			
			
			for(int i=0;i<TxtIDc.length();i++)
			{
				
				digit=Character.isDigit(TxtIDc.charAt(i));
				
				if(!digit)
					return false;
			}
	
		return true;
	}

	
	///////////////////////////////////////////////////////////////////////////////////
	
	public static boolean InputCheckAge (String TxtAgec)

	{	  	 
		
		boolean digit;
			if(TxtAgec.length()>3||TxtAgec.length()==0)
				return false;
			
			
			for(int i=0;i<TxtAgec.length();i++)
			{
				
				digit=Character.isDigit(TxtAgec.charAt(i));
				
				if(!digit)
					return false;
			}
	
		return true;
	}

	///////////////////////////////////////////////////////////////////////////////////
	
	public static boolean InputCheckRadio (JRadioButton BttMalec,JRadioButton BttFemalec)
	{	  	 
		return (BttMalec.isSelected()||BttFemalec.isSelected())?true:false;
		
	}
		
	///////////////////////////////////////////////////////////////////////////////////
	
	public static boolean InputCheckHigh (String TxtHighc)
	{
		boolean digit;
		
		if(TxtHighc.length()>3||TxtHighc.length()==0)
			return false;
		
		
		for(int i=0;i<TxtHighc.length();i++)
		{
			digit=Character.isDigit(TxtHighc.charAt(i));
			
			if(!digit)
				return false;
		}
		return true;
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public static boolean InputWeight (String TxtWeightc)
	{
		boolean digit;
		
		if(TxtWeightc.length()==0)
			return false;
		
		for(int i=0;i<TxtWeightc.length();i++)
		{
			
			digit=Character.isDigit(TxtWeightc.charAt(i));
			
			if(!digit)
				return false;
		}
		
		return true;
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////
	
	public static boolean WeightInputCheck(String str) {
        //If the string is empty, or if it isn't a '-' or digit, return false.
        //We need a check like this or a prefixed '-' will prevent it from
        // being recognized as a negative number.
        //This is safe because logical-OR "short-circuits", the right hand will only
        // evaluate if the left is false. If this wasn't the case, the calls to "charAt(0)"
        // would cause an exception on empty String.
        if ( str.isEmpty() || (str.charAt(0) != '-' && !isDigit(str.charAt(0))) ) {
            return false;
        }

        //We're skipping the first char since it was checked above.
        boolean foundADecimal = false;
        for (int i = 1; i < str.length(); i++) {
            //To avoid repeated evaluations
            char c = str.charAt(i);

            //Check to see if there's at most 1 decimal
            if ( !foundADecimal && c == '.' ) {
                foundADecimal = true;

                //We've "verified" this char already as a valid decimal point,
                // so we need to skip the next "isDigit" check.
                continue;
            }

            if ( !isDigit(c) ) {
                return false;
            }
        }

        return true;
    }
	
	/*	
	
	public static boolean InputCheckFN (String TxtFullNam)
	{	
		int i,
		  	  j;
			
		
		if(TxtFullNam.length()==0)
			return false;
		
		for(j=0;j<TxtFullNam.length();j++)
		{
			if(TxtFullNam.charAt(j)==' ')
				break;
		}
		if(j==0||j==TxtFullNam.length()-1||j==TxtFullNam.length())
			return false;
		
		for(i=0;i<TxtFullNam.length();i++)
		{
			if(!Character.isLetter(TxtFullNam.charAt(i))&&i!=j)
			{
					return false;
			}
			
		}
		return true;
	}
	*/
	
}
