import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class UserLK 
{
	private String FullName;
	private String ID;
	private int Age;
	private String Gnder;
	private int High;
	private double Weight;
	private String Password;
	private String Q1;
	private int Q2;
	private String Q3;
	private String HealthIssues;
	

	public UserLK()
	{

	}

	
	public UserLK(String fullName, String iD, int age, String gnder, int high, double weight, String password,String q1, int q2, String q3,String healthissues) 
	{
		FullName = fullName;
		ID = iD;
		Age = age;
		Gnder = gnder;
		High = high;
		Weight = weight;
		Password = password;
		Q1 = q1;
		Q2 = q2;
		Q3 = q3;
		HealthIssues = healthissues;
	}

	
	public String getFullName() {
		return FullName;
	}


	public void setFullName(String fullName) {
		FullName = fullName;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public int getAge() {
		return Age;
	}


	public void setAge(int age) {
		Age = age;
	}


	public String getGnder() {
		return Gnder;
	}


	public void setGnder(String gnder) {
		Gnder = gnder;
	}


	public int getHigh() {
		return High;
	}


	public void setHigh(int high) {
		High = high;
	}


	public double getWeight() {
		return Weight;
	}


	public void setWeight(double weight) {
		Weight = weight;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getQ1() {
		return Q1;
	}


	public void setQ1(String q1) {
		Q1 = q1;
	}


	public int getQ2() {
		return Q2;
	}


	public void setQ2(int q2) {
		Q2 = q2;
	}


	public String getQ3() {
		return Q3;
	}


	public void setQ3(String q3) {
		Q3 = q3;
	}

	
	public String getHealthIssues() {
		return HealthIssues;
	}
	
	public void setHealthIssues(String healthissues) {
		HealthIssues = healthissues;
	}

	public String toString() {
		return "UserLK [FullName=" + FullName + ", ID=" + ID + ", Age=" + Age + ", Gnder=" + Gnder + ", High=" + High
				+ ", Weight=" + Weight + ", Password=" + Password + ", Q1=" + Q1 + ", Q2=" + Q2 + ", Q3=" + Q3 + ", Q4="
				 +"HealthIssues="+ HealthIssues + "]";
	}
	
	
	
}
