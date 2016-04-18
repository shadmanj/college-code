#include <SPI.h>
#include <Servo.h>
#include<LiquidCrystal.h>
LiquidCrystal lcd(12,11,5,4,3,2);
Servo myservo;

int pos = 0;
int laser = 8;
int photoR = A0;
int posStop = 0;

void setup(){
  Serial.begin(9600);
  lcd.begin(16,2);
  myservo.attach(9);
  pinMode(laser, OUTPUT);
  pinMode(photoR, INPUT);
  digitalWrite(laser, HIGH);
}

void loop(){
  int r = analogRead(photoR);

  if (posStop == 0){
    for (pos = 0; pos <= 180; pos += 1) { // goes from 0 degrees to 180 degrees
    // in steps of 1 degree
    myservo.write(pos);              // tell servo to go to position in variable 'pos'
    r = analogRead(photoR);
    if (r < 100){
      posStop = pos;
    }
    Serial.print(pos);
    Serial.print("    ");
    Serial.print(posStop);
    Serial.print("\n");
      lcd.setCursor(0,1);
  lcd.print("Searching...");
    delay(15);                       // waits 15ms for the servo to reach the position
  }
  }
  
  else{
    lcd.print("            ");
    myservo.write(0);
    myservo.write(posStop);
    lcd.setCursor(0,1);
    lcd.print(posStop); 
}
  
//  myservo.write(posStop);
//  Serial.println(posStop);
//  for (pos = 180; pos >= 0; pos -= 1) { // goes from 180 degrees to 0 degrees
//    myservo.write(pos);              // tell servo to go to position in variable 'pos'
//    delay(15);                       // waits 15ms for the servo to reach the position
//  }
}
