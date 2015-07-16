/**
* Shadman Jubaer
* This code utilizes the Student class to create a class roster
*/

import javax.swing.*;
import java.util.*;


public class Roster {

	public static void main(String[] args){
		String[] years = {"Freshman", "Sophomore","Junior","Senior","Super Senior"};
		String windowTitle = "Class Roster";
		String inputPrompt = "Enter the number of students to be added.";
		String name;
		double gpa;
		String year;
		
		int numberToAdd = Integer.parseInt(JOptionPane.showInputDialog(null,
			inputPrompt,windowTitle,JOptionPane.QUESTION_MESSAGE));

		Student[] roster = new Student[numberToAdd];
		
		for(int i = 0; i < numberToAdd; i++){
			roster[i] = new Student();
			roster[i].setName(JOptionPane.showInputDialog(null,
				"Name: ",windowTitle,JOptionPane.QUESTION_MESSAGE));
			roster[i].setGPA(Double.parseDouble(JOptionPane.showInputDialog(null,
				"GPA: ",windowTitle,JOptionPane.QUESTION_MESSAGE)));
			year = (String)JOptionPane.showInputDialog(null,
				"Enter year in college",windowTitle,JOptionPane.QUESTION_MESSAGE,null,years,null);
			roster[i].setYear(year);
		}

		printRoster(roster);
	}

	public static void printRoster(Student[] roster){
		for(int i = 0; i < roster.length;i++){
			System.out.println(roster[i].getName());
			System.out.println(roster[i].getGPA());
			System.out.println(roster[i].getYear());
			System.out.println('\n');
		}
	}
}