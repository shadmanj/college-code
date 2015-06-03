
#!/bin/usr/env python
# Post Activity 8_2_1 Task 2 : Contains the program to calculate age in years and minutes
# File :PA_8_2_1_Task2_sjubaer.py
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
# My program contains the functions and program to calculate age in years and minutes in
# Post Activity 8.2.1.

def years(A,B):
    C = A + (B / 365)
    return C

def minutes(C):
    D = C * 365 * 24 * 60
    return D

print('Enter your last name in double quotes: ')
A = str(input())
print('Enter your first name in double quotes: ')
B = str(input())
print('Enter your age in whole years: ')
C = float(input())
print('Enter days elapsed since last birthday: ')
D = float(input())
E = years(C,D)
F = int(minutes(E))
print(B,A)
print('You are', E, 'years old.')
print('You are', F, 'minutes old.')
