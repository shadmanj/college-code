/**
* Shadman Jubaer
* This class takes an input array of integers and has methods to find the 
* sum and average of the integers stored in the array
*/

import java.util.*;

public class hw8_array{

	private int[] array;
	private int sum = 0;
	private double average = 0;


	public hw8_array(int[] array){
		this.array = array;
	}

	public int sum(){
		for (int i = 0; i < array.length; i++){
			sum += array[i];
		}
		return sum;
	}

	public double average(){
		/*System.out.println(sum);
		System.out.println(array.length);*/
		return (sum/array.length);
	}
}