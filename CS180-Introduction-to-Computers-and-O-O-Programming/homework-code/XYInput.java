/**
 * Shadman Jubaer
 * This program takes an x and y input from the keyboard and prints the 
 * sum, product, quotient, and remainder of x and y.
 **/

//Imports
import java.util.*;

//Start class
class XYInput {
  public static void main(String[] args){
  //Initialize variables
  Scanner scanner;
  int x, y, sum, product, remainder;
  double quotient;
  
  //Take inputs
  scanner = new Scanner(System.in);
  System.out.println("Enter the x value: ");
  x = scanner.nextInt();
  System.out.println("Enter the y value: ");
  y = scanner.nextInt();
  
  //Perform calculations
  sum = x + y;
  product = x * y;
  remainder = x % y;
  quotient = x / (y*1.0); //Cast the denominator as a float to get noninteger result
  
  //Print outputs
  System.out.print("The sum is: " + sum + '\n');
  System.out.print("The product is: " + product + '\n');
  System.out.print("The quotient is: " + quotient + '\n');
  System.out.print("The remainder is: " + remainder + '\n');
  System.out.print("DONE\n");

  }
}