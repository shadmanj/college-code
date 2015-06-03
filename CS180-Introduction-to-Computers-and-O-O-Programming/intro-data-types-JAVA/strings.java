/*
 * Shadman Jubaer
 * This program plays around with strings and substrings in the String class
 */

class strings {
  public static void main(String[] args) {
    String name;
    name = new String("Shadman");
    System.out.println("My name: " + name);
    String text;
    text = "Purdue";
    System.out.println("My school: " + text);
    System.out.println("First 3 letters of my name: " + name.substring(0,3));
    System.out.println("The length of my school's name: " + text.length());
    System.out.println("The last 3 letters of my school: "+ text.substring(3,6));
    System.out.println("The index of the last line: " + text.indexOf(text.substring(3,5)));
    String concatenated = name.substring(0,3) + text.substring(3,6);
    System.out.println("First 3 letters of my name + last three letters of school: " + concatenated);
  }
}