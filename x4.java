void setup(){
  size(displayWidth,displayHeight);
  rectMode(CENTER);
}

float buttonX  = 500;
float buttonY  = 400;      //Defining Button dimensions
float buttonW  = 100;
float buttonH  = 100;

float backR    = 100;
float backG    = 100;      //Defining background colour values
float backB    = 100;

float buttonDX = 0;
float buttonDY = 0;      //button movement

int   score    = 0;      //initial score
float time     = 20;      //how much time for each game

void draw(){
  
  if(buttonX > width - buttonW/2 || buttonX < buttonW/2){
    buttonDX *= -1;//random(-(1/2),-2);
  }                                                            //making button bounce
  if(buttonY > height - buttonH/2 || buttonY < buttonH/2){
    buttonDY *= -1;//random(-(1/2),-2);
  }
  
  background(backR,backG,backB);
  
  fill(backR+122,backG+122,backB+122);
  rect(buttonX,buttonY,buttonW,buttonH);
  fill(0);
  text("Click Me!",buttonX-30, buttonY);     //Button
  fill(255);
  
  textSize(60);
  fill(backR+122,backG+122,backB+122);
  text(score,width/2,100);                //score
  fill(255);
  
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
  
  textSize(50);
  text(time,width/8,100);
  textSize(14);
  
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
  
