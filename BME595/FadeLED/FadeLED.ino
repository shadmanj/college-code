/*
 Fade
 
 This example shows how to fade an LED on pin 9
 using the analogWrite() function.
 
 This example code is in the public domain.
 */

int led = 9;           // the pin that the LED is attached to
int brightness = 0;    // how bright the LED is
int fadeAmount = 5;    // how many points to fade the LED by
int button = 2;
int buttonState;

// the setup routine runs once when you press reset:
void setup()  { 
  // declare pin 9 to be an output:
  pinMode(led, OUTPUT);
  pinMode(button, INPUT);
  Serial.begin(9600);
} 

// the loop routine runs over and over again forever:
void loop()  { 
  buttonState = digitalRead(button);
  if (buttonState==HIGH){
    brightness = brightness + fadeAmount;
    if (brightness == 0 || brightness >= 255) {
      fadeAmount = -fadeAmount;
    }
    analogWrite(led,brightness);
  }
  else if (buttonState == LOW){
    analogWrite(led, 0);
  }  
  delay(30);                            
}

