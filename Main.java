public class Main {
    public static void main(String[] args) {

        int dt = 20; // delay i.e. approx 50fps
        boolean keyQuit = false;
        boolean keyStart = false;
        
        Game game = new Game();

        keyStart = StdDraw.isKeyPressed(32);
        do{
          game.menu();
          keyStart = StdDraw.isKeyPressed(32);
        }while(keyStart != true);
      
        game.start();
        
//--------(Main game loop)-------------------------------------------------------------
        while (game.running) {
          do{
            StdDraw.clear(StdDraw.GRAY);
          }while(keyStart=!true);
          
            StdDraw.clear(StdDraw.GRAY);            
            game.initEnemy();
            game.shotmake();
            game.updateshooter();
            game.updateshot();  
            game.updateEnemy(); 
            game.collision();
            game.drawshooter();
            game.drawEnemies();
            game.drawshots();  
            
            //game.
            
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