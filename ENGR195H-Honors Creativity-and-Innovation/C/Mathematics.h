/* ACT 4.2.1:  An introduction to pretty C code.
 * File:    Mathematics.h
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


int Modulo(int Dividend, int Divisor)
{
	int Remainder;
	Remainder = Dividend % Divisor;
	return Remainder;
}

double ThirdP(double Input)
{
	double Third;
	Third = pow(Input,3);
	return Third;
}