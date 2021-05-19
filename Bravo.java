public class Bravo{
  
  static boolean gamePlay = false;
  static double x = 400.0;
  static double z = 0;
  static int count = 0;
  
  public static void Menu(){
  StdDraw.setCanvasSize(800,600);
  StdDraw.setXscale(0,800);
  StdDraw.setYscale(0,600);
  StdDraw.clear(StdDraw.GRAY);
  StdDraw.setPenColor(StdDraw.YELLOW);
  
  
  StdDraw.text(400.0,300.0, "Shoot(w)");
  StdDraw.text(400.0,270.0, "Rotate: Left(a), Stop(s), Right(d)");
  StdDraw.text(400.0,240.0, "Move: Left(z), Stop(x), Right(c)");
  StdDraw.text(400.0,210.0, "Quit(q), Screencap(p)");
  StdDraw.show();
  }
  
  public static void Restart(){
    
  StdDraw.clear(StdDraw.GRAY); 
  StdDraw.setPenColor(StdDraw.YELLOW);  
  StdDraw.text(400.0,300.0, "Shoot(w)");
  StdDraw.text(400.0,270.0, "Rotate: Left(a), Stop(s), Right(d)");
  StdDraw.text(400.0,240.0, "Move: Left(z), Stop(x), Right(c)");
  StdDraw.text(400.0,210.0, "Quit(q), Screencap(p)");
  StdDraw.show();
  
 
  }
  
  public static void drawGame(){
    
    StdDraw.clear(StdDraw.GRAY);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.picture(x, 15.0 ,"ship.gif",z);
   
   StdDraw.setPenColor(StdDraw.BLUE);
   StdDraw.text(25,580.0, "Score:");
   StdDraw.show();
  }
  public static void drawAlien(double x, double y){
    for (int row = 0; row < 3 ; row++) {
     for (int col =0 ; col < 6 ; col++) {
       //StdDraw.filledCircle(x+(col*50),(y)+row*30,10);
       StdDraw.picture(x+(col*50),(y)+row*30,"Alien.gif");
     }
   }
  
  
  }

  public static void gameLoop(){
    
   System.out.print("Game");
   drawGame();
   char a = 0;
   double moveX = 100;
   double moveY = 100;
   double cx = 10;
   //int count = 0;
  
   
    
    while((a != 'q')&&(count !=2)){
      
      moveX += cx;
      drawAlien(moveX, moveY);
      StdDraw.show();
      StdDraw.pause(100);
      StdDraw.clear(StdDraw.GRAY);
      drawGame();
      StdDraw.show();
      
      if(moveX == 530){
        moveY -= 50;
        count++;
        cx = -10;
      }
      if(moveX == 30){
        moveY -= 50;
        count++;
        cx = 10;
      }
    if (StdDraw.hasNextKeyTyped()) {
        a = StdDraw.nextKeyTyped();
         if(a == 'q'){
      System.exit(0);
    } 
         
         
       if(a == 'a'){
         if(x>10){
      x -= 10.0;
      StdDraw.clear(StdDraw.GRAY);
      drawGame();
      StdDraw.show();
    }
         }
         
         if(a == 'd'){
           if(x<790){
      x += 10.0;
      StdDraw.clear(StdDraw.GRAY);
      drawGame();
      StdDraw.show();
           }
        }
        if(a == 'z'){
          if(z<90){
          z += 5.0;
      StdDraw.clear(StdDraw.GRAY);
      drawGame();
      StdDraw.show();
          }
        }
      if(a == 'c'){
          if(z>-90){
          z -= 5.0;
      StdDraw.clear(StdDraw.GRAY);
      drawGame();
      StdDraw.show();
          }
         }
   
    }  
  
  
  }
    endGame();
  }
  
  public static void endGame(){
    StdDraw.clear(StdDraw.GRAY);
    Restart();
    StdDraw.show();
  
  
  }
  
  
  
  public static void main(String[] args){
    StdDraw.enableDoubleBuffering();
    StdDraw.show();
    Menu();
    char c = 0;
    do{
    while(c != ' '){
    if (StdDraw.hasNextKeyTyped()) {
        c = StdDraw.nextKeyTyped();
        gamePlay = true;
        }
    if(c == 'q'){
      System.exit(0);
    } 
     if(c == ' '){
        gameLoop();
    } 
    }
     gameLoop();
    }while(true);
}
}

