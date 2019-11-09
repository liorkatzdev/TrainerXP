import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.JTableHeader;


public class MainApp extends JFrame
{
	
	JPanel PnlUser,
		   PnlPlanName,
		   PnlUpper,
		   PnlProgramExplanation,
		   PnlBottonExplain,
		   PnlExTable,
		   PnlBottonAndRun,
		   PnlDiet,
		   PnlMain;
	
	JLabel LblLogo,
	 	   LblUser,
		   LblProgram,
		   LblHealthIss,
		   LblIcone,
		   LblProgramExplanation,
		   LblBottonChangeWhenPress,
		   LblRunning,
		   LblDiet,
		   LblUserWeight,
		   LblUserWeightNum,
		   LblCaloriesPerDay,
		   LblCaloriesPerDayNum,
		   LblProteinsPerDay,
		   LblProteinsPerDayNum,
		   Lblspace,
		   LblChangeUserWe;
	
	
	
	
	
	JTable table;
	
	JTextField TxtUserWeight;
	
	JButton bttNextSession;
	
	AllUserData userData;
	
	Client client;
	 
	
	int style = Font.BOLD | Font.ITALIC;

	Font font = new Font ("TimesRoman", Font.BOLD, 14);
	
	
	public MainApp()
	{
		
		
		
		String userid=JOptionPane.showInputDialog("insert user id:");
		
		client=new Client();
		
		
		
		//userData=AllUserData.CreatAllUserDataSemple();
		userData=new AllUserData();
		userData.setId(userid);
		
		client.writeToServer(userData);
		userData=client.readFromServer();
		
		
		PnlMain=new JPanel(new GridLayout(0,1));
		PnlUser=new JPanel(new FlowLayout());
		PnlPlanName=new JPanel();
		PnlUpper=new JPanel(new BorderLayout());
		PnlProgramExplanation=new JPanel();
		PnlBottonExplain=new JPanel(new BorderLayout());
		PnlExTable=new JPanel(new BorderLayout());
		PnlBottonAndRun=new JPanel(new GridLayout(1,2));
		PnlDiet=new JPanel(new GridLayout(2,4));
		
		////////////////////////////////////////////////////////////////////////////////
		
		//------------PnlUser ---------
		
		LblLogo=new JLabel(new ImageIcon("images/gym.png"));
		PnlUser.add(LblLogo);
		
		LblUser=new JLabel("           User:");
		LblUser.setFont(font);
		PnlUser.add(LblUser);
		
		LblUser.setBackground(Color.WHITE);
		LblUser.setOpaque(true);
		
		PnlUser.setBackground(Color.WHITE);
		PnlUser.setOpaque(true);
		
		LblProgram=new JLabel("    |   Training program:");
		LblProgram.setFont(font);
		
		
		PnlUser.add(LblProgram);
		
		LblProgram.setBackground(Color.WHITE);
		LblProgram.setOpaque(true);
		
		LblHealthIss=new JLabel("");
        if(userData.getHealthIssues().equals("Yes"))
        {
        	LblHealthIss.setText("   |   There are some health issues, consult with a trainer before each workout");
        	LblHealthIss.setFont(font);
        	LblHealthIss.setForeground(Color.RED);
        }
        
        PnlUser.add(LblHealthIss);
        
        LblHealthIss.setBackground(Color.WHITE);
        LblHealthIss.setOpaque(true);
		
		
		////////////////////////////////////////////////////////////////////////////////
		
		
		//------------ PnlProgramExplanation ---------
		//LblProgramExplanation=new JLabel("Program Explanation");
        LblProgramExplanation=new JLabel();
		LblProgramExplanation.setFont(font);
		PnlProgramExplanation.add(LblProgramExplanation);
		PnlProgramExplanation.setBackground(Color.WHITE);
		
		LblProgramExplanation.setBackground(Color.white);
		LblProgramExplanation.setOpaque(true);
		
		////////////////////////////////////////////////////////////////////////////////
		
		//------------Botton Expanation Pannel ---------
		LblBottonChangeWhenPress=new JLabel(new ImageIcon("images/pressToChange.png"));
		PnlBottonExplain.add(LblBottonChangeWhenPress, BorderLayout.EAST);
		
		LblBottonChangeWhenPress.setBackground(Color.white);
		LblBottonChangeWhenPress.setOpaque(true);
		
		
		LblBottonChangeWhenPress.setBackground(Color.white);
		PnlBottonExplain.setBackground(Color.white);
		////////////////////////////////////////////////////////////////////////////////
		
		
		//------------ PnlExTable ---------
		Vector <String[]> columns = new Vector<String[]> ();
	         
		columns.add(new String[]{"Exercises Name", "Muscle", "Technique Video", "Sets X Repeats","Rest between sets(sec)","Weight"});
		
	    //Vector <Exercise> data= new Vector<Exercise>();
	    
	    
        //table = new JTable(data, columns);
	     //table =new JTable(InsertXerciseToTable(AllUserData.CreateExerciseVectorSample()), new String[]{"Exercises Name", "Muscle", "Technique Video", "Sets X Repeats","Rest between sets(sec)","Weight"}) ;
	     table =new JTable(InsertXerciseToTable(userData.getExercise()), new String[]{"Exercises Name", "Muscle", "Technique Video", "Sets X Repeats","Rest between sets(sec)","Weight"}) ;   

	    
	     //add the table to the frame
        PnlExTable.add(new JScrollPane(table), BorderLayout.CENTER);
        
        // makes the table non-editable for the user
        table.setEnabled(false);
        
        //disable user column dragging
        table.getTableHeader().setReorderingAllowed(false);
        
        
        //change table font
        
        JTableHeader header = table.getTableHeader();
        header.setFont(font);
        header.setForeground(Color.BLUE);
        
        table.setFont(font);
        
        
       
        ///////////----Update User's exercise's weight
        table.addMouseListener(new MouseAdapter()
        {
        	public void mousePressed(MouseEvent e)
        	{
        		
        		int row=table.rowAtPoint(e.getPoint());
        		int col= table.columnAtPoint(e.getPoint());
        		
        		//check if the cell the user clicked on its the weight cell only
        		if(col==5)
        		{
        			
        		String check;
        		check=(JOptionPane.showInputDialog("Update "+table.getValueAt(row, 0)+"'s weight:"));
        		
        			//check Input
        			if(check==null)
        				return;
        				if(!check.equals("")&&InputChecks.WeightInputCheck(check))
        					{
        							//update the exercis weight
        							//Save the User Name and User's Gender to change it after the object came from the Server
        							String strUserNameTemp=userData.getUserName();
        							String strGenderTemp=userData.getUserGender();
        							
        							table.setValueAt(check, row, col);
        							userData.getExercise().get(row).setWeight(Double.parseDouble(check));
        							
        							//the things i send to the Server
        							userData.setUserName("UpdateExerciseWeight "+userData.getExercise().get(row).getExerciseName());
        							userData.setUserGender(check);
        							
        							client.writeToServer(userData);
        							
        							//bring back the values to the userData
        							userData.setUserName(strUserNameTemp);
        							userData.setUserGender(strGenderTemp);
        							
        							
        							System.out.println(userData.getExercise().get(row).toString());		
        					}
        				else
        					JOptionPane.showMessageDialog(null, "Invalid weight", "Error", JOptionPane.ERROR_MESSAGE);
        		
        		}
        	}
        		
        });
        
        


		////////////////////////////////////////////////////////////////////////////////
        //------------ PnlBottonAndRun ---------
        LblRunning=new JLabel("");
        if(userData.getRunning().equals("Yes"))
        {
        	LblRunning.setText("Run jogging on a treadmill for 15 minutes");
        	LblRunning.setFont(font);
        }
        
        LblRunning.setBackground(Color.WHITE);
        LblRunning.setOpaque(true);
        
        PnlBottonAndRun.add(LblRunning);
        
        bttNextSession=new JButton(new ImageIcon(""));
        bttNextSession.setBorder(BorderFactory.createEmptyBorder());
        bttNextSession.setContentAreaFilled(false);
        
        bttNextSession.setBackground(Color.WHITE);
        bttNextSession.setOpaque(true);
        
        PnlBottonAndRun.add(bttNextSession);
        
        PnlBottonAndRun.setBackground(Color.WHITE);
        
        ////////////////////////////////////////////////////////////////////////////////
	    //------------ PnlDiet ---------	
        TitledBorder t=new TitledBorder("Diet");
	     PnlDiet.setBorder(t); 
	     
	     ((javax.swing.border.TitledBorder) PnlDiet.getBorder()).
	        setTitleFont(font);

	     PnlDiet.repaint();
	   
	     
	     
	     LblCaloriesPerDay= new JLabel("Calories Per Day:");
	     LblCaloriesPerDay.setFont(font);
	     LblCaloriesPerDayNum= new JLabel("");
	     LblCaloriesPerDayNum.setFont(font);
	     
	     
	     LblProteinsPerDay= new JLabel("Proteins Per Day:");
	     LblProteinsPerDay.setFont(font);
	     LblProteinsPerDayNum= new JLabel("");
	     LblProteinsPerDayNum.setFont(font);
	     
	     
	     LblUserWeight= new JLabel("User's Weight:");
	     LblUserWeight.setFont(font);
	     LblUserWeightNum= new JLabel("");
	     LblUserWeightNum.setFont(font);
	     
	     
	     Lblspace=new JLabel("");
	     Lblspace.setFont(font);
	     LblChangeUserWe=new JLabel(new ImageIcon("images/To change Weight press User's Weight.png"));
	     PnlDiet.add(LblChangeUserWe, BorderLayout.EAST);
	     
	     
	     ///////////----Update User's weight
	     LblUserWeight.addMouseListener(new MouseAdapter() 
	     {
	    	 
	    	 public void mousePressed(MouseEvent e)
	    	 {
	    		String check;
	    		check=(JOptionPane.showInputDialog("Enter new weight:"));
	    		
	    		if(check==null)
	    			return;
	    		
	    		//check Input
	    		 if(!check.equals("")&&InputChecks.WeightInputCheck(check))
	    		 {
	    			 LblUserWeightNum.setText(check); 
	    			 
	    			 //Save the User Name to change it after the object came from the Server
	    			 String strUserNameTemp=userData.getUserName();
	    			 
	    			 // Update user's new weight
	    			 userData.setCurrentWeight(Double.parseDouble(check));
	    			 
	    			 LblCaloriesPerDayNum.setText(Integer.toString((int) userData.getCaloriesPerDay()));
	    			 LblProteinsPerDayNum.setText(Double.toString((int)userData.getProteinPerDay()));
	    			 
	    			 //change the User name for the HandleAClient to know to change the User Weight
	    			 userData.setUserName("UpdateUserWeight");
	    			 
	    			 
	    			 client.writeToServer(userData);
	    			 
	    			 userData.setUserName(strUserNameTemp);
	    			 
	    		 }	 
	    		 else
	    			 JOptionPane.showMessageDialog(null, "Invalid weight", "Error", JOptionPane.ERROR_MESSAGE);
	    	 }
	    	 
		});
	     
	     
	     LblCaloriesPerDay.setBackground(Color.WHITE);
	     LblCaloriesPerDay.setOpaque(true);
	     
	     LblProteinsPerDay.setBackground(Color.WHITE);
	     LblProteinsPerDay.setOpaque(true);
	     
	     LblUserWeight.setBackground(Color.WHITE);
	     LblUserWeight.setOpaque(true);
	     
	     Lblspace.setBackground(Color.WHITE);
	     Lblspace.setOpaque(true);
	     
	     
	     PnlDiet.add(LblCaloriesPerDay);
	     PnlDiet.add(LblProteinsPerDay);
	     PnlDiet.add(LblUserWeight);
	     PnlDiet.add(LblChangeUserWe);
	     
	     
	     PnlDiet.add(LblCaloriesPerDayNum);
	     PnlDiet.add(LblProteinsPerDayNum);
	     PnlDiet.add(LblUserWeightNum);
	     PnlDiet.add(Lblspace);
	     
	     LblCaloriesPerDayNum.setBackground(Color.WHITE);
	     LblCaloriesPerDayNum.setOpaque(true);
	     
	     LblProteinsPerDayNum.setBackground(Color.WHITE);
	     LblProteinsPerDayNum.setOpaque(true);
	     
	     LblUserWeightNum.setBackground(Color.WHITE);
	     LblUserWeightNum.setOpaque(true);
	     
	     LblChangeUserWe.setBackground(Color.WHITE);
	     LblChangeUserWe.setOpaque(true);
	     
	     
	     PnlDiet.setBackground(Color.WHITE);
	     PnlDiet.setOpaque(true);
	     
	        
	    ////////////////////////////////////////////  
		
		PnlUpper.add(PnlUser, BorderLayout.CENTER);
		//PnlUpper.add(PnlPlanName,BorderLayout.EAST);
		//PnlPlanName.
		PnlUpper.setBackground(Color.WHITE);
		
		
		PnlMain.add(PnlUpper);
		PnlMain.add(PnlProgramExplanation);
		PnlMain.add(PnlBottonExplain);
		PnlMain.add(PnlExTable);
		PnlMain.add(PnlBottonAndRun);
		PnlMain.add(PnlDiet);
		
		PnlMain.setBackground(Color.white);
		
		
		setContentPane(PnlMain);
		
		
		//LoudAllUser -Loud put all the details to the screen
		LoudAllUser(userData);
		
		SendMailSSL mail=new SendMailSSL("progegym72@gmail.com","72progegym");

		mail.sendMail("progegym72@gmail.com", userData.getUserName(), "gym - your excersices", twoDimArrayPrint(InsertXerciseToTable(userData.getExercise())));		
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		pack();
		setVisible(true);
		
		
		
	}
		   
		   
	public static void main(String args[])
	{
		MainApp obj=new MainApp();
	}
	
	
	public  void LoudAllUser(AllUserData alluser)
	{
		LblUser.setText(LblUser.getText()+alluser.getUserName());
		
		LblProgram.setText(LblProgram.getText()+alluser.getProgramName());
		
		LblProgramExplanation.setText(LblProgramExplanation.getText()+alluser.getProgramExplanation());
		
		LblCaloriesPerDayNum.setText(Integer.toString((int) alluser.getCaloriesPerDay()));
		
		LblProteinsPerDayNum.setText(Double.toString((int)alluser.getProteinPerDay()));
		
		LblUserWeightNum.setText(Double.toString(alluser.getCurrentWeight()));
			
	}
	
	
	public static String[][] InsertXerciseToTable(Vector<Exercise> exercise)
	{
		
		String exeTable[][]=new String[exercise.size()][6];
		
		for(int i=0; i<exercise.size(); i++)
		{ 
				exeTable[i][0] =  exercise.get(i).getExerciseName();
				exeTable[i][1] =  exercise.get(i).getMuscle();
				exeTable[i][2] =  exercise.get(i).getTechLink();
				exeTable[i][3] =  exercise.get(i).getSetsxReps();
				exeTable[i][4] =  Integer.toString((int)exercise.get(i).getRest());
				exeTable[i][5] =  Double.toString(exercise.get(i).getWeight());
		}
		
		return exeTable;
	}
	
	
	//make the Exercise array to String to send it to the User's Email
	public String twoDimArrayPrint(String[][] array)
	{
		StringBuffer result = new StringBuffer();
		String separator = ", ";
		for (int i = 0; i < array.length; i++)
		{
		  result.append('[');
		  for (int j = 0; j < array[i].length; j++)
		    if (j > 0)
		      result.append(array[i][j]).append(separator);
		    else
		      result.append(array[i][j]).append(separator);
		  result.append("] \n \n");
		}
		return result.toString();
	}
}
