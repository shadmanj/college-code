/* PA 4.2.1:  An introduction to pretty C code.
 * File:    PA_4_2_1_Task1_sjubaer.c
 * Date:    01/30/2013
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
 * This program saves the world by converting units.
 */

# include <stdio.h>
# include <math.h>
# include "UnitConversion_sjubaer.h"

int main()
{	double Fahr,Ft,Hect,invC,Cels,Met,Acre,Nano, C, F;
	double Feet, Meters;
	printf("Test program for unit conversions.\n\n");
	
	/* Convert to Fahrenheit */
	printf("Temperature Conversions \n");
	printf("Enter value to convert C-F:\n");
	scanf("%lf", &Cels);
	Fahr = Cent2Fahr(Cels);
	printf("Converted temperature is:\n");
	printf("%1.2lf\n\n\n", Fahr);
	
	/* Convert to Celsius */
	printf("Enter value to convert F-C:\n");
	scanf("%lf", &F);
	C = Fahr2Cent(F);
	printf("Converted temperature is:\n");
	printf("%lf\n\n\n", C);

	/* Convert to Feet */
	printf("Length Conversions\n\n");
	printf("Enter value to convert m-ft\n");
	scanf("%lf", &Met);	
	Ft = M2Ft(Met);
	printf("Converted length is:\n");
	printf("%1.2lf\n\n\n", Ft);

	/* Convert to Meters */
	printf("Enter value to convert ft-m\n");
	scanf("%lf", &Feet);	
	Meters = Ft2M(Feet);
	printf("Converted length is:\n");
	printf("%1.2lf\n\n\n", Meters);

	/* Convert to Hectares */
	printf("Area Conversions\n\n");
	printf("Enter value to convert from Acres to Hectares\n");
	scanf("%lf", &Acre);
	Hect = Acre2Hectare(Acre);
	printf("Convert Area is:\n");
	printf("%1.2lf\n\n\n", Hect);

	/* Convert to inverse centimeters */
	printf("Special Unit Conversions\n\n");
	printf("Enter nanometer to be converted to inverse centimeters:\n");
	scanf("%lf", &Nano);
	invC = Nm2Invcm(Nano);
	printf("Converted unit in inverse centimeters is:\n");
	printf("%1.2f\n\n\n", invC);

	/* Terminate program */
	printf("Test Program Terminated\n");
	return 0;
}