void setup(){
  size(500,500);
  rectMode(CENTER);
}

float buttonX = 200;
float buttonY = 200;
float buttonW = 100;
float buttonH = 100;

void draw(){
  
  
  if((mouseX < (buttonX + (buttonW/2))) &&
     (mouseX > (buttonX - (buttonW/2))) &&
     (mouseY < (buttonY + (buttonH/2))) &&
     (mouseY > (buttonY - (buttonH/2))) &&
     mousePressed )
  {
    background(random(0,255),random(0,255),random(0,255));
  }
  rect(buttonX,buttonY,buttonW,buttonH);
    
  
}
