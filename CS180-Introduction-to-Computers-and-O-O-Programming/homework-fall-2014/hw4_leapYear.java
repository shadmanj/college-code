/**
* Shadman Jubaer
* This class gives back a boolean describing whether or not it is a leap 
* year.*/

public class hw4_leapYear{

	int year;

	public hw4_leapYear(int year){
		setYear(year);
	}

	public void setYear(int year){this.year = year;}

	public boolean isLeapYear(){
		if ((year%4)==0){
			if ((year%100)==0 && (year%400!=0))
				return false;
			else
				return true;
		}

		else 
			return false;
	}
}