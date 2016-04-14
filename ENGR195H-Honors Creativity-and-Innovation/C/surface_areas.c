/* Assignment #0:  An introduction to pretty C code.
 * File:    
 * Date:    
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
 * This program saves the world by finding Surface Areas of pyramids
 */

# include <stdio.h>
# include <math.h>
# include "SurfaceAreas.h"

int main()
{
	double TriPyr, QuadPyr, PentPyr, 
	Edge, Base, Slant, Apothem, Side;
	
	/* Calculate Trigonal Pyramid Surface Area */
	printf("Calculate Trigonal Pyramid Surface Area\n\n");
	printf("Enter Edge Length in cm.:\n");
	scanf("%lf", &Edge);
	getchar();
	TriPyr = TriPyramid(Edge);
	printf("The Surface Area is: %lf cm^2\n\n\n", TriPyr);

	/* Calculate Quadrilateral Pyramid Surface Area */
	printf("Calculate Quadrilateral Pyramid Surface Area\n\n");
	printf("Enter Slant Height in cm:\n");
	scanf("%lf", &Slant);
	getchar();
	printf("Enter Base Edge Length in cm:\n");
	scanf("%lf", &Base);
	getchar();
	QuadPyr = QuadPyramid(Slant,Base);
	printf("The Surface Area is: %lf cm^2\n\n\n", QuadPyr);

	/* Calculate Pentagonal Pyramid Surface Area */
	printf("Calculate Pentagonal Pyramid Surface Area\n\n");
	printf("Enter Apothem in cm:\n");
	scanf("%lf", &Apothem);
	getchar();
	printf("Enter Side Length in cm:\n");
	scanf("%lf", &Side);
	getchar();
	printf("Enter Slant Height in cm:\n");
	scanf("%lf", &Slant);
	getchar();
	PentPyr = PentPyramid(Apothem,Side,Slant);
	printf("The Surface Area is: %lf cm^2\n\n", PentPyr);
	printf("PROGRAM TERMINATED\n");
	return 0;
}

