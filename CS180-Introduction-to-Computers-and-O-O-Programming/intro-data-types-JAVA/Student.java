/**
* Shadman Jubaer
* This program makes a Student object which sotres 
* name, ID, and GPA.
**/

import java.util.*;
import javax.swing.*;

class Student {
	private String name, id;
	private double gpa;

	public void Student(){
		name = JOptionPane.showInputDialog(null,"Enter student full name");
		id = JOptionPane.showInputDialog(null, "Enter student id");
		gpa = 0.0;
	}

	public void printNeatly(){
		System.out.println("    "+name);
		System.out.println("    ID: "+id);
		System.out.println("    GPA: "+gpa+"\n\n");
	}

	public void setName(String studentName){
		name = studentName;
	}

	public String getName(){
		return name;
	}

	public String getID(){
		return id;
	}

	public Double getGPA(){
		return gpa;
	}

	public void setGPA(double g){
		gpa = g;
	}
}