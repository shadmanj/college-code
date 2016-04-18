// Sweep
// by BARRAGAN <http://barraganstudio.com> 
// This example code is in the public domain.


#include <Servo.h> 
 
Servo myservo;  // create servo object to control a servo 
                // a maximum of eight servo objects can be created 
 
int pos = 0;    // variable to store the servo position 
int b1 = 13;
int b2 = 12;
int buttonState1 = 0;
int buttonState2 = 0;

void setup() 
{ 
  myservo.attach(9);  // attaches the servo on pin 9 to the servo object 
  pinMode(b1,INPUT_PULLUP);
  pinMode(b2,INPUT_PULLUP);
  myservo.write(0);
  Serial.begin(9600);
} 
 
 
void loop() 
{ 
  
  int buttonState1 = digitalRead(b1);
  int buttonState2 = digitalRead(b2);
  
  if (!buttonState1){
    if (pos < 180){
      pos += 1;
      myservo.write(pos);
      Serial.println(pos);
      delay(15);
    }
    else{
      pos -= 1;
    }
  }
  
  else if (!buttonState2){
    if (pos > 0){
      pos -=1;
      myservo.write(pos);
      Serial.println(pos);
      delay(15);
    }
    
    else {pos += 1;}
  }
  
//  if (pos > 180){
//    pos = 0;
//  }
//  
//  if (pos < -180){
//    pos = 0;
//  }
} 
