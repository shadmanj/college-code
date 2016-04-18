int motor = 9;
int button = 2;

int buttonState = LOW;
int fanSetting = 1;
int currentSpeed = 4;

void setup(){
  Serial.begin(9600);
  pinMode(button, INPUT);
  pinMode(motor, OUTPUT);  
}

void loop(){
  buttonState = digitalRead(button);
  Serial.println(fanSetting);
  
  if (buttonState == HIGH){
    fanSetting = fanSetting + 1;
    delay(500);
  }
  else{
    runMotor(currentSpeed);
  }
  
  switch (fanSetting){
    case 1:
      currentSpeed = 0;
      runMotor(currentSpeed);
    break;

    case 2:
      currentSpeed = 64;
      runMotor(currentSpeed);
    break;
    
    case 3:
      currentSpeed = 128;
      runMotor(currentSpeed);
    break;
    
    case 4:
      currentSpeed = 255;
      runMotor(currentSpeed);
    break;
    default:
      currentSpeed = 0;
      fanSetting = 1;
    break;
  }
}

void runMotor(int rpm){
  analogWrite(motor,rpm);
}
