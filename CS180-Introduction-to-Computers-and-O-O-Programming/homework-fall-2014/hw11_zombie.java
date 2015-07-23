/**
* Shadman Jubaer
* This class describes zombies by name and serial number
* This class also has methods to keep count of how many zombies are created
*/

import java.util.*;



public class hw11_zombie{

	public static void main(String[] args){
		hw11_zombie z1 = new hw11_zombie("Fred");
		printStatus();
		hw11_zombie z2 = new hw11_zombie("Joe");
		printStatus();
		hw11_zombie z3 = new hw11_zombie("Frank");
		printStatus();

		z1.printZombie();
		z2.printZombie();
		z3.printZombie();

	}

	private String name;
	private int serial;
	static int count=0;

	public hw11_zombie(String name){
		this.name = name;
		this.serial = count;
	}	

	static void printStatus(){
		System.out.println(count+" zombies created so far.");
		count++;
	}

	public void printZombie(){
		System.out.println(name+" is zombie "+serial);
	}
}