/* ACT 4.2.1:  An introduction to pretty C code.
 * File:    ACT_4_2_1_Task5_sjubaer.c
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
 * This program saves the world
 */

# include <stdio.h>
# include <math.h>
# include "Mathematics.h"
int main()
{
	double Number, Cube;
	printf("Input number to be cubed\n");
	scanf("%lf", &Number);
	getchar();
	Cube = ThirdP(Number);
	printf("The number cubed is: %lf\n", Cube);
	return 0;
}