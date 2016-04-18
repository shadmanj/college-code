int laser = 3;
int photoR = A0;
int buzzer = 4;
int led = 13;

void setup(){
  pinMode(laser, OUTPUT);
  pinMode(photoR, INPUT);
  pinMode(buzzer, OUTPUT);
  pinMode(led,OUTPUT);
  Serial.begin(9600);
  digitalWrite(laser,HIGH);
}

void loop(){ 
  int r = analogRead(photoR);
  Serial.println(r);
//  if(r > 100){
    digitalWrite(buzzer,HIGH);
    delay(10);
    digitalWrite(buzzer,LOW);
    delay(10);
 // }
}



