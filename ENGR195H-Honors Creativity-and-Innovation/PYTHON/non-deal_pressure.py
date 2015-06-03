#!/usr/bin/env python3
#Post Activity 9.3.1 : Take inputs into lists and error check
# File :PA_9_3_1_Task2_sjubaer.py
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
# My program calculates the pressure of nonideal gases.
# 

# Define function to solve for pressure
def Pressure(V,T,a,b):
    import math
# Recognize and check for errors
    if (V == 0) or (V - b == 0):
        print('Error')
#Solve for pressure if no errors    
    else:
        R = .0820574587
        top = R * T
        frac1 = (top / (V - b))
        frac2 = (a / V**2)
        P = frac1 - frac2
        print('Pressure = ', P, 'atm')

# Ask for inputs and run programs
print("\nThis program calculates the pressure of nonideal gases.\n")
P = input('Enter the Values of V, T, a, and b: ').strip().split()
Pressure(float(P[0]),float(P[1]),float(P[2]),float(P[3]))
