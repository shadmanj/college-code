/**
* Shadman Jubaer
* This code tests the hw8_array class 
*/

import java.util.*;

public class hw8_arrayTest{
	public static void main(String[] args){
		int[] array = {1,2,3,4,5};
		int i = 0;
		Scanner in = new Scanner(System.in);
		hw8_array list = new hw8_array(array);
		int sum = list.sum();
		double average = list.average();
		System.out.println("Average: "+average);
		System.out.println("Sum: "+sum);
	}
}