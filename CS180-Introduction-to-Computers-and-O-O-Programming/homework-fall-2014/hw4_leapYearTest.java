/**
* Shadman Jubaer
* This program tests the leap year class by testing whether different years are 
* leap years.
*/

public class hw4_leapYearTest{
	public static void main(String[] args) {
		int year1 = 1900;
		int year2 = 2000;
		int year3 = 2010;	
		int year4 = 2012;
		
		hw4_leapYear one = new hw4_leapYear(year1);
		hw4_leapYear two = new hw4_leapYear(year2);
		hw4_leapYear three = new hw4_leapYear(year3);
		hw4_leapYear four = new hw4_leapYear(year4);

		System.out.println(one.isLeapYear());
		System.out.println(two.isLeapYear());
		System.out.println(three.isLeapYear());
		System.out.println(four.isLeapYear());
	}
}