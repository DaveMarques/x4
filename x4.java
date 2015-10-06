void setup(){
  size(displayWidth,displayHeight);
  rectMode(CENTER);
}

float buttonX  = 500;
float buttonY  = 400;
float buttonW  = 100;
float buttonH  = 100;
float backR    = 100;
float backG    = 100;
float backB    = 100;
float buttonDX = 0;
float buttonDY = 0;
int   score    = 0;
float time     = 20;

void draw(){
  
  if(buttonX > width - buttonW/2 || buttonX < buttonW/2){
    buttonDX *= -1;//random(-(1/2),-2);
  }
  if(buttonY > height - buttonH/2 || buttonY < buttonH/2){
    buttonDY *= -1;//random(-(1/2),-2);
  }
  
  background(backR,backG,backB);
  
  fill(backR+122,backG+122,backB+122);
  rect(buttonX,buttonY,buttonW,buttonH);
  fill(0);
  text("Click Me!",buttonX-30, buttonY);
  fill(255);
  textSize(60);
  fill(backR+122,backG+122,backB+122);
  text(score,width/2,100);
  fill(255);
  if(time > 0 && score > 0){
    time -= 1/frameRate;
    buttonX += buttonDX;
    buttonY += buttonDY;
  } 
  if(time < 0) {
    textSize(100);
    text(score,width/2,height/2);
    text("Final Score:",width/4,height/2-100);
    
  }
  textSize(50);
  text(time,width/8,100);
  textSize(14);
}

void mousePressed(){
  
  if((mouseX < buttonX + buttonW/2) &&
     (mouseX > buttonX - buttonW/2) &&
     (mouseY < buttonY + buttonH/2) &&
     (mouseY > buttonY - buttonH/2))
     
  {
    backR = random(0,255);
    backG = random(0,255);
    backB = random(0,255);
    buttonDX = random(-10,10);
    buttonDY = random(-10,10);
    if(time > 0){
       score += 1;
    }   
  } 
}
  
