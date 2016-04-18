const int SW_pin = 2;
const int X_pin = 0;
const int Y_pin = 1;
const int servo = 3;
const int led = 13;

void setup(){
  pinMode(SW_pin,INPUT);
  pinMode(servo,OUTPUT);
  pinMode(led,INPUT);
  digitalWrite(SW_pin,HIGH);
  Serial.begin(9600);
}

void loop(){
  int button = digitalRead(SW_pin);
  int x = analogRead(X_pin);
  int y = analogRead(Y_pin);
  
  if (button == HIGH){
    digitalWrite(led,HIGH);
  }
  
  int x_vel = map(x,510,1023,0,100);
  x_vel = map(x,0,500,-100,-1);
//  x_vel = map(x,501,509,0,0);
  
  int y_vel = map(y,510,1023,0,100);
  y_vel = map(y,0,500,-100,-1);
//  y_vel = map(y,501,509,0,0);
  
  Serial.print(x_vel);
  Serial.print("    ");
  Serial.print(y_vel);
  Serial.print("\n");
}
