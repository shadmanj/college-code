/**
* Shadman Jubaer
* This code clreates a class roster.
**/

import java.util.*;
import javax.swing.*;

class Roster{

	public static void main(String[] args){

		Student[] student;
		int i;
		student = initializeRoster();
		for (i = 0; i < student.length; i++){
			student[i].printNeatly();
		}
	}

	public static Student[] initializeRoster(){

		Student[] st;
		int classSize, i;
		classSize = Integer.parseInt(JOptionPane.showInputDialog(null,"Number of student in class:"));
		st = new Student[classSize];
		for (i = 0; i < classSize; i++){
			st[i] = new Student();
		}
		return st;
	}
}