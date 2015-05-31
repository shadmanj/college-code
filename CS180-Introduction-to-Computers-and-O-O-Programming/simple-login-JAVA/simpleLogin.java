/**
 * Shadman Jubaer
 * This program aske the user to login with a password,
 * then saves a log of the date and time of login.
 **/

//Import statements
import javax.swing.*;
import java.util.*;

//Class
class simpleLogin {
  
  public static void main(String[] args){
    
    /*Variables used*/
    String username, password;
    Date today;
    
    /*Obtain username & password*/
    username = JOptionPane.showInputDialog(null, "Username: ");
    password = JOptionPane.showInputDialog(null, "Password: ");
    
    /*Obtain date*/
    today = new Date();
    
    /*Display output*/
    System.out.println(username + " attempted login at:\n" +today);
  }
}