// NOS LEDs
int l1 = 11;
int l2 = 10;
int l3 = 9;
int l4 = 6;

// BUTTONS
int acc = 5;
int brake = 4;

// BUTTON STATE
int accState = HIGH;
int brakeState = HIGH;

// POTENTIOMETER
int pot = A0;

// POTENTIOMETER STATE
int potState;

// LED STATES
int l1State = HIGH;
int l2State = HIGH;
int l3State = HIGH;
int l4State = HIGH;

void setup(){
  
  Serial.begin(9600);
  
  pinMode(l1, OUTPUT);
  pinMode(l2, OUTPUT);
  pinMode(l3, OUTPUT);
  pinMode(l4, OUTPUT);
  pinMode(acc, INPUT);
  pinMode(brake, INPUT);
  pinMode(pot, INPUT);
  
  //Turn on LEDs
  digitalWrite(l1, l1State);
  digitalWrite(l2, l2State); 
  digitalWrite(l3, l3State);
  digitalWrite(l4, l4State);
  
}

void loop(){
  readPot();
  readButtons();
  printState();
}

///////////////////////////////////////////////////////

void readPot(){
  potState = analogRead(A0);
}

void readButtons(){
  accState = digitalRead(acc);
  brakeState = digitalRead(brake);
  potState = analogRead(pot);
}

void printState(){
  Serial.print(accState);
  Serial.print(brakeState);
  Serial.print(potState);
  delay(100);
}

