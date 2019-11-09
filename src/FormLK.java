import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.*;

public class FormLK extends JFrame implements ActionListener,FocusListener
{


	String Days[]={"2", "3","4","6"};
	
	JPanel  PnlMain,
			PnlUper,
			PnlMid,
			PnlLow,
			PnlQs,
			PnlQ1,
			PnlQ2,
			PnlQ3,
			PnlQ4,
			PnlNext;
	
	
	JLabel  LblFullName,
			LblID,
			LblAge,
			LblGender,
			LblHigh,
			LblWeight,
			LblPass,
			LblQ1,
			LblQ2,
			LblQ3,
			LblQ4;
	
	JTextField  TxtFullName,
				TxtID,
				TxtAge,
				TxtHigh,
				TxtWeight;
	
	JPasswordField PassTxt;
	
    JRadioButton BttMale,
				BttFemale,
				BttGain,
				BttLose,
				BttHoreandmore,
				BttLessthenhoure,
				BttHigh,
				BttRegular;
    
    ButtonGroup GrpButt,
    			GrpButt2,
    			GrpButt3,
    			GrpButt4;
    
    JButton NextButt; 
	
	JComboBox ComboDays;
	
	
	
	public  FormLK(String s)
	{
		super(s);
		PnlMain=new JPanel(new GridLayout(0,1));
		PnlUper=new JPanel(new GridLayout(0,2));
		PnlMid=new JPanel();
		PnlMid.setLayout(new FlowLayout() );
		PnlLow=new JPanel(new GridLayout(0,2));
		PnlQs=new JPanel(new GridLayout(4,0));
		PnlQ1=new JPanel(new FlowLayout());
		PnlQ2=new JPanel(new FlowLayout());
		PnlQ3=new JPanel(new FlowLayout());
		PnlQ4=new JPanel(new FlowLayout());
		PnlNext=new JPanel(new FlowLayout());
		
		//////////////////////////////////////////////////////
		
		
		//------------Uper Pannel ---------
		LblFullName=new JLabel("E-mail(used as User Name):", SwingConstants.RIGHT);
		TxtFullName=new JTextField(20);
		PnlUper.add(LblFullName);
		PnlUper.add(TxtFullName);
		TxtFullName.addFocusListener(this);
		
		LblID=new JLabel("ID:", SwingConstants.RIGHT);
		TxtID=new JTextField(10);
		PnlUper.add(LblID);
		PnlUper.add(TxtID);
		TxtID.addFocusListener(this);
		
		LblAge=new JLabel("Age:", SwingConstants.RIGHT);
		TxtAge=new JTextField(10);
		PnlUper.add(LblAge);
		PnlUper.add(TxtAge);
		TxtAge.addFocusListener(this);
		
		//////////////////////////////////////////////////////
		
		//------------Mid Pannel ---------
		LblGender=new JLabel("Gender:");
		BttMale=new JRadioButton("Male");
		BttFemale=new JRadioButton("Female");
		PnlMid.add(LblGender);
		//PnlMid.add(Box.createRigidArea(new Dimension(10, 0)));
		PnlMid.add(BttMale);
		//PnlMid.add(Box.createRigidArea(new Dimension(10, 0)));
		PnlMid.add(BttFemale);
		
		GrpButt= new ButtonGroup();
		GrpButt.add(BttMale);
		GrpButt.add(BttFemale);
		//////////////////////////////////////////////////////
		
		//------------Low Pannel ---------
		LblHigh=new JLabel("High(cm):", SwingConstants.RIGHT);
		TxtHigh=new JTextField(10);
		PnlLow.add(LblHigh);
		PnlLow.add(TxtHigh);
		
		LblWeight=new JLabel("Weight(kg):", SwingConstants.RIGHT);
		TxtWeight=new JTextField(10);
		LblWeight.setPreferredSize((new Dimension(10, 0)));
		PnlLow.add(LblWeight);
		PnlLow.add(TxtWeight);
		
		LblPass=new JLabel("Password", SwingConstants.RIGHT);
		PassTxt=new JPasswordField(10);
		PnlLow.add(LblPass);
		PnlLow.add(PassTxt);
		
		//////////////////////////////////////////////////////
		
		//------------Q's Pannel ---------
		
		//------------Q1 Pannel ---------
		LblQ1=new JLabel("Do you want to gain weight or lose weight?");
		BttGain= new  JRadioButton("Gain");
		BttLose= new  JRadioButton("Lose");		
		PnlQ1.add(LblQ1);
		PnlQ1.add(BttGain);
		PnlQ1.add(BttLose);
		
		GrpButt2= new ButtonGroup();
		GrpButt2.add(BttGain);
		GrpButt2.add(BttLose);
		
		//------------Q2 Pannel ---------
		LblQ2=new JLabel("How many days a week can you allocate for traning?");
		ComboDays=new JComboBox(Days);
		PnlQ2.add(LblQ2);
		PnlQ2.add(ComboDays);
		
		//------------Q3 Pannel ---------
		LblQ3=new JLabel("Would u like to do cardio?");
		BttHoreandmore=new JRadioButton("Yes");
		BttLessthenhoure=new JRadioButton("No");
		PnlQ3.add(LblQ3);
		PnlQ3.add(BttHoreandmore);
		PnlQ3.add(BttLessthenhoure);
		
		GrpButt3= new ButtonGroup();
		GrpButt3.add(BttHoreandmore);
		GrpButt3.add(BttLessthenhoure);
		
		//////////////////////////////////////////////////////
		//------------Button Pannel ---------
		NextButt=new JButton("NEXT>>>");
		PnlNext.add(NextButt);		
		NextButt.addActionListener(this);

		//////////////////////////////////////////////////////
		
		PnlMain.add(PnlUper);
		PnlMain.add(PnlMid);
		PnlMain.add(PnlLow);
		PnlMain.add(PnlNext);
		
		PnlQs.add(PnlQ1);
		PnlQs.add(PnlQ2);
		PnlQs.add(PnlQ3);

		
		
		
		setContentPane(PnlMain);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(400,300);
		setVisible(true);
		
		
	}
	
