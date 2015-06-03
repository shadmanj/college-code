/* PA 4.2.1: An introduction to pretty C code.
 * File:    PA_4_2_1_Task2_sjubaer.c
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
 * This program saves the world by determining heat loss from a house
 */

# include <stdio.h>
# include <math.h>
# include "UnitConversion_sjubaer.h"

/* Define function prototypes */
double HeatLoss(double HeatCoef, double DeltaTemp, double SArea);
double HeatTransferCoef(double Nusselt, double Height);
double NusseltNum(double Ra);
double RayleighNum(double DeltaTemp, double TempOut, double Height);

/* Main function */
int main()
{
	double Length, Height, TempIn, TempOut, SArea, DeltaTemp, Nusselt;
	double HeatCoef, Heat_Loss, Ra;
	/* Ask for inputs*/
	printf("Enter the length of the house (ft.):\n");
	scanf("%lf", &Length);
	getchar();
	printf("Enter the height of the house (ft.):\n");
	scanf("%lf", &Height);
	getchar();
	printf("Enter temperature outside house (F):\n");
	scanf("%lf", &TempOut);
	getchar();
	printf("Enter temperature inside house (F):\n");
	scanf("%lf", &TempIn);
	getchar();
	
	/* Unit Conversions */
	TempIn = Fahr2Cent(TempIn);
	TempOut = Fahr2Cent(TempOut);
	Length = Ft2M(Length);
	Height = Ft2M(Height);

	/* Calculate Surface Area and (TempIn-TempOut) */
	DeltaTemp = TempIn - TempOut;
	SArea = Length * Height;

	/* Evaluate Heat Loss using functions */
	Ra = RayleighNum(DeltaTemp, TempOut, Height);
	Nusselt = NusseltNum(Ra);
	HeatCoef = HeatTransferCoef(Nusselt, Height);
	Heat_Loss = HeatLoss(HeatCoef,DeltaTemp,SArea);

	/* Print Output */
	printf("The calculated heat loss is (W):\n");
	printf("%lf\n", Heat_Loss);
	return 0;
}

/* Heat loss function */
double HeatLoss(double HeatCoef, double DeltaTemp, double SArea)
{
	double HeatL;
	HeatL = HeatCoef * SArea * DeltaTemp;
	return HeatL;
}

/* Heat transfer coefficient function */
double HeatTransferCoef(double Nusselt, double Height)
{
	double HeatTrans;
	HeatTrans = (Nusselt * (0.25)) / Height; 
	return HeatTrans;
}

/* Nusselt Number function */
double NusseltNum(double Ra)
{
	double Nusselt;
	Nusselt = (0.59) * pow(Ra,0.25);
	return Nusselt;
}

/* Rayleigh number function */
double RayleighNum(double DeltaTemp, double TempOut, double Height)
{
	double Ra;
	/* Calculate top of function */
	Ra = ((9.81)*(1/TempOut)*(DeltaTemp)*(pow(Height,3))*(0.7));
	
	/* Calculate bottom of function */
	Ra = Ra / pow(1.78e-5,2);
	return Ra;
}