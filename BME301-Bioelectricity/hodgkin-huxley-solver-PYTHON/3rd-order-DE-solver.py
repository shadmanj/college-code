# Shadman Jubaer
#BME 301
#These functions will solve any nth order differential equation using
#the 4th Order Runge-Kutta Method of numerically solving differntial
#equations

import numpy as np
import matplotlib.pyplot as plt

#Generates interval over which to solve numerically
def irange(start, stop, step):
    while start < stop:
        yield round(start,4)
        start += step

#Function to solve ODEs using 4th Order Runge-Kutta
#Inputs: list of u functions, x-interval, step sizes, initial values
#Outputs: Matrix with numerical solutions for each ode function
def rk(odes, interval, step, initial_values):
    h = step
    h2 = h/2
    u = initial_values
    M = len(odes)       #length of ODE array. Determines order of ODE
    N = M - 1           #converts M for indexing
    soln = []           #Main output array
    for x in interval:  #increment by points over the interval
        #Iniitalize k arrays for the loops
        k1 = []         
        k2 = []
        k3 = []
        k4 = []
        output = []     #stores solved u values

        #Find k1 at x for all ODEs
        #k1 = f(x,u)
        i = 0
        while i < M:
            k1_new = odes[i](x, u)
            k1.append(k1_new)
            i += 1
        hk1 = [z*h2 for z in k1]
        u_temp = [z+i for z, i in zip(hk1, u)]

        #Find k2 at x for all ODEs
        #k2 = f(x+(h/2),u+(1/2)*k1)
        i = 0    
        while i < M:
            k2_new = odes[i](x+h2,u_temp)
            k2.append(k2_new)
            i += 1
        #Multiply all k values by h
        hk2 = [z*h2 for z in k2]
        #Make new incrementl u value
        u_temp = [z+i for z, i in zip(hk2, u)]

        #Find k3 at x for all ODEs
        #k3 = f(x+(h/2),u+(1/2)*k2)
        i = 0
        while i < M:
            k3_new = odes[i](x+(1/2), u_temp)
            k3.append(k3_new)
            u_temp.append(u[i] + k3_new)
            i += 1
        hk3 = [z*h2 for z in k3]
        u_temp = [z+i for z, i in zip(hk3, u)]
        
        #Find k4 at x for all ODEs
        #k4 = f(x+(h/2),u+k3)
        i = 0
        while i < M:
            k4_new = odes[i](x+(h/2), u_temp)
            k4.append(k4_new)
            i += 1
            
        k_bar = [(a+2*(b+c)+d)/6 for a,b,c,d in zip(k1,k2,k3,k4)]

        #Find kbar and then solve u values for all ODEs
        #kbar = (k1+k2*2+k3*2+k4)/6
        #u = u + h*kbar
        i = 0
        while i < M:
            u_i = u[i] +(h*k_bar[i])
            u[i] = u_i
            output.append(u_i)
            i += 1
        soln.append(output)
    return soln

#-----------------------------------------------------------
'''
def np_eq_7(step,Vnmh):
    V = Vnmh[0]
    n = Vnmh[1]
    alpha_n = .01*(V+10)/(np.exp((V+10)/(10))-1)
    beta_n = .125*np.exp(V/80)
    n_prime = alpha_n * (1 - n) - beta_n * n
    return n_prime

def mp_eq_15(step, Vnmh):
    V = step
    m = Vnmh[2]
    V = Vnmh[0]
    alpha_m = 0.1*(V+25)/(np.exp((V+25)/10)-1)
    beta_m = 4*np.exp(V/18)
    m_prime = alpha_m * (1 - m) - beta_m * m
    return m_prime

def hp_eq_16(step, Vnmh):
    V = Vnmh[0]
    h = Vnmh[3]
    alpha_h = .07*np.exp(V/20)
    beta_h = 1/(np.exp((V+30)/10)+1)
    h_prime = alpha_h * (1 - h) - beta_h * h    
    return h_prime

def vmp_eq_26(step, Vnmh):
    gna_bar = 120    #m.mho/cm^3
    gk_bar = 36      #m.mho/cm^3
    gl_bar = 0.3     #m.mho/cm^3   
    Vk = 12          #mV
    Vna = -115       #mV
    Vl = -10.613     #mV
    Cm = 1           #uF/cm^3
    V = Vnmh[0]
    n = Vnmh[1]
    m = Vnmh[2]
    h = Vnmh[3]
    gna = (np.power(m,3))*h*gna_bar
    gk = (np.power(n,4))*gk_bar
    Ina = gna*(V-Vna)
    Ik = gk*(V-Vk)
    Il = gl_bar*(V-Vl)
    Im = Ina+Ik+Il
    vm_prime = (Im - (gk_bar*(n**4)*(V-Vk) + gna_bar*(m**3)*h*(V-Vna) + gl_bar*(V-Vl))) / Cm
    return vm_prime


def ode_u1(x,u):
    u1_prime = u[1]
    return u1_prime

def ode_u2(x,u):
    u2_prime = -np.sin(x)
    return u2_prime

#------------------------------------------------------------

start = 1
stop = np.pi*5
N = 100
h = (stop-start)/(N-1)
x_hw = list(irange(start,stop,h))
u1 = 0
u2 = 0
u3 = 56
u4 = 5
rk_ans = rk([ode_u1,ode_u2], x_hw, h, [u1,u2])
ans = [row[0] for row in rk_ans]
#y = [m.sin(step) for step in x_hw]
t = x_hw
plt.plot(x_hw, ans, 'red')
plt.show()

'''
