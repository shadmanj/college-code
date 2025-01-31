from __future__ import division
from visual import *

#Objects
Earth = sphere(por=vector(0,0,0), radius=6.4e6, color=color.cyan)
craft = sphere(pos=vector(-10*Earth.radius,0,0), radius=1e6)
Moon = sphere(pos=vector(4e8,0,0), radius=1.75e6, color=color.white)
Moon.m = 7e22 #kg
Earth.m = 6e24 #kg
craft.m = 15e3 #kg
trail = curve(color=craft.color) # add trail object with no points


#Physical Constants
G = 6.7e-11 #N m^2 / kg^2

scene.autoscale = 0

#simulation parameters
delta_t = 10 #seconds
t=0 #seconds
simtime = 4*365*24*60*60

#Momentum of Craft
craft.v= vector(1000,1000,1000) #m/s
craft.p = craft.v*craft.m # kg m/s



while t<simtime:
    
    rate(10000)
 
        
    #Calculate Relative Position Vector
    r_cE = craft.pos - Earth.pos
    rmag_cE = mag(r_cE)
    rhat_cE = r_cE / rmag_cE

    #check for crash with earth
    if rmag_cE< Earth.radius:
        print "crashed into Earth"
        break

    #calculate relative position vector: craft - Moon
    r_cM = craft.pos - Moon.pos
    rmag_cM= mag(r_cM)
    rhat_cM = r_cM / rmag_cM

    #check for crash with Moon
    if rmag_cM< Moon.radius:
        print "crashed into Moon"
        break
    
    #Calulate Gravitational Force
    Fmag_cE = G * Earth.m * craft.m / (rmag_cE**2)
    F_cE = -Fmag_cE * rhat_cE
    Fnet_c = F_cE
    Fscale = 100000

    #update craft momentum
    delta_p = Fnet_c * delta_t
    craft.p = craft.p + delta_p
    
    #update craft position
    delta_r = (craft.p / craft.m)*delta_t
    craft.pos = craft.pos +delta_r

    
    #append craft trail
    trail.append(pos=craft.pos) #adds a point at the new craft position

    t=t+delta_t

scene.autoscale = 0 

#Momentum of Craft
craft.v= vector(0,0,0) #m/s
craft.p = craft.v*craft.m # kg m/s

#Physical Quantity Vector Arrows
arr_c = arrow(pos=craft.pos, axis=F_cE * Fscale, color=color.yellow)
arr_E = arrow(pos=Earth.pos, axis=-F_cE * Fscale, color=color.yellow)


