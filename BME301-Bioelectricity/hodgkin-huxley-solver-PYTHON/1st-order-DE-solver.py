# Shadman Jubaer
# BME 301
# 1st Order ODE Solver
#
#
# These functions will numerically solve any first order differential
# equation of the form dy/dx = f(x) using either Euler or Runge-Kutta
# numerical solving methods.

#------------------------------------------------------------
#import matplotlib.pyplot as plt
import math as m
#Generates interval over which to solve numerically
def irange(start,stop,step):
    while start < stop:
        yield start
        start += step

#Solves 1st Order ODE using Euler
def euler(ode,interval,step_size,initial_value):
    yi = initial_value
    y = []
    for i in interval:
        y.append(yi + step_size*ode(i))
    return y    

#Solves 1st Order ODE using Runge-Kutta
def rk(ode,interval,step_size,initial_value):
    yi = initial_value
    y = []    
    h = step_size
    for i in interval:
                k1 = ode(i)
                k2 = ode(i+(h/2))
                k3 = ode(i+(h/2))
                k4 = ode(i+(h))	
                y.append(yi + h*((k1 + k2*2 + k3*2 + k4)/6))
    return y

#------------------------------------------------------------

#Test ODE to solve. dy/dx = 2x so y = x^2+C
def ode(x):
	return m.sin(x)
'''
#-------------------                -------------------------
#-------------------      TEST      -------------------------
#-------------------                -------------------------

start = 0                                         #start of interval
initial_value = .001                                   #initial y value
stop = 20                                            #end of interval
N = 100                                              #Number of steps
step = (stop-start)/(N-1)                           #Calculates h values
interval = list(i for i in irange(start,stop,step))     #Generates array of input values
answer_euler = euler(ode,interval,step,initial_value) #Calculate euler solution
answer_rk = rk(ode,interval,step,initial_value)     #Calculate runge-kutta solution

#-----------------------PRINT RESULTS------------------------

#print("Euler:\n")
#print("\n")
#print("Runge-Kutta\n")
#print(answer_rk)
#print("\n")
#print(interval)

t = interval
plt.plot(t,answer_euler,'blue',t,answer_rk,'red')
plt.show()
'''
