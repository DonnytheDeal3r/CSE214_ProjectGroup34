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
         
          
            StdDraw.clear(StdDraw.GRAY);            
            game.initEnemy();
            game.shotmake();
            game.drawScore();
            game.updateshooter();
            game.updateshot();
            game.shotRemove();
            game.updateEnemy();  
            game.drawshooter();
            game.drawEnemies();
            game.drawshots();  
            game.collision();           
            
            
            StdDraw.show();
            StdDraw.pause(dt);
             keyQuit = StdDraw.isKeyPressed(80);
            if(keyQuit)
              System.exit(0);
        }while (true);
    }
}
}