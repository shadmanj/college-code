#!/usr/bin/env python3
# Post Activity 10_2_1 : Convert binary to base 10 and back
# File :PA_10_2_1_Task2_sjubaer.py
# By : Shadman Jubaer
# Login : sjubaer
# Section : 3Whalen
# Team : Team 51
#
# ELECTRONIC SIGNITURE
# Shadman Jubaer
#
# The electronic signature above indicates
# the program submitted for evaluation is
# my individual work, and I have a general
# understanding of all aspects of its
# development and execution.
#
# PROGRAM DESCRIPTION
# My program can convert binary to base 10, then back again.

# Defines function to convert Base 10 to Binary

def Base10_to_Base2(Number):

# Set i equal to zero and make an empty string to 
# set up a while loop

    i = -1
    Binary = ' '

# The loop runs as long as i != 0 and keeps dividing
# i by 2, while at the same time calculating the remainder       
# of the same operation and adding it to the string intially
# created.

    while i != 0:
        i = int(Number / 2)
        Remainder = str(Number % 2)
        Binary = (Remainder + Binary)
        Number = i
    return Binary

# Defines function to convert Binary to Base 10

def Base2_to_Base10(Number):

# Turn the input into a list that is broken up into parts
    List  = [int(d) for d in str(Number)]
    Length = len(List)

# Finding the Element will determine the number of iterations of the
# for loop, and setting up the Sum variable will allow for easy adding

    Element = (Length - 1)
    Sum = 0
# For every iteration, the sum is calculated by setting 2 to the power 
# of each element, and continuing the iterations for each element - 1, 
# adding all the way through. 

    for i in List:
        Sum = int(i) * (2 ** Element) + Sum
        Element = (Element - 1)
    return Sum

# Main program
Type  = int(input('Input conversion type(0: base 10 to binary; 1: binary to base 10; 2: Quit: '))

# Conditional statements to determine which function to use or
# which message to output.

if Type == 0:
    Number = int(input('Input the number to be converted: '))
    Base10_to_Base2(Number)
    print('Converted Value: ', Base10_to_Base2(Number))

elif Type == 1:
    Number = int(input('Input the number to be converted: '))
    Base2_to_Base10(Number)
    print('Converted Value: ', Base2_to_Base10(Number))

elif Type == 2:
    print('So Long Suckers, I Quit')

else:
    print('Invalid input')
