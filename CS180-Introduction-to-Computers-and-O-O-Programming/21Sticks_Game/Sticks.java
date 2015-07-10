/**
* Shadman Jubaer
* This is a game of 21 sticks. The player and computer take
* turns picking one or two sticks. The player who picks up 
* the last stick loses.
*/

import java.util.*;
import javax.swing.*;

class Sticks{

	public static void main(String[] args){

		/*Initialize sticks*/
		final int STICKS = 21;
		int sticksLeft = STICKS;

		/*Introduction*/
		String introMessage = "Welcome to 21 Sticks\nPick one or two sticks.\nThe player who picks up the last stick loses";
		String titleText = "21 Sticks";
		String namePrompt = "Please enter your name to begin";

		JOptionPane.showMessageDialog(null,
			introMessage,titleText,JOptionPane.INFORMATION_MESSAGE);

		//Prompt for name
		String userName = JOptionPane.showInputDialog(null,
			namePrompt, titleText, JOptionPane.QUESTION_MESSAGE);
		
		//String initializations 
		String introQuestion = "Do you want to go first?";
		String[] gameOptions = {"One", "Two", "Quit"};

		/*Game*/
		//Determine which player goes first.
		//Computer is always player 1, and user is always player -1.
		int currentPlayer;
		int playerOrder = JOptionPane.showConfirmDialog(null,
			introQuestion,titleText, JOptionPane.YES_NO_OPTION);
		if (playerOrder == JOptionPane.YES_OPTION)
			currentPlayer = -1;
		else
			currentPlayer = 1;

		//Begin game
		int subtractSticks;
		String sticksLeftText;
		String userText;
		String gameText;
		String computerTurn;
		while (sticksLeft > 1){
			sticksLeftText = "\nSticks left: "+Integer.toString(sticksLeft);
			userText = "Pick up one or two sticks "+userName+".";
			gameText = userText+'\n'+sticksLeftText;
			//Use Prompts on human player's turn
			if (currentPlayer==-1){
				subtractSticks = 1+JOptionPane.showOptionDialog(null,
					gameText,titleText,JOptionPane.PLAIN_MESSAGE,
					JOptionPane.QUESTION_MESSAGE, null, gameOptions,null);
				//Break if player quits the game
				if (subtractSticks == 3){
					sticksLeft = -1;
					break;
				}
				sticksLeft -= subtractSticks;
			}
			//Computer's turn
			else{
				if ((sticksLeft%2)==0){
					sticksLeft-=1;
					computerTurn = "The computer picked up 1 stick.";
				}
				else{
					sticksLeft-=2;
					computerTurn = "The computer picked up 2 sticks.";
				}
				sticksLeftText = "\nSticks left: "+Integer.toString(sticksLeft);
				JOptionPane.showMessageDialog(null,
					computerTurn+sticksLeftText,titleText,JOptionPane.INFORMATION_MESSAGE);
			}
			//Change Player
			currentPlayer *= -1;
		}

		//Game end
		if (sticksLeft==-1)
			JOptionPane.showMessageDialog(null,
				"You quit the game! ):",titleText,JOptionPane.INFORMATION_MESSAGE);
		else{
			if(currentPlayer==1)
				JOptionPane.showMessageDialog(null,
					"YOU WON!",titleText,JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null,
					"YOU LOST! TRY AGAIN NEXT TIME!",titleText,JOptionPane.INFORMATION_MESSAGE);
		}

	}
}