	String getSelectedButtonText(ButtonGroup buttonGroup) {
	    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) 
	    {
	        AbstractButton button = buttons.nextElement();

	        if (button.isSelected()) {
	            return button.getText();
	        }
	    }

	    return null;
	}
	
	public static void main(String args[])
	{
		FormLK obj=new FormLK("Register");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if((e.getActionCommand().equals("NEXT>>>")&&InputChecks.InputCheckID(TxtID.getText())&&InputChecks.InputCheckAge(TxtAge.getText())&&InputChecks.InputCheckRadio(BttMale,BttFemale)&&InputChecks.InputCheckHigh(TxtHigh.getText())&&InputChecks.WeightInputCheck(TxtWeight.getText())))
		{
		 PnlMain.removeAll();
		 NextButt.setText("-Submit-");
		 PnlMain.add(PnlQs);
		 PnlQs.add(NextButt);
		 validate();
		}
		
		else{
					
				if(InputChecks.InputCheckID(TxtID.getText())==false)
				{
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null, "ID must contain 9 digits", "ID Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
				}
							
				if(InputChecks.InputCheckAge(TxtAge.getText())==false)
				{
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null, "invalid Age  ", "Age Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
			   	}
														 
				if(InputChecks.InputCheckRadio(BttMale,BttFemale)==false)
				{
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null, "Chose Gender  ", "Gender Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
				}
														    
									
				if(InputChecks.InputCheckHigh(TxtHigh.getText())==false)
				{
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null, "invalid High  ", "High Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
																	
				}
				
				if(InputChecks.WeightInputCheck(TxtWeight.getText())==false)
				{
					Object[] options = { "OK" };
					JOptionPane.showOptionDialog(null, "invalid Weight  ", "Weight Error",
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[0]);
				}
				
																						
									
			else 
			{
				if((e.getActionCommand().equals("-Submit-"))&&InputChecks.InputCheckRadio(BttGain,BttLose)&&InputChecks.InputCheckRadio(BttHoreandmore,BttLessthenhoure))
					{
					
					
					
					   int selection;
					   String[] options;
					   options=new String[2];
					   
					   options[0]="Yes";
					   options[1]="No";
					   
					   selection=JOptionPane.showOptionDialog(null, "Do you have any health issues?", "Before we start...", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, "No");
					   System.out.println(options[selection]);

					
					
						UserLK User=new UserLK(TxtFullName.getText(),
												TxtID.getText(),
												Integer.parseInt(TxtAge.getText()),
												getSelectedButtonText(GrpButt),
												Integer.parseInt(TxtHigh.getText()),
												Double.parseDouble(TxtWeight.getText()),
												new String(PassTxt.getPassword()),
												getSelectedButtonText(GrpButt2),
												Integer.parseInt(Days[ComboDays.getSelectedIndex()]),
												getSelectedButtonText(GrpButt3),
												options[selection]); 
						SQLquerys.Connect();
						SQLquerys.InsertNewUser(User);
						SQLquerys.ProgramChosen(Integer.parseInt(Days[ComboDays.getSelectedIndex()]),TxtID.getText());
						SQLquerys.DisConnect();
					

						
					}
				else{
					
					if(InputChecks.InputCheckRadio(BttGain,BttLose)==false)
					{
						Object[] options = { "OK" };
						JOptionPane.showOptionDialog(null, "Choose if u would like to Gain or Lose Weight ", "Error",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options, options[0]);
					}
								
					if(InputChecks.InputCheckRadio(BttHoreandmore,BttLessthenhoure)==false)
					{
						Object[] options = { "OK" };
						JOptionPane.showOptionDialog(null, "Choose if u would like to do cardio or not ", "Error",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options, options[0]);
				   	}
															 
				}
						
			}
		}
			}
			
		
	
	 private void DisConnect() {
		// TODO Auto-generated method stub
		
	}

	private void Connect() {
		// TODO Auto-generated method stub
		
	}

	public void focusGained(FocusEvent e) {
	        if(e.getSource()==TxtFullName)
	        	TxtFullName.setToolTipText("enter Email");
	    }
	 public void focusLost(FocusEvent e) {
	       // displayMessage("Focus lost", e);
	    }
		
	
}




