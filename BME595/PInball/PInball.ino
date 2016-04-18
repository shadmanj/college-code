#include <Servo.h>
#include <SPI.h>
#include <LiquidCrystal.h>
LiquidCrystal(10,3,4,5,6,7)

Servo myservo;

const int xpin = A0;
const int ypin = A1;
const int rButton = 9;
const int rServo = 2;
const int led1 = 11;
const int led2 = 12;
const int led3 = 13;

int rButtonState=LOW;
int rServoPos = 0;
int xPrev = -1;
int yPrev = -1;
int points = 0;

void setup(){
Serial.begin(9600);
lcd.begin(16,7);
lcd.print("Welcome!");
myservo.attach(2);
myservo.write(0);
analogReference(EXTERNAL); //To avoid the contribution from the 3.3V in the analog inputs.
 // You will need to bridge the 3.3V & the AREF of the Arduino Board.
 pinMode(led1, OUTPUT);
 pinMode(led2, OUTPUT);
 pinMode(led3, OUTPUT);
 pinMode(xpin,INPUT);
 pinMode(ypin,INPUT);
 pinMode(rButton,INPUT);
 pinMode(rServo,OUTPUT);
 
 digitalWrite(led1, HIGH);
 digitalWrite(led2, HIGH);
 digitalWrite(led3, HIGH);
}

void loop(){
 readAccelerometer();
 rButtonState = digitalRead(rButton);
 if (rButtonState == LOW){
   if( rServoPos < 90){
     rServoPos = rServoPos + 5;
     myservo.write(rServoPos);
     delay(10);
   }
 }
 
 else{
   rServoPos = 0;
   myservo.write(rServoPos);
   delay(10);
 }
 

}
//------------------------------------------------------------
boolean readAccelerometer(){
 //Reading the XYZ acelerometers of the ADXLS335:
 int x = analogRead(xpin)-512;  //read from xpin
 delay(1); //A small delay between analogReadings avoid any contamination of the reading from leaking currents.
 int y = analogRead(ypin)-450;  //read from ypin
 int xBuffer1;
 int xBuffer2;
 int yBuffer1;
 int yBuffer2;
 delay(10);
 Serial.print(x);
 Serial.print("\t");
 Serial.print(y);
 Serial.print("\n");
}
