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
 * This program saves the world by finding Surface Areas
 */
 # include <stdio.h>
 # include <math.h>
 
 double TriPyramid(double EdgeLength)
 {
 	double SArea;
 	SArea = pow(3,.5) * pow(EdgeLength,2);
 	return SArea;
 }

 double QuadPyramid(double SlantHeight, double BaseEdge)
 {
 	double SArea;
 	SArea = pow(BaseEdge,2) + 2 * BaseEdge * pow(((pow(SlantHeight,2) -
 		 	pow(BaseEdge,2)) / 4),.5);
 	return SArea;
 }

 double PentPyramid(double Apothem, double Side, double SlantHeight)
 {
 	double SArea;
 	SArea = ((2.5) * Apothem * Side) + ((2.5) * Side * SlantHeight);
 	return SArea;
 }