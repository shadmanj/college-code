/* PA 5.2.1:  An introduction to pretty C code.
 * File:    PA_5_2_1_sjubaer.c
 * Date:    02/09/2013
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
 * This calculates the endurance limit of a shaft.
 */

# include <stdio.h>
# include <math.h>

int main()
{
	/*Define variables*/
	float Endurance, Diameter, ReliabilityLevel, a, b, Kb, Ka, Kc;
	float Kd, Kf, Ke;
	char SurfaceCondition, Units, Bend;

	/*Ask for inputs*/
	printf("Please input the surface condition of a shaft: G, M, H, or A? > ");
	scanf("%c", &SurfaceCondition);
	getchar();
	printf("Please input the diameter of the shaft > ");
	scanf("%f", &Diameter);
	getchar();
	printf("Please input the units of the diameter (I or M) > ");
	scanf("%c", &Units);
	getchar();
	printf("Please specify whether your shaft is bending (B) or torsion (T) > ");
	scanf("%c", &Bend);
	getchar();
	printf("Please specify the reliability level in percentage > ");
	scanf("%f", &ReliabilityLevel);
	getchar();

	/*Define a and b*/
	if (SurfaceCondition == 'G')
	{
		a = 1.34;
		b = -.085;
	}
	else if (SurfaceCondition == 'M')
	{
		a = 2.70;
		b = -.265;
	}
	else if (SurfaceCondition == 'H')
	{
		a = 14.4;
		b = -.718;
	}
	else if (SurfaceCondition == 'A')
	{
		a = 39.9;
		b = -.995;
	}
	else
		printf("AYour inputs are wrong. So I gave you the wrong answers\n");

	/*Calculate Ka*/
	Ka = a * pow(75,b);

	/*Calculate Kb*/
	if (Units == 'I')
	{
		if (Diameter <= 2)
		{
			if (Diameter >= .11)
				Kb = 0.879*pow(Diameter, -.107);
			else
				printf("BYour inputs are wrong. So I gave you the wrong answers\n");
		}
		if (Diameter > 2)
		{
			if (Diameter <= 10)
				Kb = .879 * pow(Diameter, -.107);
			else
				printf("CYour inputs are wrong. So I gave you the wrong answers\n");
		}
	}
	if (Units == 'M')
	{
		if (Diameter <= 51)
		{
			if (Diameter >= 2.79)
				Kb = 1.24 * pow(Diameter,-.107);
			else
				printf("DYour inputs are wrong. So I gave you the wrong answers\n");
		}
		if (Diameter <= 254)
		{
			if (Diameter > 51)
				Kb = 1.51 * pow(Diameter,-.157);
			else
				printf("EYour inputs are wrong. So I gave you the wrong answers\n");
		}
	}
	
	/* Calculate Kc*/
	if (Bend == 'B')
		Kc = 1;
	else if (Bend == 'T')
		Kc = .59;
	else 
		printf("FYour inputs are wrong. So I gave you the wrong answers\n");
	/*Define Kd and Kf*/
	Kd = 1;
	Kf = 1;

	/*Calculate Ke*/
	if (ReliabilityLevel <= 50 && ReliabilityLevel > 0)
		Ke = 1.000;
	else if (ReliabilityLevel > 50 && ReliabilityLevel <=90)
		Ke = .897;
	else if (ReliabilityLevel > 90 && ReliabilityLevel <= 95)
		Ke = .814;
	else if (ReliabilityLevel > 95 && ReliabilityLevel <= 99.000)		Ke = .814;
	else if (ReliabilityLevel > 99.000)
	{
	if (ReliabilityLevel <= 99.9)
		Ke = .753;
	}
	/*Calculate Endurance*/
	Endurance = Ka*Kb*Kc*Kd*Ke*Kf;
	
	/* Print output*/
	printf("\n\nThe estimated endurance limit for this shaft is %.3f\n\n", 
		Endurance);
	printf("\n");
	return 0;
}