clear 
clc
data = csvread('output_data.csv');
Seizure = RMS_Seizure_Detector(data);
fprintf('%d \n', Seizure);

