#! /usr/local/bin/python3.3


# soln_sjubaer_hh.py
# The Hodgkin Huxley equation is a model that predicts voltage and 
# propagation through a neuron. 
#
# Approximate the solution of the Hodgkin-Huxley equation
# Use a 4th order Runge=Kutta numerical method to solve the ODE
# Use only standard Python, no NumPy
 

import matplotlib.pyplot as plt     # used for plotting results
import numpy as np                  # used only for constants, exponents, and such
import soln_hw3_sjubaer as soln     # import irange() and rk() methods from HW 3

# Note:  HH defines Vm = Vo-Vi, whereas we typically define Vm = Vi-Vo so using
# these constants and Eq. 26, 7, 15, and 16 will require flipping Vm at the end
# to get it to plot with the polarity we're accustomed to seeing: rising phase
# during transient inward sodium current and falling phase during delayed outward
# potassium current.


# Constants
# Define gna_bar, gk_bar, gl_bar, Vk, Vna, Vl, and Cm
# All from Table 3 on page 520 of the Hodgkin, Huxley, 1952 paper

global gna_bar
global gk_bar
global Vk
global Vna
global Vl
global Cm
gna_bar = 120    #m.mho/cm^3
gk_bar = 36      #m.mho/cm^3
gl_bar = 0.3     #m.mho/cm^3   
Vk = 12          #mV
Vna = -115       #mV
Vl = -10.613     #mV
Cm = 1           #uF/cm^3

# First of four 1st order ODEs
# This one solves for Vm': equation (26) in the Hodgkin, Huxley, 1952 paper
# Im = Cm*dVm/dt + gk_bar*n^4*(V-Vk) + gna_bar*m^3*h*(V-Vna) + gl_bar*(V-Vl)
# dVm/dt = (Im - (gk_bar*n^4*(V-Vk) + gna_bar*m^3*h*(V-Vna) + gl_bar*(V-Vl))) / Cm
def vmp_eq_26(step, Vnmh):
    V = Vnmh[0]
    n = Vnmh[1]
    m = Vnmh[2]
    h = Vnmh[3]
    Im = 0
    vm_prime = (Im - (gk_bar*(n**4)*(V-Vk) + gna_bar*(m**3)*h*(V-Vna) + gl_bar*(V-Vl))) / Cm
    return vm_prime


# Second of four 1st order ODEs
# This one solves for n: equation (7) in the Hodgkin, Huxley, 1952 paper
# dn/dt = alpha_n * (1 - n) - beta_n * n
def np_eq_7(step, Vnmh):
    V = Vnmh[0]
    n = Vnmh[1]
    alpha_n = .01*(V+10)/(np.exp((V+10)/(10))-1)
    beta_n = .125*np.exp(V/80)
    n_prime = alpha_n * (1 - n) - beta_n * n
    return n_prime


# Third of four 1st order ODEs
# This one solves for m: equation (15) in the Hodgkin, Huxley, 1952 paper
# dm/dt = alpha_m * (1 - m) - beta_m * m
def mp_eq_15(step, Vnmh):
    V = Vnmh[0]
    m = Vnmh[2]
    alpha_m = (0.1*(V+25))/(np.exp((V+25)/(10))-1)
    beta_m = 4*np.exp(V/18)
    m_prime = alpha_m * (1 - m) - beta_m * m
    return m_prime


# Fourth of four 1st order ODEs
# This one solves for h: equation (16) in the Hodgkin, Huxley, 1952 paper
# dh/dt = alpha_h * (1 - h) - beta_h * h
def hp_eq_16(step, Vnmh):
    V = Vnmh[0]
    h = Vnmh[3]
    alpha_h = .07*np.exp(V/20)
    beta_h = 1/(np.exp((V+30)/10)+1)
    h_prime = alpha_h * (1 - h) - beta_h * h    
    return h_prime


