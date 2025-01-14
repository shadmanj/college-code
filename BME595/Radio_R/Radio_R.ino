#include <nRF24L01.h>
#include <RF24.h>
#include <RF24_config.h>
#include <SPI.h>

/*
This sketch receives strings from sending unit via nrf24 
and prints them out via serial.  The sketch waits until
it receives a specific value (2 in this case), then it 
prints the complete message and clears the message buffer.
*/
int messageLength = 12;
int msg[1];
RF24 radio(9,10);
const uint64_t pipe = 0xE8E8F0F0E1LL;
int lastmsg = 1;
String theMessage = "";
void setup(void){
  Serial.begin(9600);
  Serial.println("Serial started");
  radio.begin();
  Serial.println("Radio started");
  radio.openReadingPipe(1,pipe);
  Serial.println("Pipe opened");
  radio.startListening();
  Serial.println("Listening");
}
void loop(void){
  if (radio.available()){
    bool done = false;  
      done = radio.read(msg, 1); 
      char theChar = msg[0];
      if (msg[0] != 2){
        theMessage.concat(theChar);
        }
      else {
       if (theMessage.length() == messageLength) { 
       Serial.println("MESSAGE");
       Serial.println(theMessage);
       }
       theMessage= ""; 
      }
   }
   else{Serial.println("NO MESSAGE");}
}
