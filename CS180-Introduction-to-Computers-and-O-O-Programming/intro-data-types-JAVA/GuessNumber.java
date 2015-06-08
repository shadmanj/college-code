/**
* Shadman Jubaer
* This program guesses a random number and takes user input
* until the correct number is guessed.
**/

import java.util.*;
import javax.swing.*;

public class GuessNumber {

	public static void main(String[] args){

		//Show user the directions
		JOptionPane.showMessageDialog(null,"I will pick a number between 1 an 100. Your job is to guess the number.");

		//Define variables
		int secret=-1, guess=0, counter=0; //secret is the computer guess
		boolean done = false; //Checks whether value was guessed
		Random random = new Random(); //Creates new random object
		
		//Generate random number between 1 and 10	
		while (secret < 0 || secret > 100){
			secret = random.nextInt(); //Set secret equal to random number
		}
		//JOptionPane.showMessageDialog(null, secret);

		//While not done, take user input and check with guess.
		while (!done){

			counter++;
			
			//Take user input
			guess  = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your guess."));
			
			//Check if guess equals the random number 
			if (guess == secret){
				done = true; //Set the check to true to break out of loop
				break;
			}

			//Check if guess too high
			else if (guess < secret){
				JOptionPane.showMessageDialog(null,"Your guess was too low.\n"+counter+" tries used.");
			}

			//Check if guess too low
			else if (guess > secret){
				JOptionPane.showMessageDialog(null,"Your guess was too high.\n"+counter+" tries used.");
			}
		}

		//Display victory message
		JOptionPane.showMessageDialog(null,"You guessed the correct number "+guess+"!\nIt took you "+counter+" tries.");
	}
}
