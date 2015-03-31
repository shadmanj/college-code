/*Create a class that returns a counter value every time it is called*/
public class MyCounter {
	
	public MyCounter(int StartValue){
		counter = StartValue;
		
	}
	
	public MyCounter(){
		counter = 1;
	}
	
	public int nextValue(){
		int temp = counter;
		counter++;
		return temp;
	}
	//Instance variable
	private int counter;

}
