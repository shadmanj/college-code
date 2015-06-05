/** 
 * Shadman Jubaer
 * This controller class uses the CS180Staff class to input and display 
 * course information.
 **/

//Controller class
public class CourseStaff{
  
  public static void main(String[] args){
    
    //Initialize variables
    CS180Staff instructor, coordinator, ta;
    
    //Take instructor info
    instructor = new CS180Staff();
    instructor.getDetails();
    
    //Take coordinator info
    coordinator = new CS180Staff();
    coordinator.getDetails();
    
    //Take TA info
    ta = new CS180Staff();
    ta.getDetails();
    
    //Print outputs
    System.out.println("Instructor:");
    instructor.printNeatly();
    System.out.println("Coordinator:");
    coordinator.printNeatly();
    System.out.println("Teaching Assistant:");
    ta.printNeatly();
  }
}