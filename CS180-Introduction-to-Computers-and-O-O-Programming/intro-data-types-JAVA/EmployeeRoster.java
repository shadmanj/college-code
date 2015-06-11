/**
* Shadman Jubaer
* This program uses the employee class to input and display 
* pay information for a number of employees over a 10 day pay period.
**/

import java.util.*;
import javax.swing.*;

class EmployeeRoster{

	public static void main(String[] args){

		Employee[] employee;
		employee = initializeRoster();

		for(int i=0; i < employee.length; i++){
			employee[i].printNeatly();
		}
	}

	public static Employee[] initializeRoster(){

		Employee[] em;		
		int numEmployees, i, payPeriod;
		numEmployees = Integer.parseInt(JOptionPane.showInputDialog(null,
			"How many employees to enter?"));
		
		em = new Employee[numEmployees];
		
		//Set pay period
		payPeriod = Integer.parseInt(JOptionPane.showInputDialog(null,
			"Set number of days in pay period:"));
		
		for(i = 0; i < numEmployees; i++){
			int display = i+1;
			em[i] = new Employee();
			em[i].setName(JOptionPane.showInputDialog(null,
				"Set employee "+display+" name."));
			em[i].setNumber(JOptionPane.showInputDialog(null,
				"Set "+em[i].getName()+"'s employee number."));
			em[i].setPayPeriod(payPeriod);
			em[i].totalHours();
		}
		return em;
	}
}