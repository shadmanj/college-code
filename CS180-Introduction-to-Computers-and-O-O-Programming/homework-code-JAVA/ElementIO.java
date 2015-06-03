/**
 * Shadman Jubaer
 * This program creates two chemical element objects.
 * Inputs: Element name, symbol, atomic number, atomic mass
 * Outputs: Extract and display object names and symbols
 **/

//Imports
import java.util.*;

//Class
class ElementIO {
  
  //Initialize variables
  private String name, symbol, atomicNumber, atomicMass;
  
  //Gets Inputs
  void getElementInfo(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Element name: ");
    name = sc.next();
    System.out.println("Element symbol: ");
    symbol = sc.next();
    System.out.println("Atomic number of " + name + ':');
    atomicNumber = sc.next();
    System.out.println("Atomic mass of "+ name + ':');
    atomicMass = sc.next();
  }
  
  //Extract and display element information
  void showElementInfo(){
    System.out.println("Element name:    " + name);
    System.out.println("Element symbol:  " + symbol);
    System.out.println("Atomic number:   " + atomicNumber);
    System.out.println("Atomic mass:     " + atomicMass);
    System.out.println("DONE\n");
  }
}