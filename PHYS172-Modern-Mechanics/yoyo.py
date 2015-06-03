from __future__ import division
from visual import *

#setup the scene
scene.height=1000
scene.center=(0,5,0)
scene.range=(12,12,12)
scene.autoscale=0

#Constants and scale Factors
fscale=0.1
g=9.8

#Objects
R=1
disk=sphere(pos=(0,0,0), radius=R, color=color.yellow)
disk.m=1
disk.I=0.5*disk.m*R*R

string = curve(pos=[disk.pos+vector(-R,0,0),disk.pos+vector(-R,2,0)], radius=R/20)

#initial Calculations
Tension_dS = vector(0,-disk.m*g,0) # Use momentum principle to determine value to make yo-yo hover

#Markers and Force
stringpull = arrow(pos=disk.pos+vector(-R,2,0), axis=fscale*Tension_dS, shaftwidth=R/10, color=color.red)
pointer = arrow(pos=disk.pos, axis=(1.3*R,0,0), shaftwidth=R/10, color=color.cyan) #Marks yoyo with an arrow, to visualize spinning

#set initial conditions
disk.L=vector(0,0,0)  #If the yo-yo is not initially spinning, what is the angular momentum?
disk.p=vector(0,0,0) #yo-yo is not moving initially
disk.theta=0 
stringlength=0  # length of string pulled off disk

#Simulation Parameters and Initialization
delta_t = 0.001
t=0
simtime = 3

while t < simtime:
    rate(200)

    r= vector(-R,0,0)  # vector from rotation axis to string contact at x=-R

    #Forces acting on disk
    F_dE = vector(0,-disk.m*g,0)
    Tension_dS = vector(0,disk.m*g)  # Use momentum principle to determine value to make yo-yo hover

    #net Force acting on disk
    Fnet_d = Tension_dS + F_dE

    #Calculate Torque on Disk from string
    torque_dS = cross(r,Tension_dS) # Definition of torque 
    
    #Update Angular Momentum: disk
    deltaL_d = torque_dS * delta_t #determine change in angular momentum using torque
    disk.L = disk.L + deltaL_d  #update angular momentum
    disk.omega = disk.L / (disk.m*mag(r)**2) # how do you get angular velocity vector omega from the vector disk.L?

    #Update Angular Position: disk
    deltatheta_d = disk.omega.z*delta_t # Note that angular position is not a vector ... which component of omega is non-zero?
    disk.theta =  disk.theta + deltatheta_d#calculate how far the disk has rotated from its initial position

    #Update Linear Momentum: disk
    deltap_d = Fnet_d*delta_t
    disk.p = disk.p + deltap_d

    #Update Position: disk
    deltar = disk.p/disk.m*delta_t
    disk.pos = disk.pos + deltar

    #Update Length of String
    string.v=-disk.omega.z*R # The linear velocity of the string
    deltastringlength = string.v*delta_t
    stringlength=stringlength + deltastringlength  #The length of string pulled off

    #Update String Position
    string.pos=[disk.pos+vector(-R,0,0),disk.pos+vector(-R,2+stringlength,0)]

    #Update Stringpull arrow position
    stringpull.pos=disk.pos+vector(-R,2+stringlength,0)
    
    #Update pointer position and makes disk spin    
    pointer.pos=disk.pos
    x=R*cos(disk.theta)
    y=R*sin(disk.theta)
    pointer.axis=1.3*vector(x,y,0)
    disk.axis=vector(x,y,0)

    #Update Time
    t=t+delta_t
    
print "linear velocity of string"
print string.v, "m/s"
    
    
