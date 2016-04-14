#Shadman Jubaer
#BME 301
#HW 2
#These functions will numerically solve a second order differential
#equation using either Euler or Runge-Kutta numerical solving methods.

#------------------------------------------------------------
import math as m
import matplotlib.pyplot as plt

#Generates interval over which to solve numerically
#Interval created between a start and stop value with
#a given step-size.
def irange(start,stop,step):
    while start <= stop:
        yield start
        start += step

#Solves 2nd Order ODE using Euler
#Input arguments:
#ode_u1 = y'(t)
#ode_u2 = y''(t)
#interval: x domain over which to solve
#initial_value_u1: initial y value
#initial value_u2: initial y' value
#Outputs:
#y: numerically solved y(t) values
#yp: numerically solved y'(t) values
def euler(ode_u1,ode_u2,interval,step_size,initial_value_u1,initial_value_u2):
    u1 = initial_value_u1
    u2 = initial_value_u2
    h = step_size
    y = []
    yp = []
    for i in interval:
                u2 = u2 + h*ode_u2(i,u1,u2)
                yp.append(u2)
                u1 = u1 + h*ode_u1(i,u1,u2)
                y.append(u1)
    return y, yp    

#Solves 2nd Order ODE using Runge-Kutta
#Solves 2nd Order ODE using Euler
#Input arguments:
#ode_u1 = y'(t)
#ode_u2 = y''(t)
#interval: x domain over which to solve
#initial_value_u1: initial y value
#initial value_u2: initial y' value
#Outputs:
#y: numerically solved y(t) values
#yp: numerically solved y'(t) values
def rk(ode_u1,ode_u2,interval,step_size,initial_value_u1,initial_value_u2):
    u1 = initial_value_u1
    u2 = initial_value_u2
    h = step_size
    y = []
    yp = []
    for i in interval:
                k1p = ode_u2(i,u1,u2)
                k2p = ode_u2(i+(h/2),u1,u2)
                k3p = ode_u2(i+(h/2),u1,u2)
                k4p = ode_u2(i+(h),u1,u2)
                u2 = u2 + h*((k1p + k2p*2 + k3p*2 + k4p)/6)		
                yp.append(u2)
                k1 = ode_u1(i,u1,u2)
                k2 = ode_u1(i+(h/2),u1,u2)
                k3 = ode_u1(i+(h/2),u1,u2)
                k4 = ode_u1(i+(h),u1,u2)
                u1 = u1 + h*((k1 + k2*2 + k3*2 + k4)/6)
                y.append(u1)
    return y, yp

#----------------------- TEST FUNCTIONS ---------------------
'''
#Returns y'
def u1(t,u1,u2):
    u1_prime = u2
    return u1_prime

#y'' = -sin(t)
def u2(t,u1,u2):
    u2_prime = -m.sin(t)
    return u2_prime
    
#-------------------                -------------------------
#-------------------      TEST      -------------------------
#-------------------                -------------------------

start = 0
stop = 50*m.pi
N = 1000
h = (stop-start)/(N-1)
x_hw = list(i for i in irange(start,stop,h))
y_initial = m.sin(start)
y_prime_initial = m.cos(start)
ans_euler, ans_eulerp = euler(u1,u2,x_hw, h, y_initial, y_prime_initial)
y_analitical = [m.sin(step) for step in x_hw]
y_analitical_p = [m.cos(step) for step in x_hw]
ans_rk, ans_rkp = rk(u1,u2,x_hw, h, y_initial, y_prime_initial)
#--------------------------------------------------------------
t = x_hw
plt.plot(t, ans_euler, 'blue', t, ans_rk, 'red',t, y_analitical,'green')
plt.show()
#--------------------------------------------------------------
'''
