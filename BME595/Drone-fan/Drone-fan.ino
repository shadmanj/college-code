#include "SPI.h"
// Accelerometer Inputs
int x_accel = A3;
int y_accel = A2;
int z_accel = A1;
int acc_Vector[3] = {0,0,0};
int acc_Mag;

// Motor variables
int motor = 10;


//Outputs

/** SETUP **/
void setup() {
  //Begin Serial monitor
  Serial.begin(9600);
  //Initialize Accelerometer pins
  analogReference(EXTERNAL); 	//Avoid interference on 3.3V pin
  pinMode(x_accel, INPUT);	
  pinMode(y_accel, INPUT);
  pinMode(z_accel, INPUT);  

  //Motor Initialize
  pinMode(motor, OUTPUT);
}
/** LOOP **/
void loop() {
  acc_Mag = readAccelerometer();
  runMotor(acc_Mag);
}

/** READ FROM ACCELEROMETER **/
int readAccelerometer(){
  int x = analogRead(x_accel)-511;
  int y = analogRead(y_accel)-525;
  int z = analogRead(z_accel)-616;	
  acc_Vector[0] = x;
  acc_Vector[1] = y;
  acc_Vector[2] = z;
  acc_Mag = sqrt(x^2 + y^2 + z^2)+230;
  Serial.println(acc_Mag);
  //Serial.println(acc_Vector[1]);
  return acc_Mag;
}

void runMotor(int rpm){
  analogWrite(motor, rpm);
  delay(100);
}

