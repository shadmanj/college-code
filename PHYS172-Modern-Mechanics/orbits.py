from __future__ import division
from visual import *
from visual.graph import *

#Objects
Earth = sphere(por=vector(0,0,0), radius=6.4e6, color=color.cyan)
craft = sphere(pos=vector(-10*Earth.radius,0,0), radius=1e6)
#Moon = sphere(pos=vector(4e8,0,0), radius=1.75e6, color=color.white)
#Moon.m = 7e22 #kg
Earth.m = 6e24 #kg
craft.m = 15e3 #kg
trail = curve(color=craft.color) # add trail object with no points
#Earth.v = vector(0,0,0)
#Earth.p = Earth.v * Earth.m

# Graphing Objects
gdisplay(xtitle='Distance from Earth',ytitle='Joules', x=500,y=0,width=800,height=500)
Kgraph = gcurve(color = color.magenta)
Ugraph = gcurve(color=color.yellow)
Etotal = gcurve(color=color.red)
Wgraph = gcurve(color=color.cyan)

#Physical Constants
G = 6.7e-11 #N m^2 / kg^2

#scene.autoscale = 1
#scene.center = vector(2e8, 0, 0)

#simulation parameters
delta_t = 10 #seconds
t=0 #seconds
simtime = 4*24*60*60

#Momentum of Craft
craft.v= vector(0,3536.32,0) #m/s
craft.p = craft.v*craft.m # kg m/s

#Physical quantity vector arrows
parr_c = arrow(color=color.blue) #momentum of craft arrow
fnetarr_c = arrow(shaftwidth = 2e6, color=color.red) #net force on craft
fearr_c = arrow(color=color.cyan, shaftwidth=2e6) #force from earth arrow
#fmarr_c = arrow(color=color.white, shaftwidth=2e6) #force from moon arrow

#initial values
W_oncraft = 0


while t<simtime:
    
    rate(120000)
 
        
    #Calculate Relative Position Vector
    r_cE = craft.pos - Earth.pos
    rmag_cE = mag(r_cE)
    rhat_cE = r_cE / rmag_cE

    #check for crash with earth
    if rmag_cE< Earth.radius:
        print "crashed into Earth"
        break

    #calculate relative position vector: craft - Moon
    #r_cM = craft.pos - Moon.pos
    #rmag_cM= mag(r_cM)
    #rhat_cM = r_cM / rmag_cM

    #check for crash with Moon
    #if rmag_cM< Moon.radius:
        #print "crashed into Moon"
        #break
    
    #Calulate Gravitational Force
    Fmag_cE = G * Earth.m * craft.m / (rmag_cE**2)
    #Fmag_cM = G * Moon.m * craft.m / (rmag_cM**2)
    F_cE = -Fmag_cE * rhat_cE
    #F_cM = -Fmag_cM * rhat_cM
    Fnet_c = F_cE #+ F_cM
    Fscale = 1e-20

    #Calculate Force of Gravity: Earth
    F_Ec = -F_cE
    Fnet_E = Fnet_c

    #Update Momentum: Earth
    #deltap_Earth = Fnet_E*delta_t
    #Earth.p = Earth.p + deltap_Earth

    #Update Position: Earth
    #deltar_Earth = (Earth.p / Earth.m)*delta_t
    #Earth.pos = Earth.pos + deltar_Earth

    #update craft momentum
    delta_p = Fnet_c * delta_t
    craft.p = craft.p + delta_p
    
    #update craft position
    delta_r = (craft.p / craft.m)*delta_t
    craft.pos = craft.pos +delta_r

    #Update position arrows
    pscale = 1e-20
    parr_c.pos = craft.pos
    parr_c.axis = craft.p * pscale
    fnetarr_c.pos = craft.pos
    fnetarr_c.axis = Fnet_c * Fscale

    #update craft arrows
    fearr_c.pos = craft.pos
    fearr_c.axis = F_cE * Fscale
    #fmarr_c.pos = craft.pos
    #fmarr_c.axis = F_cM * Fscale
    
    #append craft trail
    trail.append(pos=craft.pos) #adds a point at the new craft position

    #calculate and update work
    W_interval = Fnet_E.dot(delta_r) ## work done in the iteration
    W_oncraft = W_oncraft + W_interval ## keeps track of total work on craft

    #calculate system energies
    pmag = mag(craft.p) ## magnitude of craft momentum
    K = pow(mag(craft.p),2)/(2*craft.m)
    U = (-G*(craft.m*Earth.m))/mag(craft.pos)
    E = K + U



    #add data points to Energy graphs
    Kgraph.plot(pos=(mag(craft.pos-Earth.pos),K))
    Ugraph.plot(pos=(mag(craft.pos-Earth.pos),U))
    Etotal.plot(pos=(mag(craft.pos-Earth.pos),E))
    Wgraph.plot(pos=(mag(craft.pos-Earth.pos),W_oncraft))
    
    #scene.center = (Earth.pos*Earth.m+craft.pos*craft.m)/(craft.m+Earth.m)
    t=t+delta_t

#Physical Quantity Vector Arrows
arr_c = arrow(pos=craft.pos, axis=F_cE * Fscale, color=color.yellow)
arr_E = arrow(pos=Earth.pos, axis=-F_cE * Fscale, color=color.yellow)

scene.autoscale = 1

#Momentum of Craft
craft.v= vector(0,0,0) #m/s
craft.p = craft.v*craft.m # kg m/s

