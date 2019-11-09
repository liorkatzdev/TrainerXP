import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;


public class SQLquerys {


	static Connection  con;

 	static PreparedStatement   stmt;

 	static String  	str;

 	static ResultSet  rs=null;

 	

	public static void Connect(){		

	           	try {

	           		con=DriverManager.getConnection("jdbc:ucanaccess://Database2.accdb");
	           		


					

				} catch (SQLException e) {

					// TODO Auto-generated catch block

					e.printStackTrace();

				}  				

	}

	

	public static void DisConnect(){

		try {

			stmt.close();

			con.close(); // Close connection

		} catch (SQLException e) {

				e.printStackTrace();

		}                		

	}

	public static void InsertNewUser(UserLK userData) 
	{
		Connect();
		
		str= "INSERT INTO USERSLK (DataFullName, DataID, DataAge, DataGender, DataHigh, DataWeight, DataPassword, DataQ1, DataQ2, DataQ3,HealthIssues ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"  ;

    	try {

    		stmt= con.prepareStatement(str);
    		stmt.setString(1, userData.getFullName());
    		stmt.setString(2, userData.getID());
    		stmt.setInt(3, userData.getAge());
    		stmt.setString(4, userData.getGnder());
    		stmt.setInt(5, userData.getHigh());
    		stmt.setDouble(6, userData.getWeight());
    		stmt.setString(7, userData.getPassword());
    		stmt.setString(8, userData.getQ1());
    		stmt.setInt(9, userData.getQ2());
    		stmt.setString(10, userData.getQ3());
    		stmt.setString(11, userData.getHealthIssues());
    		stmt.executeUpdate();
    		
    		System.out.println(userData);
    	}
    	
    	
    	
    	catch (Exception ex) 
    	{
            System.out.println(ex);
    	}
    	DisConnect();
    }
    		
		
    	public static UserLK FindeUser(String ID , String password)
    	{
    		Connect();
    		UserLK user = new UserLK();
    		str= "SELECT USERSLK.DataFullName, USERSLK.DataID, USERSLK.DataAge, USERSLK.DataGender, USERSLK.DataHigh, USERSLK.DataWeight, USERSLK.DataPassword, USERSLK.DataQ1, USERSLK.DataQ2, USERSLK.DataQ3 " 
    				+ "FROM USERSLK WHERE (DataID = ? AND DataPassword = ?)";

        	try {

        		stmt= con.prepareStatement(str);
        		stmt.setString(1, ID);
        		stmt.setString(2, password);
        		
        		ResultSet rs = stmt.executeQuery();
        		while (rs.next()) {
        			user.setFullName(rs.getString(1));
        			user.setID(rs.getString(2));
        			user.setAge(rs.getInt(3));
        			user.setGnder(rs.getString(4));
        			user.setHigh(rs.getInt(5));
        			user.setWeight(rs.getDouble(6));
        			user.setPassword(rs.getString(7));
        			user.setQ1(rs.getString(8));
        			user.setQ2(rs.getInt(9));
        			user.setQ3(rs.getString(10));
        			user.setHealthIssues(rs.getString(11));
        		}
    		
        	}
        	
        	catch (Exception ex) 
        	{
                System.out.println(ex);
            }
        	
        	DisConnect();
        	
        	
        	return user;
    	}
    	
    	
    	public static UserLK FindeToAddUser(String ID )
    	{
    		
    		Connect();
    		
    		UserLK user = new UserLK();
    		str= "SELECT USERSLK.DataFullName, USERSLK.DataID, USERSLK.DataAge, USERSLK.DataGender, USERSLK.DataHigh, USERSLK.DataWeight, USERSLK.DataPassword, USERSLK.DataQ1, USERSLK.DataQ2, USERSLK.DataQ3, USERSLK.HealthIssues" 
    				+ " FROM USERSLK WHERE(DataID = ?)";

        	try {

        		stmt= con.prepareStatement(str);
        		stmt.setString(1, ID);
        		
        		ResultSet rs = stmt.executeQuery();
        		while (rs.next()) {
        			user.setFullName(rs.getString(1));
        			user.setID(rs.getString(2));
        			user.setAge(rs.getInt(3));
        			user.setGnder(rs.getString(4));
        			user.setHigh(rs.getInt(5));
        			user.setWeight(rs.getDouble(6));
        			user.setPassword(rs.getString(7));
        			user.setQ1(rs.getString(8));
        			user.setQ2(rs.getInt(9));
        			user.setQ3(rs.getString(10));
        			user.setHealthIssues(rs.getString(11));
        		}
    		
        	}
        	
        	catch (Exception ex) 
        	{
                System.out.println(ex);
            }
        	
        	
        	DisConnect();
        	
        	return user;
    	}
 	
