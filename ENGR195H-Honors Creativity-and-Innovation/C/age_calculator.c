/* Assignment 3.2.1: Practice C Operations with data types
 * File:    PA_3_2_1_Task2_sjubaer.c
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
 * This program saves the world by calculating names and ages. */

# include <stdio.h>

int main()
{
/* Initialize Variables */
char First[20], Middle[20], Last[20];
int Age, Days;
float Age_Minutes, Year_Decimal;

/* Explanation */
printf("This program will calculate your age and name. \n \n");

/* Prompt for Inputs */
printf("Enter your last name\n");
scanf("%s", First);
getchar();
printf("Enter your first name\n");
scanf("%s", Last);
getchar();
printf("Enter your middle initial\n");
scanf("%s", Middle);
getchar();
printf("Enter your age in whole years\n");
scanf("%i", &Age);
getchar();
printf("Enter the days elapsed since your last birthday.\n");
scanf("%i", &Days);

/* Calculate Age */
Year_Decimal = (Days / (365.242199)) + Age;
Age_Minutes = Year_Decimal * 365.242199 * 24.0 * 60.0;

/* Print Statement */
printf("Mr./Mrs. %s %s. %s \n", First, Middle, Last);
printf("You are %1.5f years old.\n", Year_Decimal);
printf("You are %1.0f minutes old.\n",  Age_Minutes);
getchar();
return 0;
}