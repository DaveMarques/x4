float buttonX, buttonY, buttonW, buttonH;   //button's x,y positions and width and height 
float backR, backG, backB;                  //background colours
float buttonDX, buttonDY;                   //button movements
float time;                                 //time

int   score;                  //score
int   highScore = 0;        //Declaring this function here so it won't reset with keyPress     

void setup(){
  size(displayWidth,displayHeight);
  rectMode(CENTER);
                       //I declared most of my values here so the reset button resets mostly everything
                       //only exception being the high score 
  buttonX  = 500;
  buttonY  = 400;      //Declaring Button dimensions
  buttonW  = 100;                
  buttonH  = 100;
  
  backR    = 100;
  backG    = 100;      //Declaring background colour values
  backB    = 100;
  
  buttonDX = 0;        //Declaring button movement
  buttonDY = 0;
  
  score    = 0;      //Declaring initial score
  time     = 10;     //Declaring how much time for each game
}

void button(){
  
  if(buttonX > width - buttonW/2 || buttonX < buttonW/2){
    buttonDX *= -1;
  }                                                            //making button bounce
  if(buttonY > height - buttonH/2 || buttonY < buttonH/2){
    buttonDY *= -1;
  }
  
  fill(backR+122,backG+122,backB+122);
  rect(buttonX,buttonY,buttonW,buttonH);
  fill(0);
  textSize(14);
  text("Click Me!",buttonX-30, buttonY);     //Button
}

void time(){                //this function is unique to this code, and should be
                            //looked at carefully if copying and pasting
    if(time > 0 && score > 0){
    time -= 1/frameRate;          //Timer and button movement function
    buttonX += buttonDX;          //will only happen when button is first clicked
    buttonY += buttonDY;          //and will stop when the timer runs out.
  } 
  
  if(time < 0) {
    textSize(100);
    text(score,width/2,height/2);              //Final score will appear after time is up
    text("Final Score:",width/4,height/2-100);
  }
}

void scene(){
  background(backR,backG,backB);
  
  textSize(60);
  fill(255);
  text(score,width/2,height/10);                //score
  
  textSize(50);
  text(time,width/8,height/10);      //displays time
  
  textSize(16);
  text("Press R to try again! \n Press ESC to quit!", width-500,height/10);
  
  textSize(25);
  text("HIGH SCORE:", width-250,height/10);
  if(score > highScore){                      //Declares the high score if the score is greater than it
    highScore = score;
  }
  text(highScore,width-75,height/10);
}

void draw(){
  scene();
  time();
  button();
}

void mousePressed(){
  
  if(
   (mouseX < buttonX + buttonW/2) &&
   (mouseX > buttonX - buttonW/2) &&    //The mouse can only click on the button
   (mouseY < buttonY + buttonH/2) &&
   (mouseY > buttonY - buttonH/2))   
  {
    backR = random(0,255);
    backG = random(0,255);                //makes a random background color
    backB = random(0,255);
    
    buttonDX = random(-10,10);            //moves the button a random direction
    buttonDY = random(-10,10);
    
    if(time > 0){
       score += 1;                        //counts score
    }   
  } 
}

void keyPressed(){
  if (key == 'r' || key == 'R'){        //makes pressing r or R reset the code but not the high score
    setup();
  }
}