    	/////////////////////////////////////////////-Used in GetUserDataByID to get the information of exercise
    	public static Exercise GetExerciseByID(int exID)
    	{
    		
    		Connect();
    		
    		Exercise ex = new Exercise();
    		
    		
    		str= "SELECT ExercisesCode.ExercisesName, ExercisesCode.Muscle, ExercisesCode.TechniqueVideo, ExercisesCode.SetsXRepeats, ExercisesCode.RestBetweenSets" 
    				+ " FROM ExercisesCode WHERE ExercisesCode.ID = ?";

        	try {
        		stmt= con.prepareStatement(str);
        		stmt.setInt(1, exID);
        		
        		ResultSet rs = stmt.executeQuery();
        		while (rs.next()) {
        			ex.setExerciseName(rs.getString(1));
        			ex.setMuscle(rs.getString(2));
        			ex.setTechLink(rs.getString(3));
        			ex.setSetsxReps(rs.getString(4));
        			ex.setRest(rs.getInt(5));
        		}
        	}
        	
        	
        	
        	catch (Exception e) 
        	{
               e.printStackTrace();
            }
        	
        	
        	
        	DisConnect();
        	
        	return ex;
    	}
    	////////////////////////////////////////////////////////////////////////-Used in the MainApp to get all the parameters the user need
    	public static AllUserData GetUserDataByID(String userID)
    	{
    		
    		Connect();
    		
    		String excercisePlace="";
    		int excerciseKey=0;
    		double excerciseWeight=0;
    		
    		UserLK user=new UserLK();
    		AllUserData alluserdata = new AllUserData();
    		
    		
    		str= "SELECT UsersAndProgram.Program,UsersAndProgram.ExercisePlace,UsersAndProgram.ExerciseKey,UsersAndProgram.ExerciseWeight" 
    				+ " FROM UsersAndProgram WHERE UsersAndProgram.UserIDKey = ?";

        	try {
        		stmt= con.prepareStatement(str);
        		stmt.setString(1, userID);
        		
        		ResultSet rs = stmt.executeQuery();
        		
        		alluserdata.setId(userID);
        		while (rs.next()) 
        		{
        			
        			alluserdata.setProgramName(rs.getString(1));
        			//לוקח את המשתנה לי הסדר שרשמתי את השאילתה בSTR
        			excercisePlace=rs.getString(2);
        			
        			
        			excerciseKey=rs.getInt(3);
        			excerciseWeight=rs.getDouble(4);
        			
        			System.out.println("excerciseKey is: "+excerciseKey);
        			// add excercises to the Vector from the ExercisesCode and  UsersAndProgram Tables
        			alluserdata.getExercise().addElement(SQLquerys.GetExerciseByID(excerciseKey));
        			alluserdata.getExercise().lastElement().setWeight(excerciseWeight);
        			
        			//excerciseKey=rs.getInt(3);
        			//excerciseWeight=rs.getDouble(4);
        			
        		}
        		
        		user=SQLquerys.FindeToAddUser(userID);
        		
        		alluserdata.setUserName(user.getFullName());
        		alluserdata.setAge(user.getAge());
        		alluserdata.setUserGender(user.getGnder());
        		alluserdata.setHigh(user.getHigh());
        		alluserdata.setGainorlose(user.getQ1());
        		alluserdata.setDays(user.getQ2());
        		alluserdata.setProgramExplanation(FunctionProgramExplan(alluserdata.getProgramName()));
        		alluserdata.setCurrentWeight(user.getWeight());
        		alluserdata.setRunning(user.getQ3());
        		alluserdata.setHealthIssues(user.getHealthIssues());
        		
        		alluserdata.toString();
        		
        		
        		//System.out.println(alluserdata + " excercisePlace:"+excercisePlace+" excerciseKey:"+excerciseKey+" "+ excerciseWeight);
        	}
        	
        	
        	
        	catch (Exception e) {
               e.printStackTrace();
            }
        	
        	DisConnect();
        	
        	return alluserdata;
    	}
    	
