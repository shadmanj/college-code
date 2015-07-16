/**
 * Shadman Jubaer
 * This code creates a class called Student to store student information
 */

import javax.swing.*;
import java.util.*;

public class Student {

 private String name;
 private String year;
 private double GPA;

 //Constructor method to set a new student
 public Student(){
  setName(name);
  setYear(year);
  setGPA(GPA);
 }

 //Mutator method to set student name
 public void setName(String name){
  this.name = name;
 }

 //Mutator method to set student year
 public void setYear(String year){
  this.year = year;
 }

 //Mutator method to set student GPA
 public void setGPA(double gpa){
  if (gpa >= 0.0 && gpa <= 4.0)
   this.GPA = gpa;
  else
   JOptionPane.showMessageDialog(null,
    "Invalid GPA entered.","Student",JOptionPane.INFORMATION_MESSAGE);
 }

 //Mutator method to retrieve student name
 public String getName(){
  return name;
 }

 //Mutator method to retrieve student year
 public String getYear(){
  return year;
 } 

 //Mutator method to retrieve student GPA
 public double getGPA(){
  return GPA;
 }
}