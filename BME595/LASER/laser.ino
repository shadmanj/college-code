int laser = A0;
int photoR = A1;
int buzzer = 3;

void setup(){
	pinMode(laser, OUTPUT);
	pinMode(photoR, OUTPUT);
	pinMode(buzzer, OUTPUT);
}

void loop(){
	digitalWrite(laser,HIGH);
	delay(500);
	digitalWrite(laser,LOW);
	delay(500);
}
