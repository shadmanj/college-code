from __future__ import division
from visual.graph import *

# Physical Constants
k = 9.e9 # Coulomb force constant

# Scale Factors
pscale = 1 #momentum scale factor
fscale = 1 #force scale factor

# Objects
b= 1e-14  # impact parameter
alpha=sphere(pos=(-2e-13,b,0) , radius=1.e-14, color=color.cyan)
alpha.m = 4*1.7e-27  # mass of alpha particle - units of kg
alpha.c=2*1.6e-19   # charge of alpha particle - units of Coulombs

gold=sphere(pos=(0,0,0) , radius=1.e-14, color=color.yellow)
gold.m = 197*1.7e-27    # mass of gold nucleus - units of kg
gold.c=79*1.6e-19   # charge of gold nucleus - units of Coulombs

### Graphing Objects
gdisplay(xtitle='Time',ytitle='Px', x=500, y=0, width=600,height=300)
alphapx=gcurve(color=color.blue)
goldpx=gcurve(color=color.yellow)
totalpx=gcurve(color=color.green) # this is for the py of gold + alpha

gdisplay(xtitle='Time',ytitle='Py', x=500, y=300, width=600,height=300) 
alphapy=gcurve(color=color.blue) 
goldpy=gcurve(color=color.yellow)
totalpy=gcurve(color=color.green) # this is for the py of gold + alpha

# Initial values
alpha.K= 10*10e6 *1.6e-19 # initial energy of alpha particle; converts eVs to Joules
alpha.p=vector( sqrt(2*alpha.m*alpha.K) ,0,0) # initial momentum of alpha; in terms of alpha.K.  We want alpha to be moving only in the +x direction
gold.p=vector(0,0,0)

alpha.trail = curve(color=alpha.color) # for displaying the trajectory
gold.trail = curve(color=gold.color) # for displaying the trajectory

# Simulation Parameters
delta_t = 2.0974e-23
t = 0
simtime = 2.08e-20

while t < simtime:
    rate(1000)

    ##calculate displacement vector:Gold->alpha
    r_aG = alpha.pos - gold.pos # the relative position vector between the alpha and the gold
    rmag_aG = mag(r_aG) # the magnitude of r_aG
    rhat_aG =  r_aG/rmag_aG # the unit vector of r_aG

    ##calculate force:Gold on alpha
    Fmag_aG =  (k*alpha.c*gold.c)/rmag_aG**2 # the magnitude of the Coulomb force of the gold on the alpha
    Fhat_aG =   rhat_aG
    F_aG =  Fhat_aG*Fmag_aG # the Coulomb force of the gold on the alpha

     ##calculate force:alpha on Gold
    F_Ga  =  -F_aG # the Coulomb force of the alpha on the gold
    
    ##Net force on alpha
    Fnet_a = F_aG # the net force on the alpha particle

    ##Net force on Gold
    Fnet_G = F_Ga # the net force on the gold nucleus

    ##update alpha momentum
    deltap_a = Fnet_a*delta_t
    alpha.p=  alpha.p + deltap_a # update the momentum

    ##updata gold momentum
    deltap_G = Fnet_G*delta_t
    gold.p=  gold.p + deltap_G # update the momentum

    ##update alpha position
    deltar_a = (alpha.p / alpha.m)*delta_t
    alpha.pos= deltar_a + alpha.pos # update the position

    ##update gold Position
    deltar_G = (gold.p / gold.m)*delta_t
    gold.pos= deltar_G + gold.pos # update the position

    ##Update time
    t=t+delta_t

    ##append graphs and trails
    alpha.trail.append(pos=alpha.pos)  #appends new position to alpha trail
    gold.trail.append(pos=gold.pos)  #appends new position to gold trail
    alphapx.plot(pos=(t, alpha.p.x))
    alphapy.plot(pos=(t, alpha.p.y))
    totalpx.plot(pos=(t, gold.p.x+alpha.p.x))
    goldpx.plot(pos=(t, gold.p.x))
    goldpy.plot(pos=(t, gold.p.y))
    totalpy.plot(pos=(t, alpha.p.y+gold.p.y))
    
theta=atan2(alpha.p.y,alpha.p.x)*180/3.14159
print "b(m)"," ","theta(degrees)"
print b,theta
