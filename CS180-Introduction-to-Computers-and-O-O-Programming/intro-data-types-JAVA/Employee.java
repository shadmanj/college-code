/**
* Shadman Jubaer
* This file creates an Employee object for a company
**/

import java.util.*;
import javax.swing.*;

class Employee{

	private String name, employeeNumber;
	private int day[];
	private int hours,payPeriod;	//Number of hours worked

	//Define employee
	public void Employee(){
		int i;

		//Take employee name and number
		name = JOptionPane.showInputDialog(null,"Enter employee name:");
		employeeNumber = JOptionPane.showInputDialog(null,
			"Enter employee number:");
		
		//Input hours for pay period
		payPeriod = Integer.parseInt(JOptionPane.showInputDialog(null,
			"Enter number of days in pay period."));
		day = new int[payPeriod];
		for(i = 0; i < payPeriod; i++){
			day[i] = Integer.parseInt(JOptionPane.showInputDialog(null,
				"Hours worked on day "+(i+1)));
		}

		hours = 0;
	} 

	/* Retrieve employee information*/

	//Print employee information
	public void printNeatly(){
		System.out.println("\n");
		System.out.println("    "+name);
		System.out.println("    Number: "+employeeNumber);
		System.out.println("    Hours:  "+hours+"\n");
	}

	//Set employee data
	public void setName(String employeeName){
		name = employeeName;
	}

	public void setNumber(String number){
		employeeNumber = number;
	}

	public Integer totalHours(){
		int i;
		for(i = 0; i < payPeriod; i++){
			int display = i+1;
			hours+= Integer.parseInt(JOptionPane.showInputDialog(null,
			 	"Enter number of hours "+name+" worked on day "+display));
		}
		return hours;
	}

	public void setPayPeriod(Integer daysOfPay){
		payPeriod = daysOfPay;
	}

	//Retrieve employee name
	public String getName(){
		return name;
	}

	//Retrieve employee number
	public String getNumber(){
		return employeeNumber;
	}
}