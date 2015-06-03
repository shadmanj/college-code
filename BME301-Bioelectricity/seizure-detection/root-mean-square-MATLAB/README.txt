The two scripts in this folder provide a proof of concept for 
detecting seizures by detecting variance from the root-mean-square
of a window of EEG data using MATLAB. 

RMS_SD_Shell.m runs the function RMS_Seizure_Detector.m to read
EEG data from a .csv file and calculate seizure locations. The 
program outputs the seizure locations to a .csv file where detected
seizures are shown as 1's and no seizures are shown as 0's. The data
is also displayed in graphical form with the seizure locations 
overlaid onto the EEG data.
