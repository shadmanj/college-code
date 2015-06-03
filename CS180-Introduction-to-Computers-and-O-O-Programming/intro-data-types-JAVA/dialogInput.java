/**
 * Shadman Jubaer
 * This program takes input from the user using a dialog box.
 **/

import javax.swing.*;

class dialogInput {
  public static void main(String[] args){
    String name = JOptionPane.showInputDialog(null, "Enter your full name");
    System.out.println("Hello " + name);
  }
}