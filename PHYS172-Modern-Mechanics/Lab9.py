from __future__ import division
from visual import *
from visual.graph import *

#control visualizer window
scene.width = 600
scene.height = 760

#objects
ceiling = box(pos=vector(0,0,0), size = (0.2,0.01,0.2))
block = sphere(radius=.025, color=color.yellow)
spring=helix(pos=ceiling.pos, color=color.orange, radius=.01)

block.m = .450 #mass of holder weights
L0 = .10 #meters
ks = 15 #spring constant

block.trail = curve(color=block.color)


#graphs
gdisplay(xtitle='Seconds', ytitle='Meters', x=600, y=0, width=600, height=300)
ygraph = gcurve(color=color.yellow)

#physical constants
g = 0 #m/s^2

#simulation parameters
delta_t = .001
simtime = 10 #seconds

t = 0 #simulation time is 0

amp = .09 #cm amplitude of oscilation
yeq = -L0 - block.m*g/ks

#initial values
block.pos = vector(0,yeq-amp,0) #displace block from equilibrium position
block.v = vector(0,0,0) #start at rest
block.p = block.m*block.v #momentum of block

spring.axis = block.pos - ceiling.pos

#imporve display
scene.autoscale = 0 #dont zoom camera
scene.center = vector(0,yeq,0)

#calculation loop
while t < simtime:
    rate(10000)

    #calculate L vector
    L =block.pos - spring.pos
    Lmag = mag(L)
    Lhat = -L/Lmag

    #force of spring on block
    stretch = Lmag - L0
    Fmag_bspring = ks * stretch
    Fhat_bspring = Lhat
    F_bspring  = Fmag_bspring * Fhat_bspring

    #other force on block
    Fmag_b = block.m * 9.8
    Fhat_b = vector(0,-1,0)
    F_b = Fmag_b * Fhat_b

    #net force on block
    Fnet_b = F_b + F_bspring

    #apply momentum principle
    deltap_block = Fnet_b * delta_t
    block.p = block.p + deltap_block

    #update position
    deltar_block = (block.p/block.m)*delta_t
    block.pos = block.pos + deltar_block

    #add points to block trail
    block.trail.append(pos=block.pos)

    #add data points to ygraph
    ygraph.plot(pos=(t, block.pos.y))

    #update axis of spring
    spring.axis = block.pos
    
    #update time
    t = t + delta_t
