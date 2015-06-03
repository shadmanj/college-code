/* Post Activity 4.2.1:  An introduction to pretty C code.
 * File:    UnitConversion_sjubaer.h
 * Date:    02/02/2013
 * By:      Shadman Jubaer
 *          sjubaer
 * Section: 1Whalen
 * Team:    Team 10 
 *
 * ELECTRONIC SIGNATURE
 * Shadman Jubaer
 *
 * The electronic signature above indicates the program submitted for
 * evaluation is my individual work and I have a general understanding
 * of all aspects of its development and execution.
 *
 * A BRIEF DESCRIPTION OF WHAT THE PROGRAM OR FUNCTION DOES
 * This program saves the world
 */

# include <stdio.h>
# include <math.h>

/* Convert Celcius to Fahrenheit */
double Cent2Fahr(double C)
{
	double F;
	F = ((1.8) * C) + 32;
	return F;
}

/* Convert Fahrenheit to Celsius */
double Fahr2Cent(double F)
{
	double C;
	C = (F- 32) / 1.8;
	return C;
}

/* Convert Meters to Feet */
double M2Ft(double M)
{
	double F;
	F = M * (3.2808);
	return F;
}

/* Convert Feet to Meters */
double Ft2M(double Ft)
{
	double Mt;
	Mt = Ft / 3.2808;
	return Mt;
}
/* Convert Acres to Hectares */
double Acre2Hectare(double A)
{
	double H;
	H = A * .4047;
	return H;
}

/* Convert Nanometers to inverse centimeters */
double Nm2Invcm(double N)
{	
	double invCm;
	invCm = 1 / (N * pow(10,-7));
	return invCm; 
}