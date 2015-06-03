#!/bin/usr/env python
# Post Activity 8_2_1 Main : This program uses functions to calculate series and parallel values in Ohms.
# File :PA_8_2_1_main_sjubaer.py
# By : Shadman Jubaer
# Login : sjubaer
# Section : 3Whalen
# Team : Team 51
#
# ELECTRONIC SIGNATURE
# Shadman Jubaer
#
# The electronic signature above indicates
# the program submitted for evaluation is
# my individual work, and I have a general
# understanding of all aspects of its
# development and execution.
#
# PROGRAM DESCRIPTION
# This program uses functions to calculate series and parallel values in Ohms.

import resistance_functions
print("\nThis program takes two inputs to calculate series resistance,\nand two inputs to calculate parallel resistance in Ohms.\n")
print('Input First Resistence in Ohms for series ')
A = float(input())
print('input Second Resistence in Ohms for series ')
B = float(input())
print('Input First Resistence in Ohms for parallel ')
C = float(input())
print('Input Second Resistence in Ohms for parallel ')
D = float(input())
E = float(resistance_functions.series(A,B))
F = float(resistance_functions.parallel (C,D))
print('When the First Resistence is ', A, '[Ohms] and the Second Resistence is ', B, '[Ohms], the Series Resistence is ', E, '[Ohms].')
print('When the First Resistence is ', C, '[Ohms] and the Second Resistence is ', D, '[Ohms] the Parallel Resistence is ', F, '[Ohms].\n')
