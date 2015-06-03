/* Activity 3.2.1:  Intro to C.
 * File:    ACT_3_2_1_Task1a_sjubaer.c
 * Date:    01/23/2013
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
 * This program reads names.
 */

# include <stdio.h>

int main()
{
char  Name[20];
printf("What is your last name?\n");
scanf("%s", Name);
getchar();
printf("Hello Mr./Mrs. %s", Name);
getchar();
return 0;
}