    	////////////////////////////////////////////////////////////////////////-Used in  GetUserDataByID to get the Program Explanation
    	public static String FunctionProgramExplan(String program)
    	{
    		
    		
    		String FWB,
    				AB,
    				ABC;
    		FWB="<html><body>FBW = Full Body Workout, weekly training sessions in which the whole body is worked in one<br> workout, which increases muscle volume and body development in each workout.<br>Weekly arrangement:<br>W=workout<br>X=rest<br>Weekly session for 2 days a week: W X X W X X X<br>Weekly session for 3 days a week: W X W X W X X </body></html>";
    		AB="<html><body>AB - a training system consisting of 4 training sessions, split in the order: ABAB.<br> In A you train half of the body ,and in B the second half. <br>The most common split is chest, triceps, shoulders(A) and legs,<br> back and biceps(B).<br>Weekly session : A B X A B X X</body></html>";
    		ABC="<html><body>ABC - a training system consisting of 6 training sessions, split in the order: ABCABC, That in each<br> session a third of the body is trained individually.<br> In A: chest, Triceps.<br>In B: Biceps, Back.<br>And in C : Legs, Shoulders.<br>Weekly session : A B C X A B C</body></html> ";		
    				
    		if(program.equals("FBW"))
    			return FWB;
    		else
    			if(program.equals("ABC"))
    				return ABC;
    			else
    				return AB;
    		
    		
    		
    	}
    	
    	
    	
    	public static void ProgramChosen(int Q2,String UserID)
		{
			if(Q2==2||Q2==3)
				ProgramInsert("FBW",UserID);
			else
				if(Q2==4)
					ProgramInsert("AB",UserID);
				else
					ProgramInsert("ABC",UserID);

		}
    	
    	////////////////////////////////////////////////////////////////////////-Used in ProgramChosen
    	public static void ProgramInsert(String programName,String UserID)
    	{
    		
    		Connect();
    		
    		String pTable="";
    		
    		if(programName.equals("FBW"))
    			pTable= "FBWTable";
    		else
    			if(programName.equals("ABC"))
    				pTable="ABCTable";
    			else
    				pTable="ABTable";
    		
    		
    		String s="";
    		int i=0;
    		
    		
        			str= "SELECT "+pTable+".ExerciseKey,"+pTable+".ExercisePlace" 
            				+ " FROM "+pTable;

        			
                	try {
                		stmt= con.prepareStatement(str);
  
                		ResultSet rs = stmt.executeQuery();
                		while (rs.next())                 
                		{
                			 i=rs.getInt(1);
                			 s=rs.getString(2);
                			
                			 ExerciseInsert(UserID,programName,s,i);
                		}
                	}
    		
        	
        	catch (Exception e) 
            {
               e.printStackTrace();
            }
    		
                	
             DisConnect();
                	
                	
    	}
    	
    	
    	
