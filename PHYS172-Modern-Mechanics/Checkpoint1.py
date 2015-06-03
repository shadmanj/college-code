from __future__ import division
from visual import *

#Objects
Earth = sphere(pos=vector(0,0,0), radius=6.4e6, color=color.cyan)
craft = sphere(pos=vector(-10*Earth.radius,0,0), radius=1e6, color=color.yellow)
Earth.m = 6e24 # units of kg
craft.m = 15e3 # units of kg
Moon = sphere(pos=vector(4e8,0,0), radius=1.75e6, color=color.white)
Moon.m = 7e22 # units of kg


#Physical Constants
G = 6.7e-11 # units of N m^2 / kg^2

#Calculate Relative Position Vector
r_cE = Earth.pos - craft.pos
rmag_cE = mag(r_cE)

#Calculate Gravitational Force
Fmag_cE = G * ((Earth.m * craft.m) / (rmag_cE**2))
rhat_cE = r_cE / rmag_cE
F_cE = Fmag_cE * rhat_cE
Fnet_c = F_cE

#Physical quantity vector arrows
scene.autoscale = 0
Fscale = 10000
arr_c = arrow(pos=craft.pos, axis=F_cE * Fscale, color=color.yellow)
arr_E = arrow(pos=Earth.pos, axis=-F_cE * Fscale, color=color.yellow)


