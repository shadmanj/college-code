/**
* Shadman Jubaer
* This class describes zombies by name and serial number
* This class also has methods to keep count of how many zombies are created
*/

import java.util.*;



public class hw11_zombie{

	public static void main(String[] args){
		/*
		hw11_zombie z1 = new hw11_zombie("Fred");
		printStatus();
		hw11_zombie z2 = new hw11_zombie("Joe");
		printStatus();
		hw11_zombie z3 = new hw11_zombie("Frank");
		printStatus();

		z1.printZombie();
		z2.printZombie();
		z3.printZombie();
		*/

		while (Math.random() < 0.9)
			new hw11_zombie("Z"+(int) (Math.random() * 1000));

		for (int i = 0; i < getCount(); i++)
			getZombie(i).printZombie();
	}

	private String name;
	private int serial;
	static int count=0;
	private static ArrayList<hw11_zombie> list = new ArrayList<hw11_zombie>();

	public hw11_zombie(String name){
		list.add(this);
		this.name = name;
		this.serial = count;
		count--;
	}	

	static void printStatus(){
		System.out.println((count-1)+" zombies created so far.");
	}

	public static hw11_zombie getZombie(int position){
		return list.get(position);
	}

	public void printZombie(){
		System.out.println(name+" is zombie "+serial);
	}

	public static int getCount(){
		return count-1;
	}
}