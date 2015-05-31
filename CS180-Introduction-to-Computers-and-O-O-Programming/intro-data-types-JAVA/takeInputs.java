/**
 * Shadman Jubaer
 * This program the user's name, then greets and insults the user by name.
 **/

import java.util.*;

class takeInputs {
  public static void main(String[] args) {
    Scanner scanner;
    String firstName, lastName;
    scanner = new Scanner(System.in);
    System.out.print("Enter your first and last name:\n");
    firstName = scanner.next();
    lastName = scanner.next();
    System.out.print("\n\nHello " + firstName +' ' + lastName + ".\n");
    System.out.print("\nYou are an ugly goat!\n\n");
  }
}