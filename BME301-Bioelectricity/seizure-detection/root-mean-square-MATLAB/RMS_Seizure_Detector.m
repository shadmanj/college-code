clear
clc
%function [detect] = RMS_Seizure_Detector(EEG_Detector)
%% Initialize Variables
%R = EEG_Detector;
R = csvread('averages.csv');
size = length(R);

SampleRate = 399.6098; %Hz
SamplePeriod = (1/SampleRate)/3600; %seconds
time = (1:1:size)*SamplePeriod;
WindowMin = 1.5;  %Window size in minutes
WindowSize = 400*60*WindowMin; %Window size of two minutes
Windows = floor(size/WindowSize); %This is the number of complete chunks in the data
RemWindow = ((size/WindowSize)-Windows)*WindowSize; %The number of data points that don't fill a complete chunk, near the end of the set
Chunk = 1;
DataPoint = 1;
R = zeros(Windows,1); %Column of zeros, this will be filled with our RMS values

 %% Calculate RMS
 while Chunk <= Windows %Fills out the RMS values for every complete chunk
     runsum = 0;
     x = 1;
     while x <= WindowSize %Scans through each chunk region and calculates that chunks RMS
         if DataPoint <= size
             runsum = runsum + data(DataPoint)^2;
             DataPoint = DataPoint + 1;
         end
         x = x+1;
     end
     runsum = sqrt(runsum / WindowSize);
     R(Chunk) = runsum; %Put the chunk's RMS into the R
     Chunk = Chunk + 1;
 end
     if RemWindow ~=0 %If there is any data not in a chunk (because it didn't fill a chunk completely) the RemWindow will have a nonzero value, this will get the RMS value for the leftover data
         x = 1;
         runsum = 0;
         
         while x <= RemWindow
             runsum = runsum + data(DataPoint)^2;
             DataPoint = DataPoint+1;
             x = x+1;
         end
         runsum = sqrt(runsum/WindowSize);
         R(Chunk) = runsum; %Due to the setup of the upper code, it ends with Chunk being one plus the actual number of whole chunks. Hence the potentially confusing Chunk count not iteration between the upper and lower code
     end
     
 if RemWindow == 0 
 bar([1:1:Chunk-1],R); %Remember the setup of the upper code leaving the Chunk value at one plus Windows? To plot, we have to correct this.
 elseif RemWindow ~= 0 
 end

%% Seizure Detection
thresh = mean(R)+std(R); %Calculate threshold value based on STD from mean of RMS curve
num_seiz = 0;           %Number of detected seizures
i = 1;
j = 1;
while i <= length(R) 
    if R(i) > thresh; %If EEG exceeds threshold value, get point of interest
        if i == length(R)
            if R(i-1) < thresh
                num_seiz = num_seiz + 1;
                SeizLoc(i) = R(i);
            else
                SeizLoc(i) = -200;
            end
        elseif R(i+1) < thresh %Filter for multiple positives of same seizure
            num_seiz = num_seiz + 1;
            SeizLoc(i) = R(i);
        else
            SeizLoc(i) = -200;
        end
    else
        SeizLoc(i) = -200;
    end
     TimeDisp(i) = WindowMin*i;
     Threshold(i) = thresh;
     MeanLine(i) = mean(R);
    i = i+1;
end

if num_seiz ~= 0
    detect = 1;
else 
    detect = 0;
end

%% Plots
plot(R);
std(R)
mean(R)
thresh = mean(R)+4*std(R)

 figure;
 scatter(TimeDisp,SeizLoc,100,'r','fill');
 title('Detected Seizures vs. RMS of EEG Voltage Over Time');
 xlabel('Time (min)');
 ylabel('RMS of EEG (mV)');
 axis([0 TimeDisp(i-1) 0 50]);
 hold on
 plot(TimeDisp,R);
 plot(TimeDisp,Threshold,'-.r');
 plot(TimeDisp,MeanLine,'-.black');
%end