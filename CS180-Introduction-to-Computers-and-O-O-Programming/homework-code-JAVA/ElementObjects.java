/**
 * Shadman Jubaer
 * This program uses the ElementIO class to take element info and print them 
 * to the screen.
 **/

//Imports
import java.util.*;

//Class
class ElementObjects{
  
  //Main
  public static void main(String[] args){
    
    //Initialize objects
    ElementIO element1, element2;
    
    //Take inputs
    element1 = new ElementIO();
    element1.getElementInfo();
    
    element2 = new ElementIO();
    element2.getElementInfo();
    
    //Display outputs
    element1.showElementInfo();
    element2.showElementInfo();
  }
}