int buzzer = 2;
int photoR = A0;

int Ao;

void setup(){
  Serial.begin(9600);
  pinMode(buzzer, OUTPUT);
  pinMode(photoR, INPUT);
}

void loop(){
  Ao = analogRead(photoR);
  if (Ao > 0){
    digitalWrite(buzzer, HIGH);
    delay(2);
    digitalWrite(buzzer, LOW);
    delay(10);
  }
  Serial.println(Ao);

}
