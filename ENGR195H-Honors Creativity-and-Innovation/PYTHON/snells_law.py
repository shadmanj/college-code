#!/usr/bin/env python3
#Post Activity 9.3.1 : Use collection data types and conditional statements
# File :PA_9_3_1_Task1_sjubaer.py
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
# My program finds the distance of refraction in optics based on Snell's Law.
# Inputs are strings with the first and second values separated by a space.

# Define the function that will solve for the refraction distance
def d3(n1,n2,t1,d1,d2):
    import math
# Account for errors
    if (n1 / n2) > 1:
        print('Error, no refraction in the second media.')
# Solve the equation if there are no errors    
    else:    
        C = math.radians(t1)
        D = math.asin((n1 * math.sin(C)) / n2)
        E = (math.tan(C) * d1) + (math.tan(D) * d2) 
        print('Ending distance is: ', E, 'units')

# Actual program to be run
I = input('Enter indices of refraction for bottom two media: ').strip().split()
T = input('Enter angle of incidence (in degrees): ')
D = input('Enter d1 and d2 (units): ').strip().split()
d3(float(I[0]),float(I[1]),int(T),float(D[0]),float(D[1]))

