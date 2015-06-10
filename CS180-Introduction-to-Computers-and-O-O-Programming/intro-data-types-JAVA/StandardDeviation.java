/**
* Shadman Jubaer
* This program takes inputs from the user and 
* outputs mean and standard deviation.
**/

import java.util.*;
import javax.swing.*;

public class StandardDeviation {

	public static void main(String[] args){

		//Array index
		int i;
		//Array
		double data[];
		//Number of data points
		int n;

		//Ask user how many points will be input
		n = Integer.parseInt(JOptionPane.showInputDialog(null,"How many data points will there be?"));

		data = new double[n]; //Define array size

		//Take inputs
		int display;
		for (i = 0; i < n; i++){
			display = i + 1;
			data[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter value "+display));
		}

		//Calculate Sum
		double sum = 0.0;
		for (i = 0; i < n; i++){
			sum += data[i];
		}

		double average = sum / n; //Find Average

		//Calculate variance sum
		double varianceSum = 0;
		for (i = 0; i < n; i++){
			varianceSum += Math.pow(data[i] - average,2);
		}

		//Calculate standard deviation
		double variance = varianceSum / n;
		double standardDeviation = Math.sqrt(variance);

		//Output results
		JOptionPane.showMessageDialog(null, "The mean is "+average+"\nThe standard deviation is "+standardDeviation);

	}
}