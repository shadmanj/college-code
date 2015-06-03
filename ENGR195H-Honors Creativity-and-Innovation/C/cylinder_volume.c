/* Assignment PA 3.2.1:  Calculations and printing in C    
 * File:    PA_3_2_1_Task1_sjubaer.c
 * Date:    01/27/2013
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
 * This program saves the world by calculating volumes of cylinders
 */

# include <stdio.h>
# include <math.h>
# define Pi 4.0 * atan(1.0)
int main()
{
/* Define variables*/
float diameter, height, height2, diameter2, Radius, Volume, Area;
int idiameter, iheight;

/* Explanation*/
printf("This program will give you the volume of a cylinder in customary units\n");

/* Inputs*/
printf("Enter Diameter in meters: \n");
scanf("%f", &diameter);
getchar();
printf("Enter height in meters: \n");
scanf("%f", &height);
getchar();

/* Calculate Volume*/
Radius = diameter / 2;
Area = Pi * (Radius * Radius);
Volume = Area * height;

/*Convert volume and inputs to customary units*/
diameter = diameter * 3.28084;
height = height * 3.28084;
Volume = Volume * 264.172;

/* Convert customary units to ft. and inches units*/
idiameter = diameter;
diameter2 = (diameter - idiameter) * 12;
iheight = height;
height2 = (height - iheight) * 12;

/* Print outputs*/
printf("Volume in US gallons: %.3f\n", Volume);
printf("Height in ft: %.3f \n", height);
printf("Diameter in ft: %.3f \n\n", diameter);
printf("Volume in US gallons: %.3f\n", Volume);
printf("Height in ft and in: %i ft. %.3f in.\n", iheight, height2);
printf("Diameter in ft and in: %i ft. %.3f in.\n", idiameter, diameter2);
getchar();
return 0;
}