    	////////////////////////////////////////////////////////////////////////-Used in ProgramChosen ProgramInsert
    	public static void ExerciseInsert(String UserID,String program,String exercisePlace,int exerciseKeyNumber)
    	{
    		
    		Connect();
    		
    		str= "INSERT INTO UsersAndProgram (UserIDKey, Program, ExercisePlace, ExerciseKey, ExerciseWeight ) "
    				+ "VALUES (?, ?, ?, ?, ?)"  ;
    		
    		
    		try {
        		stmt= con.prepareStatement(str);
        		stmt.setString(1, UserID);
        		stmt.setString(2, program);
        		stmt.setString(3, exercisePlace);
        		stmt.setInt(4, exerciseKeyNumber);
        		stmt.setInt(5, 0);
        		stmt.executeUpdate();
        	}
        	
        	
        	catch (Exception ex) 
        	{
                System.out.println(ex);
        	}
    		
    		
    		 DisConnect();
        }
    		
    		
    	////////////////////////////////////////////////////////////////////////-Used in HandleAClient in UpdateExerciseWeight to get the Exercise Key Code
    	public static int GetIDKeyByExercise(String exeName )
    	{
    		
    		Connect();
    		
    		int idKey=0;
    		
    		
    		str= "SELECT ExercisesCode.ID" 
    				+ " FROM ExercisesCode WHERE ExercisesCode.ExercisesName = ?";

        	try {
        		stmt= con.prepareStatement(str);
        		stmt.setString(1, exeName);
        		
        		ResultSet rs = stmt.executeQuery();
        			rs.next();
        				idKey=rs.getInt(1);
        				System.out.println("ExerciseWightUpdated");
        			
        		}
        		
        		catch (Exception ex) 
            	{
                    System.out.println(ex);
            	}
        		
        	DisConnect();
        	
        		return idKey;
        	}
        	
    	
    	///////////////----------------Used in HandleAClient to update the Exercise Weight
    	public static void UpdateExerciseWeight(String idUser,int idKey,double weightToUpdate)
    	{
    		
    		Connect();
    		
    		//String tableUptadeValeu;
    		//tableUptadeValeu=Double.toString(weightToUpdate);
    	
    		str= "UPDATE UsersAndProgram SET ExerciseWeight="+weightToUpdate+" WHERE UserIDKey = '"+idUser+"' AND ExerciseKey= '"+idKey+"' ";
    		try
    		{
				stmt= con.prepareStatement(str);
				stmt.executeUpdate();
				
				System.out.println("userWightUpdated");				
			} 
    		
    		catch (SQLException e) 
    		{
				
				e.printStackTrace();
			}
    		
    		DisConnect();
    		
    	}
    	
    	///////////////----------------Used in HandleAClient
    	public static void UpdateUserWeight(String idUser,double weightToUpdate)
    	{
    		
    		Connect();
    		
    		//String tableUptadeValeu;
    		//tableUptadeValeu=Double.toString(weightToUpdate);
    		
    		str= "UPDATE USERSLK SET DataWeight="+weightToUpdate+" WHERE DataID = '"+idUser+"' ";
    		try
    		{
				stmt= con.prepareStatement(str);
				stmt.executeUpdate();
				
			} 
    		
    		catch (SQLException e) 
    		{
				
				e.printStackTrace();
			}
    		
    		
    		DisConnect();
    		
    	}
    	
    	
	     	public  static  void  main(String[]  args)
	     	{
	     		Connect();
	     		//UserLK User=new UserLK("udi katz","319002374",20,"Male",187,75.8,"liorkatzzz","Gain",4,"No","Yes");
	     		//InsertNewUser(User);
	     		//UserLK obj=FindeUser("319002374","liorkatzzz");
	     		//System.out.println(obj.toString());
	     		
	     		//System.out.println(SQLquerys.GetExerciseByID(2));
	     		//System.out.println(SQLquerys.GetUserDataByID("319002374"));
	     		//ExerciseInsert("111111111", "ABC", "C", 3);
	     		//ProgramInsert("123123123", "ABC");
	     		//ProgramChosen(6, "666666666");
	     		
	     		//System.out.println(SQLquerys.GetIDKeyByExercise("Pullups"));
	     		
	     		UpdateExerciseWeight("319002374",2,66);
	     		
	     		UpdateUserWeight("319002374",66);
	     		
	     		DisConnect();

	           	}	

	}






