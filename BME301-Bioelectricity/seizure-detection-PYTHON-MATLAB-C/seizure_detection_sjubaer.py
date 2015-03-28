import math as m
import matplotlib.pyplot as plt
import csv
def seizure_detect(data):
    window_size = 175
    std_factor = 1
    N = len(data)
    remainder = N%window_size
    K = m.trunc(N/window_size)
    i = 0
    decision = []
    while i < K:
        window = []
        j = i
        while j < window_size:
            window.append(data[j])
            j+=1
        average = sum(window)/len(window)
        runsum = 0
        k = 0
        while k < window_size:
            runsum += (window[k]-average)**2
            k+=1
        std = m.sqrt(runsum/len(window))
        p_threshold = average + std*std_factor
        n_threshold = average - std*std_factor
        if data[i] >= p_threshold or data[i] <= n_threshold:
            decision.append(1)
        else:
            decision.append(0)
        print(i)
        i+=1

    if remainder != 0:
        b = 0
        window_s = remainder
        full_stop = i
        window = []
        while i < (full_stop+remainder):
            window.append(data[i])
            i+=1
        average = sum(window)/len(window)
        runsum = 0
        k = 0
        while k < len(window):
            runsum+=(window[k]-average)**2
            k+=1
        std = m.sqrt(runsum/len(window))
        p_threshold = average + std*std_factor
        n_threshold = average - std*std_factor
        i = full_stop
        while i < len(window):
            if data[i] >= p_threshold or data[i] <= n_threshold:
                decision[i] = 1
            else:
                decision[i] = 0
            i+=1
    return decision

#RUN FUNCTION IN A WHILE LOOP THAT IS THE LENGTH OF THE DATA ARRAY
#LOOP MUST BE SIZE GREATER THAN ONE

fin = open('TrainingData.bin','rb')
dataList = fin.read()
fin.close()
i = 0
dataList = seizure_detect(dataList)

fout = open('DetectionResults.bin','wb')
fout.write(bytearray(dataList))
fout.close()

#---------------------------------------------------------------------

correct = []
i = 0
a = 0
b = 0
c = 0
d = 0
while i < 280000:
    if dataList[i] == 0:
        d+=1
    else:
        b+=1
    i+=1
while i <1010000:
    if dataList[i] == 1:
        a+=1
    else:
        c+=1
    i+=1
while i < 1470000:
    if dataList[i] == 0:
        d+=1
    else:
        c+=1
    i+=1
while i < 2030000:
    if dataList[i] == 1:
        a+=1
    else:
        c+=1
    i+=1
while i < 2360000:
    if dataList[i] == 0:
        d+=1
    else:
        b+=1
    i+=1
while i < 2530000:
    if dataList[i] == 1:
        a+=1
    else:
        c+=1
    i+=1

sensitivity = a/(a+c)
specificity = d/(b+d)
#print('Sensitivity = ',sensitivity)
print('Specficity = ',specificity)
plt.plot(dataList)
plt.show()
        
