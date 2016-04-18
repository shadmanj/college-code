int led1 = 13;
int led2 = 12;
int led3 = 11;
int led4 = 10;
int d = 100;


void setup(){
  pinMode(led1,OUTPUT);
  pinMode(led2,OUTPUT);
  pinMode(led3,OUTPUT);
  pinMode(led4,OUTPUT);
}

void loop(){
  //1st LED
  digitalWrite(led1,HIGH);
  delay(d);
  digitalWrite(led1, LOW);
  
  //2nd LED
  digitalWrite(led2,HIGH);
  delay(d);
  digitalWrite(led2, LOW);
  
  //3rd LED
  digitalWrite(led3,HIGH);
  delay(d);
  digitalWrite(led3, LOW);
  
  //4th LED
  digitalWrite(led4,HIGH);
  delay(d*2);
  digitalWrite(led4,LOW);
  
  //3rd LED
  digitalWrite(led3,HIGH);
  delay(d);
  digitalWrite(led3, LOW);
  
  //2nd LED
  digitalWrite(led2,HIGH);
  delay(d);
  digitalWrite(led2, LOW);
  
  //1st LED
  digitalWrite(led1,HIGH);
  delay(d*2);
  digitalWrite(led1, LOW);
}

