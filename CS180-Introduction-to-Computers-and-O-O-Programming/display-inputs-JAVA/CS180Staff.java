/**
 * Shadman Jubaer
 * This class defines methods that take instructor info as input 
 * and displays it in a neat table.
 **/

// Imports
import javax.swing.*;

// Class start
class CS180Staff {
  //Initialize variables
  private String firstName, lastName, email, office;
  //Take inputs
  void getDetails(){
    firstName = JOptionPane.showInputDialog(null,"Enter first name: ");
    lastName = JOptionPane.showInputDialog(null, "Enter last name: ");
    email = JOptionPane.showInputDialog(null, "Enter email: ");
    office = JOptionPane.showInputDialog(null, "Enter office: ");
  }
  //Print outputs
  void printNeatly(){
    System.out.println("    "+firstName+' '+lastName);
    System.out.println("    Email: "+email);
    System.out.println("    Office: "+office);
  }
}