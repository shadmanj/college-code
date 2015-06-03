#!/usr/bin/env python3

# CFU 8.2.1 : Surface Area of Cylinder
# File : CFU_8_2_1_sjubaer.py
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
# My program does the tasks specified in CFU 8.2.1

import math
def surAreaCyl():
    print('Input Diameter in cm: ')
    D = float(input())
    print('Input Heightin cm: ')
    H = float(input()) 
    R = D / 2
    A = (2 * 3.14 * R ** 2) + (2 * 3.14 * R * H)
    print('The surface of a cylinder is ', A, '[cm**2] for a given diameter of ', D, '[cm] and height of ', H, '[cm].')
    return A 


surAreaCyl()  

