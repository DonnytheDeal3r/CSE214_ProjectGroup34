

public class Main {
    public static void main(String[] args) {

        int dt = 20; // delay i.e. approx 50fps
        boolean keyQuit = false;
        boolean keyStart = false;

        Game game = new Game();

        game.start();
        
        

        while (game.running) {
          keyStart = StdDraw.isKeyPressed(32);
          do{
            StdDraw.clear(StdDraw.GRAY);
          }while(keyStart==true);
          
            StdDraw.clear(StdDraw.GRAY);
            game.update();
            game.shotmake();
            game.shotupdate();
            game.drawEnemy();
            game.drawshooter();
              game.shotDraw();
            game.collisiondec();
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.text(25.0,780.0, "Score:");
    
            
            
            StdDraw.show();
            StdDraw.pause(dt);
            keyQuit = StdDraw.isKeyPressed(80);
            if(keyQuit)
              System.exit(0);
        }
    }
}