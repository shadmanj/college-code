// Using the Serial Monitor as an INPUT to control your experiments:

// Place 3 LEDs (red, yellow, and green) each of them connected to GND using a 220 Ohm resistor.
// Use 3 digital pins to turn on and off those LEDs.
// Upload this code so when you open the serial monitor ,if you input red, you will see the red LED light up.

const int greenPin= 10; //the green led pin attact to
const int yellowPin= 11; //the yellow led pin attact to
const int redPin= 9; //the red led pin attach to 
String comdata = "";
int lastLength = 0;

void setup()
{
  pinMode(greenPin, OUTPUT); //initialize the greenPin as output
  pinMode(yellowPin, OUTPUT); //initialize the yellowPin as output
  pinMode(redPin, OUTPUT); //initialize the redPin as output
  Serial.begin(9600); // start serial port at 9600 bps:
  Serial.print("Please input any color of LED:"); //print message on serial monitor
}

void loop()
{
  //read string from serial monitor
  if(Serial.available()>0) // if we get a valid byte, read analog ins:
  { 
    comdata = "";
    while (Serial.available() > 0) 
    { 
      comdata += char(Serial.read());
      delay(2);
    }
  Serial.println(comdata);
  }
  if(comdata == "red")
  {
    red();
  }
  else if(comdata == "blue")
  {
    blue();
  }
  else if(comdata == "green")
  {
    green();
  }
  else if(comdata == "white"){
    white();
  }
  else if(comdata == "orange"){
    orange();
  }
  else if(comdata == "yellow"){
    yellow();
  }
  else if(comdata == "indigo"){
    indigo();
  }
  else if(comdata == "purple"){
    purple();
  }
  else if(comdata == "Murica"){
    red();
    delay(500);
    white();
    delay(500);
    blue();
    delay(500);  
  }
  else
  {
    digitalWrite(redPin, LOW);//turn the red led off
    digitalWrite(greenPin, LOW);//turn the green led off
    digitalWrite(yellowPin, LOW);//turn the yellow led off
  } 
}

void red(){
    digitalWrite(redPin, HIGH);//turn the red led on
    digitalWrite(greenPin, LOW);//turn the green led off
    digitalWrite(yellowPin, LOW);//turn the yellow led off
}

void green(){
    digitalWrite(redPin, LOW);//turn the red led off
    digitalWrite(greenPin, HIGH);//turn the green led on
    digitalWrite(yellowPin, LOW);//turn the yellow led off
}

void blue(){
    digitalWrite(redPin, LOW);//turn the red led off
    digitalWrite(greenPin, LOW);//turn the green led off
    digitalWrite(yellowPin, HIGH);//turn the yellow led on
}

void white(){
    digitalWrite(redPin, HIGH);
    digitalWrite(greenPin, HIGH);
    digitalWrite(yellowPin, HIGH);
}

void orange(){
    digitalWrite(redPin, 237);
    digitalWrite(greenPin, 109);
    digitalWrite(yellowPin, 0);
}

void yellow(){
    digitalWrite(redPin, 255);
    digitalWrite(greenPin, 115);
    digitalWrite(yellowPin, 0);
}

void indigo(){
    digitalWrite(redPin, 0);
    digitalWrite(greenPin, 46);
    digitalWrite(yellowPin, 90);
}

void purple(){
    digitalWrite(redPin, 128);
    digitalWrite(greenPin, 0);
    digitalWrite(yellowPin, 128);
}
