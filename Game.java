//druk space om game te begin en q dan close window sover is a en d links en regs.


public class Bravo{
  
  boolean gamePlay = false;
  static double x = 400.0;
  
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
  
  public static void drawGame(){
    
    StdDraw.clear(StdDraw.GRAY);
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.filledSquare(x, 0.0,20.0);
   
   
   for (int row = 0; row < 5 ; row++) {
     for (int col =0 ; col < 12 ; col++) {
       StdDraw.filledCircle(100+(col*50),(400)+row*30,10);
     }
   }
   

   
   StdDraw.setPenColor(StdDraw.BLUE);
   StdDraw.text(25,580.0, "Score:");
   StdDraw.show();
  }

  public static void gameLoop(){
    
   System.out.print("Game");
    drawGame();
   char a = 0;
   
    while(a != 'q'){
    if (StdDraw.hasNextKeyTyped()) {
        a = StdDraw.nextKeyTyped();
         if(a == 'q'){
      System.exit(0);
    } if(a == 'a'){
      x -= 10.0;
      StdDraw.clear(StdDraw.GRAY);
      drawGame();
      StdDraw.show();
    }if(a == 'd'){
      x += 10.0;
      StdDraw.clear(StdDraw.GRAY);
      drawGame();
      StdDraw.show();
    } 
        }
   
   
    }  
   
  }
  
  public static void main(String[] args){
    StdDraw.enableDoubleBuffering();
    StdDraw.show();
    Menu();
    char c = 0;
    while(c != ' '){
    if (StdDraw.hasNextKeyTyped()) {
        c = StdDraw.nextKeyTyped();
        }
    }  
    gameLoop();
}
}

