from __future__ import division
from visual import *

#Objects
Earth = sphere(pos=vector(0,0,0), radius=6.4e6, color=color.cyan)
craft = sphere(pos=vector(-10*Earth.radius,0,0), radius=1e6)
Moon = sphere(pos=vector(4e8,0,0), radius=1.75e6, color=color.white)
Moon.m = 7e22 #kg
Earth.m = 6e24 #kg
craft.m = 15e3 #kg

#Physical Constants
G = 6.7e-11 #N m^2 / kg^2

scene.autoscale = 0

#Calculate Relative Position Vector
r_cE = craft.pos - Earth.pos
rmag_cE = mag(r_cE)
rhat_cE = r_cE / rmag_cE

#Calulate Gravitational Force
Fmag_cE = G * Earth.m * craft.m / (rmag_cE**2)
F_cE = -Fmag_cE * rhat_cE
Fnet_c = F_cE


#Physical quantity vector arrows
Fscale = 10000
arr_c = arrow(pos=craft.pos, axis=F_cE * Fscale, color=color.yellow)
arr_E = arrow(pos=Earth.pos, axis=-F_cE * Fscale, color=color.yellow)




    




