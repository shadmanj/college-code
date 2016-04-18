#include <SPI.h>
#include<LiquidCrystal.h>
LiquidCrystal lcd(12,11,5,4,3,2);


int pot = A0;

void setup(){
  lcd.begin(16,2);
  lcd.print("hello, world");
  pinMode(pot,INPUT);
}

void loop(){
  lcd.setCursor(0,1);
  lcd.print(millis()/1000);
  lcd.setCursor(0,7);
  lcd.print(analogRead(pot));
}
