void setup(){
  size(displayWidth,displayHeight);
  rectMode(CENTER);
}

float buttonX = 200;
float buttonY = 200;
float buttonW = 100;
float buttonH = 100;
float backR = 100;
float backG = 100;
float backB = 100;
float buttonDX = 0;
float buttonDY = 0;
int score = 0;
float time = 30;

void draw(){
  
  buttonX += buttonDX;
  buttonY += buttonDY;
  
  if(buttonX > width || buttonX < 0){
    buttonDX *= -1;//random(-(1/2),-2);
  }
  if(buttonY > height || buttonY < 0){
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
  time -= 1/frameRate;
  text(time,width/4,100);
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
    buttonDX = random(-20,20);
    buttonDY = random(-20,20);
    if(time > 0){
       score += 1;
    }
  } 
}
  