# Now put soln_YOURNAME_nthorder.rk() through it's paces
if __name__ == '__main__':
    # Your code here
    N = 10
    start = 0
    stop = 10
    h = (stop-start)/(N-1)
    interval = list(i for i in soln.irange(start,stop,h))
    # Stimulate the neuron:
    # Recall that HH defines Vm as our -Vm, so a starting Vm=-15 corresponds to
    # a 15 mV depolarizating post-synaptic potential. Similarly, current is 
    # defined by HH as flowing in to the cell, so Je=-200 corresponds to a
    # depolarizing current of 200 uA/cm^2
    print('You can stimulate the neuron with either a current pulse or a PSP')
    stim = input('For a current pulse enter "I", for a PSP enter "V". \n>> ')
    if stim == 'V' or stim == 'v':
        Vm0 = -1 * float(input('Please enter post-synaptic potential amplitude in mV: \n>> '))
        Je = [0 for i in interval]
    elif stim == 'I' or stim == 'i':
        tstart = float(input('Please enter current pulse start time in ms: \n>> '))
        # For example tstart = 1 ms
        tstop = float(input('Please enter current pulse stop time in ms: \n>> '))
        # For example tstart = 1.05 ms
        Je_amp = -1 * float(input('Please enter depolarizing current amplitude in uA/cm^2: \n>> '))
        # For example Je_amp = -200 mA / cm^2
        Vm0 = -65
        Je = [Je_amp if i >= tstart and i < tstop else 0 for i in interval]
        Vm0 = Cm/Je_amp * (tstop-tstart)
    else:
        print('Running with no stimulus.')

    # Find membrane voltage Vm, and the ionic currents Jk and Jna
    ano = .01*(Vm0+10)/(np.exp((Vm0+10)/(10))-1)
    bno = .125*np.exp(Vm0/80)
    amo = (0.1*(Vm0+25))/(np.exp((Vm0+25)/(10))-1)
    bmo = 4*np.exp(Vm0/18)
    aho = .07*np.exp(Vm0/20)
    bho = 1/(np.exp((Vm0+30)/10)+1)
    
    n0 = ano/(bmo+amo)
    m0 = amo/(bmo+amo)
    h0 = aho/(bho+aho)
    initial_values = [Vm0,n0,m0,h0]                        # Define a list of initial values here
    odes = [vmp_eq_26,np_eq_7,mp_eq_15,hp_eq_16]             # Define a list of ode's here
    # Solve as system of four 1st order ODEs
    solution = soln.rk(odes,interval,h,initial_values)      # Use nth order soln.rk to solve for u1, u2, etc...
    # Remember note:  HH defines Vm = Vo-Vi, whereas we define Vm = Vi-Vo so using
    # the constants above and Eq. 26, 7, 15, and 16 requires flipping Vm here
    Vm = [-1*row[0] for row in solution]                                   # Extract Vm from solution here
    n =  [row[1] for row in solution]                                   # Extract n from solution here
    Jk = [gk_bar*(i**4)*(j-Vk) for i,j in zip(n,Vm)]                    # Calculate Jk from n here
    m = [row[2] for row in solution]                                    # Extract m from solution here
    h = [row[3] for row in solution]                                    # Extract h from solution here
    Jna = [gna_bar*(a**3)*b*(c-Vna) for a,b,c in zip(m,h,Vm)]           # Calculate Jna from m and h here
    # Plot
    figure1 = plt.figure(figsize=(10,10))
    figure1.suptitle("Numerical Approximations of Hodgkin-Huxley",
    fontsize=14, fontweight='bold')
    subplot = figure1.add_subplot(311)      # 1 x 1 subplots in plot; this is subplot1
    subplot.set_title('Stimulus Current Je')
    subplot.set_ylabel('Je (uA/cm^2)')
    subplot.plot(interval, Je, 'k')
    subplot = figure1.add_subplot(312)      # 1 x 1 subplots in plot; this is subplot1
    subplot.set_title('Membrane Voltage Vm')
    subplot.set_ylabel('Voltage (mV)')
    subplot.plot(interval, Vm, 'r.')
    subplot = figure1.add_subplot(313)      # 1 x 1 subplots in plot; this is subplot1
    subplot.set_title('Transient inward Na current (blue) and delayed outward K current (green)')
    subplot.set_xlabel('time (ms)')
    subplot.set_ylabel('Jion (uA/cm^2)')
    subplot.plot(interval, Jna, 'b', interval, Jk, 'g')
    plt.show()
