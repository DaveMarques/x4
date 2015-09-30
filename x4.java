void setup(){
  size(500,500);
  rectMode(CENTER);
}

float buttonX = 200;
float buttonY = 200;
float buttonW = 100;
float buttonH = 100;
float backR = 100;
float backG = 100;
float backB = 100;

void draw(){
  
  background(backR,backG,backB);
  
  rect(buttonX,buttonY,buttonW,buttonH);
  fill(0);
  text("Click Me!",buttonX-30, buttonY);
  fill(255);
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
  }
  
}
  
