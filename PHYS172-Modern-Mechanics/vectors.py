from __future__ import division
from visual import *

# Vector Objects
A = arrow(color=color.red, shaftwidth=0.2);
B = arrow(color=color.cyan, shaftwidth=0.2);
A.mag = (3.00);
A.dir = vector(-0.7071, 0.7071, 0);
B.mag = (4.00);
B.dir = vector(0.7071, 0.7071, 0);
C = arrow(color=color.yellow, shaftwidth=0.2)

#Vectors in Component Form
A.axis = A.mag * A.dir
B.axis = B.mag * B.dir

#Print Vectors
print "vector A =", A.axis
print "vector B =", B.axis

#Create vector C, which is sum of vectors A and B
C.axis = A.axis + B.axis
print "vector C=", C.axis
C.mag = mag(C.axis)
C.dir = C.axis / C.mag
print "vector magnitude of C=", C.mag
print "unit vector of C=", C.dir

#Aligning vectors for geometric addition
A.pos = vector(-2,-1,0)
B.pos = A.pos + A.axis
C.pos = A.pos
