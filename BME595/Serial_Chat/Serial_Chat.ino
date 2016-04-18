/*
nRF Serial Chat

Ingredients: 2 Arduino Boards and 2 nRF2401L cards.
Interactive serial chat that uses the nRF radio cards to SEND and RECEIVE information. 
(The trick to be able to do both SENDING and RECIVING is to swipe the TX & RX addr during read/write operation.

This program read the messages that you input from your Serial Monitor and display the output to the other side
Serial Monitor or 16x2 LCD (if available)... like a simple chat program!

Max payload is 32 bytes for radio but the serialEvent will chopped the entire buffer
for next payload to be sent out sequentially.

*/

#include <LiquidCrystal.h> //In case you are reading your messages in an LCD display.
#include <SPI.h>
#include "nRF24L01.h"
#include "RF24.h"
#include "printf.h"

LiquidCrystal lcd(10, 7, 3, 4, 5, 6); //Pins to connect the LCD display

RF24 radio(9,10); //Pins to connect the radio card

const uint64_t pipes[2] = { 0xDEDEDEDEE1LL, 0xDEDEDEDED2LL }; //PIPES!: one for reading, one for writing

boolean stringComplete = false;  // whether the string is complete
static int dataBufferIndex = 0;
boolean stringOverflow = false;
char charOverflow = 0;

char SendPayload[31] = "";
char RecvPayload[31] = "";
char serialBuffer[31] = "";

void setup(void) {

  Serial.begin(57600); //Turning on the Serial Monitor
  
  lcd.begin(16,2); //Turning on the LCD
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("RF Chat"); //Welcome message on the LCD

  printf_begin();
  radio.begin(); //Turn on the radio
  
  radio.setDataRate(RF24_250KBPS);
  radio.setPALevel(RF24_PA_MAX);
  radio.setChannel(70);
  
  radio.enableDynamicPayloads();
  radio.setRetries(15,15);
  radio.setCRCLength(RF24_CRC_16);

  radio.openWritingPipe(pipes[0]); //Opening Writing Pipe
  radio.openReadingPipe(1,pipes[1]); //Opening Reading Pipe
  
  radio.startListening(); //Our radio card will be listening as much as possible to detect if we get a message
  radio.printDetails(); //Prints the configuration of the radio card in the Serial Monitor (it will make us look very pro).

  Serial.println(); //Empty line before the welcome message
  Serial.println("RF Chat"); //Welcome message in the Serial Monitor.
  delay(500);
  
  lcd.clear(); // We clear the LCD, since it had the welcome message before
}

void loop(void) {
  
  nRF_receive(); //This function starts in reading mode, changes to writing mode when we send a message, and gets to reading mode again.
  serial_receive(); //If we get a message, this function will print it in the Serial and the LCD and will go back to reading mode.
  
} // END of the loop(). That was short!



//FUNCTIONS OUTSIDE THE LOOP():

void serialEvent() { //Function that takes messages from the Serial Monitor entry line and breaks them into pieces before sending
  
  while (Serial.available() > 0 ) { //While you are typing on the Serial Monitor
      char incomingByte = Serial.read();
      
      if (stringOverflow) {
         serialBuffer[dataBufferIndex++] = charOverflow;  // Place saved overflow byte into buffer
         serialBuffer[dataBufferIndex++] = incomingByte;  // saved next byte into next buffer
         stringOverflow = false;                          // turn overflow flag off
      } else if (dataBufferIndex > 31) {
         stringComplete = true;        // Send this buffer out to radio
         stringOverflow = true;        // trigger the overflow flag
         charOverflow = incomingByte;  // Saved the overflow byte for next loop
         dataBufferIndex = 0;          // reset the bufferindex
         break; 
      } 
      else if(incomingByte=='\n'){ //If we press intro we send our message
          serialBuffer[dataBufferIndex] = 0; 
          stringComplete = true;
      } else {
          serialBuffer[dataBufferIndex++] = incomingByte;
          serialBuffer[dataBufferIndex] = 0; 
      }          
  } // end while()
} // end serialEvent()


void nRF_receive(void) {
  int len = 0;
  if ( radio.available() ) { //If radio.available TRUE, we record the incoming message
      bool done = false;
      while ( !done ) {
        len = radio.getDynamicPayloadSize();
        radio.read(&RecvPayload,len);
        done = radio.available();
        delay(5);
      }
  
    RecvPayload[len] = 0; // null terminate string
    
    lcd.setCursor(0,0);
    lcd.print("R:"); 
    Serial.print("R:");
    lcd.setCursor(2,0);
    lcd.print(RecvPayload); //Received messages reads under "R:" in the LCD display
    Serial.print(RecvPayload);
    Serial.println();
    RecvPayload[0] = 0;  // Clear the buffers
  }  

} // end nRF_receive()



void serial_receive(void){
  
  if (stringComplete) { //if (stringComplete) is TRUE, that means we got a message
        strcat(SendPayload,serialBuffer);      
        // swap TX & Rx addr for writing
        radio.openWritingPipe(pipes[1]);
        radio.openReadingPipe(0,pipes[0]);  
        radio.stopListening();
        bool ok = radio.write(&SendPayload,strlen(SendPayload));
        
        lcd.setCursor(0,1); //Moving the cursor to the first line in the LCD
        lcd.print("S:");
        Serial.print("S:");
        lcd.setCursor(2,1); //Moving the cursor to the second line in the LCD
        lcd.print(SendPayload); // Printing the sent message on the LCD
        Serial.print(SendPayload); // Printing the received message on the Serial Monitor       
        Serial.println(); //Empty line in the Serial Monitor
        
        stringComplete = false; //Since we sent the message already we turn stringComplete to false to be ready to receive another message

        // restore TX & Rx addr for reading       
        radio.openWritingPipe(pipes[0]); //We open the pipes again (both of them, be generous)
        radio.openReadingPipe(1,pipes[1]); 
        radio.startListening(); //WE GET INTO READING MODE AGAIN!
        SendPayload[0] = 0; //We empty the variable that contained the old message so we can receive new messages.
        dataBufferIndex = 0;
  } // endif
  
} // end serial_receive()  
