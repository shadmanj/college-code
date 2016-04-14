#!/bin/usr/env python
# Post Activity 8_2_1 Functions : Contains functions to solve resistance
# File :PA_8_2_1_functions_sjubaer.py
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
# My program contains the functions used to calculate the resistance in Ohms in 
# Post Activity 8.2.1.

def series(A,B):
    C = A + B
    return C

def parallel(C,D):
    D = 1 / C
    return D
