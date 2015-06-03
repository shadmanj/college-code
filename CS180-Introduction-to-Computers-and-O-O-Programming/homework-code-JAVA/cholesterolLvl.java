/**
 * Shadman Jubaer
 * This program tells the user how to interpret his/her cholestorol level
 * Input: cholesterol level
 * Output: advice
 **/

//Imports
import java.util.*;
import javax.swing.*;

//Class
class cholesterolLvl{
  
  public static void main(String[] args){
    
    //Initialize variables
    int level, desirable = 200, high = 240;
    
    //Take input
    level = Integer.parseInt(JOptionPane.showInputDialog("Enter your cholesterol level: "));
    
    //Display advice
    if (level < desirable){
      JOptionPane.showMessageDialog(null, "Your cholesterol level is good.");
    }
    else{
      if (level >= high){
        JOptionPane.showMessageDialog(null, "Your cholesterol level is too high.");
      }
      else{
        JOptionPane.showMessageDialog(null, "Your cholesterol level is mildly high.");
      }
    }
  }
}