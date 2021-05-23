import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
//--------------------(Main)-------------------------------------------------
public class Main {
    public static void main(String[] args) {

        int dt = 20; // delay i.e. approx 50fps
        boolean keyQuit = false;
        boolean keyStart = false;
        boolean gameOver = false;
        ArrayList<Game> gamelist = new ArrayList<Game>();
//--------(Menu and start)-------------------------------------------------------------  
        
        while(keyQuit!=true){
          
          if((gamelist.isEmpty()!=true)&&(gameOver==true)){
          gamelist.remove(0);
          }
          
          gameOver = false;
          
          gamelist.add(new Game());
          
          
          do{
            gamelist.get(0).drawMenu();
            keyStart = StdDraw.isKeyPressed(32);
            
            keyQuit = StdDraw.isKeyPressed(81);
              
              if(keyQuit == true){                
                System.exit(0);
              }
          
          
          
          }while(keyStart != true);
                    
          gamelist.get(0).start();
        
//--------(Main game loop)-------------------------------------------------------------
          while (gamelist.get(0).running==true) {
            do{  
              
              StdDraw.clear(StdDraw.GRAY);            
              gamelist.get(0).initEnemy();
              gamelist.get(0).missileMake();
              gamelist.get(0).drawScore();
              //StdDraw.picture(400,650 ,"Boss.gif");
              gamelist.get(0).updateShooter();
              gamelist.get(0).updateMissile();
              gamelist.get(0).missileRemove();
              gamelist.get(0).updateEnemy();
              gamelist.get(0).drawShooter();
              gamelist.get(0).drawEnemies();
              gamelist.get(0).drawMissile();  
              gamelist.get(0).collision();           
              
              
              gameOver = gamelist.get(0).gameOverTest(); 
              if(gameOver==true){
                break;
              } 
              StdDraw.show();
              StdDraw.pause(dt);
              
              keyQuit = StdDraw.isKeyPressed(81);
              
              if(keyQuit == true){                
                System.exit(0);
              }
              
            }while(true);
            if(gameOver==true){
              gamelist.get(0).drawGO(); 
              wait(2000);
              break;
              } 
          }
          
          
        }
       
       
        
        
        
        
        
 //------------------------(end)--------------------------------------------------       
    }
     public static void wait(int ms)
        {
          try
          {
            Thread.sleep(ms);
          }
          catch(InterruptedException ex)
          {
            Thread.currentThread().interrupt();
          }
        }
    
    
}




 /*keyQuit = StdDraw.isKeyPressed(80);
              if(keyQuit)
                System.exit(0);
*/
              
              