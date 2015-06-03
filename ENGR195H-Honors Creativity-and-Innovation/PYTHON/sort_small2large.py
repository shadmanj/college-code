#!/usr/bin/env python3

#Post Activity 10.2.1 : Order lists
# File :PA_10_2_1_Task1_sjubaer.py
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
# My program puts the numbers in an inputted list
# in order from least to greatest.

def selection_sort(list):
# Define output list
    output = []
# While the length of list is defined,
# the smallest number in it is the 0 element, unless a number
# in the list is less than that element, in which case it 
# becomes the smallest number.
    while len(list):
        smallest_numb = list[0]
        for x in list:
            if x < smallest_numb:
                smallest_numb = x
        output.append(smallest_numb)
# Remove the variable smallest_numb
        list.remove(smallest_numb)  
    return output     

# Run the function
print("\nThis program puts any list of numbers in order from least to greatest\n")
list = input('Please enter a list of numbers in form ("1 4 2 ...etc"): ').strip().split()
D = selection_sort(list)
print(D)

