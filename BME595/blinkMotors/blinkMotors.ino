int motor = 9;




void setup(){
  pinMode(motor, OUTPUT);  
}

void loop(){
  for(int i = 0; i < 255; i++){
    analogWrite(motor,i);
    delay(10);
  }
  delay(1000);
  
  for(int i = 255; i > 0; i--){
    analogWrite(motor,i);
    delay(10);
  }
  delay(1000);
}
