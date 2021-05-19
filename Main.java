public class Main {
    public static void main(String[] args) {

        int dt = 20; // delay i.e. approx 50fps
        boolean keyQuit = false;
       

        Game game = new Game();

        game.start();
        
        

        while (game.running) {
            StdDraw.clear(StdDraw.GRAY);
            game.drawEnemy();
            game.drawshooter();
            game.update();
            game.shotmake();
            game.shotupdate();
            game.collisiondec();
            
            
            StdDraw.show();
            StdDraw.pause(dt);
            keyQuit = StdDraw.isKeyPressed(80);
            if(keyQuit)
              System.exit(0);
        }
    }
}