#include <math.h>

//CONSTANTS
float cFactor = 0.0137;
float fFactor = 1.8;

//PINS
int potentiometer = A0;
int button2 = 13;
int button1 = 12;
int warmingLED = 11;
int coolingLED = 10;
int warningLED = 9;
int thermistor = A5;
int buzzer = 8;

//SIGNIFICANT VARIABLES
float Tsp;
float tempOut;

//STATE VARIABLES
int b1 = LOW;
int b2 = LOW;

//Toggle fahrenheit or celsius mode
char toggle = 'c';

//Maximum and minimum values
double maximum = 0;
double minimum = 0;
double maximumF;
double minimumF;



void setup(){
	pinMode(potentiometer,INPUT);
	pinMode(button1,INPUT);
	pinMode(button2,INPUT);
	pinMode(warmingLED,OUTPUT);
	pinMode(coolingLED,OUTPUT);
	pinMode(warningLED,OUTPUT);
	pinMode(thermistor,INPUT);
	pinMode(buzzer, OUTPUT);
	Serial.begin(9600);
}

void loop(){
	digitalWrite(warmingLED,LOW);
	digitalWrite(coolingLED,LOW);

	//Read potentiometer and set Tsp
	int pot = analogRead(potentiometer);
	Tsp = degreesC(pot);

	//Read thermistor and set temperature
	int readVal = analogRead(thermistor); //Gets the readout from the Temp sensor.	
	tempOut =  Thermistor(readVal); //Sends the readout to the function that calculate the real Temp in Celsius
	
	determineAlarm();

	convertTemp();

	findMaxMin();

	//Print statements
	if (b1 == HIGH && b2 == LOW){
		Serial.print("Tmax = ");
		Serial.print(maximum);
		Serial.print(" C; Tmin = ");
		Serial.print(minimum);
		Serial.print(" C\n");
          
        }
        
        else if (b1 == HIGH && b2 == HIGH){
		Serial.print("Tmax = ");
		Serial.print(degreesF(maximum));
		Serial.print(" F; Tmin = ");
		Serial.print(degreesF(minimum));
		Serial.print(" F\n");
        }
  else if (b1 == LOW && b2 == LOW){
		Serial.print("T = ");
		Serial.print(tempOut);
		Serial.print(" C; Tsp = ");
		Serial.print(Tsp);
		Serial.print(" C\n");
  }
	else  {
		Serial.print("T = ");
		Serial.print(tempOut);
		Serial.print(" F; Tsp = ");
		Serial.print(Tsp);
		Serial.print(" F\n");

}

	delay(100);
}

//===============================================================================

//Determine if tempOut > or < Tsp
void determineAlarm(){
	if (tempOut < (Tsp-5) || tempOut > (Tsp+5)){
    	  digitalWrite(buzzer, HIGH);   // turn the LED on (HIGH is the voltage level)
    	  delay(10);              // wait for a second
    	  digitalWrite(buzzer, LOW);    // turn the LED off by making the voltage LOW
    	  delay(10);              // wait for a second
 	  digitalWrite(warningLED, HIGH);
          digitalWrite(coolingLED, LOW);
          digitalWrite(warmingLED, LOW);
	}

	//Turn on lEDs depending on cooling or warming if the inubator is functioning
	//correctly
	else if (tempOut < Tsp){
		digitalWrite(warmingLED,HIGH);
	}

	else if (tempOut > Tsp){
		digitalWrite(coolingLED,HIGH);
	}
        
        else{
                digitalWrite(coolingLED, LOW);
                digitalWrite(warmingLED, LOW);
        }
}

//Print maximum and minimum values
void printMaxMin(){
	if (b2 == LOW){
		Serial.print("Tmax = ");
		Serial.print(maximum);
		Serial.print(" C; Tmin = ");
		Serial.print(minimum);
		Serial.print(" C\n");
	}

	else {
		Serial.print("Tmax = ");
		Serial.print(maximumF);
		Serial.print(" F; Tmin = ");
		Serial.print(minimumF);
		Serial.print(" F\n");
	}
}

//Calculate max and min temperatures
void findMaxMin(){
	if (tempOut > maximum){
		maximum = tempOut;
		maximumF = degreesF(maximum);
	}
	else if (tempOut < minimum){
		minimum = tempOut;
		minimumF =  degreesF(minimum);
	}
}

//Print temperature and Tsp
void printTemp(){
  if (b2 == LOW){
		Serial.print("T = ");
		Serial.print(tempOut);
		Serial.print(" C; Tsp = ");
		Serial.print(Tsp);
		Serial.print(" C\n");
  }
	else if (b2 == HIGH){
		Serial.print("T = ");
		Serial.print(tempOut);
		Serial.print(" F; Tsp = ");
		Serial.print(Tsp);
		Serial.print(" F\n");
        }
}

//Convert to degrees celsius
float degreesC(int pot){
	float c;
	return c = cFactor*(pot) + 24;
}

//convert to degrees fahrenheit
float degreesF(int c){
	float f;
	return f = (c * 9.0)/ 5.0 + 32.0; 
}

double Thermistor(int RawADC){
	double tempC; //Temperature in Celsius
	tempC = log(10000.0 * ((1024.0 / RawADC - 1)));
	tempC = 1 / (0.001129148 + (0.000234125 + (0.0000000876741 * tempC * tempC )) * tempC );
	tempC = tempC - 273.15;            // Convert Kelvin to Celcius
	//Temp = (Temp * 9.0)/ 5.0 + 32.0; // Convert Celcius to Fahrenheit
	return tempC;
}

//Convert temperature to F or C based on button press
void convertTemp(){
	//Button 2 is pressed, and temperature is displaying Celsius, switch to Fahrenheit
	if (b2 == HIGH){
		tempOut = degreesF(tempOut);
	}
}
