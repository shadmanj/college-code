#Post Activity 13.2.1 Task1: Calculate Area
# File :PA_13_2_1_Task1_sjubaer.py
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
# My program saves the world by finding the cross-sectional
# area of an I-Beam

# This function will calculate the cross-sectional area
def IBeam(H,W,T):
    AreaI = H * T
    AreaHoriz = 2 * ((W - T) * T)
    Area = AreaI + AreaHoriz
# This returns a tuple
    Ou = (H,W,T,Area)
    return Ou
    
# This is the script that will output a text file
D = input('Input Height, Width, and Thickness (ft.)').strip().split()
H = float(D[0])
W = float(D[1])
T = float(D[2])
F = IBeam(H,W,T)
I = input('Please input a file name ending in .txt')
# This will output a text file
a = open(I, 'w')
a.write('For a beam with a height of {0:.1f} and a width of {0:.2f} and a thickness of {0:.3f}, the cross sectional area is {0:.2f}'.format(F[0],F[1],F[2],F[3])) 
a.close()
