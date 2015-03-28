/* 
This code real-time detects seizures in mice.
The code is designed to be efficient and take up 
as little microcontroller clocktime as possible.
This code should be able to be ported into a 
microcontroller and implanted into a living mouse.
*/

# include <stdio.h>
int threshold=150;      //116.3955+(3.5*1.0699); Rounded because EFFICIENCY!
int size=2;
int seizure_detect(int data[]){
    int average=0;
    int i=0;
    while (i < size){
        average = data[i] + average;
        i = i++;}
    average = average >> 1;
    if ((average <= threshold)||(average >= (threshold+3))){
        return 0;}
    else{
        return 1;}
}

int main(){
    FILE *file = fopen("TrainingData.bin","rb");        /*  OPEN FILE */
    FILE *f = fopen("output.csv","w");
    int check,i=0;                               /*  INITIALIZE VARIABLES */
    int j = 0;
    int raw_data[size];
    int output_data;
    int detect;
    while (EOF != fgetc(file)){       //Check for end of file
        i = 0;
        while (i < size){                  //while not EOF run fgetc to 512
            raw_data[i] = fgetc(file);
            i = i++;}
            output_data = seizure_detect(raw_data);
            fprintf(f,"%d\n", output_data);
            j = j++;}
    fclose(f);
    fclose(file);
    printf("j = %d\n",j);
    return 0;}
