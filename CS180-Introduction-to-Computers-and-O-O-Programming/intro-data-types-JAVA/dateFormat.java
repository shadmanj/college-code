/**
 * Shadman Jubaer
 * This program displays today's date in Month date, year.
 **/

import java.util.*;
import java.text.*;

class dateFormat {
  public static void main(String[] args){
    Date today = new Date();
    SimpleDateFormat sdf; 
    sdf = new SimpleDateFormat("MMMM dd, yyyy");
    System.out.println(sdf.format(today));
  }
}