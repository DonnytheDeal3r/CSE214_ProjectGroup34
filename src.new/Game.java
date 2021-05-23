import java.util.ArrayList;
import java.awt.Rectangle;
import java.util.Iterator;

/*Created by:H.C. de Beer
 *           J.J. Mocke
 *           J.C. Beukes
 * 
 * 
 * 
 */
public class Game extends Rectangle{
  
    //running
    boolean running = false;
    
    //keys
    boolean keyLeft = false;
    boolean keyRight = false;
    boolean keyRotRight = false;
    boolean keyRotLeft = false;
    boolean shootButton = false;
 
    //shooter make
    Shooter shooter = new Shooter();
    
    //arraylist for enemies
    static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();  
    
    //arraylist for shots
    static ArrayList<Missile> missileList = new ArrayList<Missile>();
    
    //usefull ints
    private int score;
    private int level = 0;
    private int intialize = 0;
    private int row;
    private int col;
    
    //vector
    private double vx = 2;
      
    //fire control
    private long lastFire = 0;
    private long firingInterval = 500;
    
    //Game over flag
    boolean gameover = false;
    
    
//-------------------------------------------------------------------------------------   
    //Game body
    public Game() {
        // Setup StdDraw Window
        StdDraw.enableDoubleBuffering();
        StdDraw.clear();
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 800);
        StdDraw.setYscale(0, 800);
    }
    //startbutton
    public void start() {
        running = true;
    };
    
//----------(Draw)--------------------------------------------------------------------  
     //draw menu
     public void drawMenu(){
      
      StdDraw.clear(StdDraw.GRAY); 
      StdDraw.setPenColor(StdDraw.YELLOW);  
      StdDraw.text(400.0,300.0, "Shoot(w)");
      StdDraw.text(400.0,270.0, "Rotate: Left(z), Right(c)");
      StdDraw.text(400.0,240.0, "Move: Left(a), Right(d)");
      StdDraw.text(400.0,210.0, "Quit(q),  Start(spacebar)");
      StdDraw.show();
    
    }
     //draw score
     public void drawScore(){
      StdDraw.setPenColor(StdDraw.BLUE);
      StdDraw.text(90.0,780.0, "Score: "+score+"  Level:"+level);
    
    }
      
    //drawshooter
    public void drawShooter() {
        shooter.draw();
    }
    //draw enemies
    public void drawEnemies() {
      for(Enemy str : enemyList){
        str.draw();
      }    
    }  
    //draw shots
    public void drawMissile() {
      for(Missile str: missileList){
        str.draw();
      }   
    }  
//-------------(level and tests)-----------------------------------------------------
    
    private void levelSystem(){
      if(levelUpTest()==true){
        if(level==8){
        gameover=true;
        }
        vx++;
        intialize=0;   
      }
    }
    private boolean levelUpTest(){
      if(enemyList.isEmpty()){
       level++;
       return true;
      }else{
      return false;
      }    
    } 
    
//-------------(spawn enemies)-----------------------------------------------------       
        
    //intialize enemies
    public void initEnemy() {
      levelSystem();
      if(intialize == 0)
        for(row=0;row<3;row++){
        for(col=0;col<6;col++){      
          double x0 = 0 + col*50 + 30;
          double y0 = 799 - row*50 - 30;         
          enemyList.add(new Enemy(x0,y0,vx));
        }
      }
     intialize++;
  }   
    
//----------(update)--------------------------------------------------------------------   
       
  //update enemies
    public void updateEnemy() { 
      for(Enemy str : enemyList){
        str.update();
      }  
    }
  //update shots
    public void updateMissile(){
      for(Missile str: missileList){
        str.update();
      }
    }
    
  //update shooter
    public void updateShooter() {
    
    getStateOfKeys();
    //horizontal movement
    if (keyLeft && !keyRight &&  shooter.x>10){
      shooter.changeVx(-10);
    }
    else if (keyRight && !keyLeft && shooter.x<790){
      shooter.changeVx(+10);
    }
    else{
      shooter.changeVx(0);
    }
    //rotation
    if (keyRotLeft && !keyRotRight){
      shooter.changeOrien(5);
    }
    else if (keyRotRight && !keyRotLeft){
      shooter.changeOrien(-5);
    }
    else{
      shooter.changeOrien(0);
    }
    //updateshooter
    shooter.update();
       
    }

//---------(intialize shot)--------------------------------------------------------------  
    public void missileMake(){ 
      getStateOfKeys();
      if(shootButton==true){
        if (System.currentTimeMillis() - lastFire < firingInterval) {
          return;
        }
        double x = shooter.getX0();
        double y = shooter.getY0();
        double Orien = shooter.returnOrien();
        lastFire = System.currentTimeMillis();
        missileList.add( new Missile(x, y, Orien, 10));    
      }
      for(Missile str: missileList){ 
        str.setSpeed();
      } 
    }
 //--------------(Collision)----------------------------------------------------------------------------------------------    
   //enemies hitscan
     public void collision(){
       Iterator itr = enemyList.iterator();
      
         while ( itr.hasNext() ){
           Enemy enemy = (Enemy)itr.next();
           double enx0 = enemy.getX0();
           double eny0 = enemy.getY0();
            Iterator iter = missileList.iterator();
             while ( iter.hasNext() ){
               Missile ITR = (Missile)iter.next();
               double sy0 = ITR.getY0();
               double sx0 = ITR.getX0();
                if( ( ( sx0 < enx0 + 20 ) && (sx0 > enx0 - 20) ) && ( ( sy0 < eny0 + 20 ) && (sy0 > eny0 - 20 ) ) ){
                 itr.remove();
                 iter.remove();
                 score=score+10*((level/4)+1);
                }
    
             }
         }
         itr = enemyList.iterator();
         while ( itr.hasNext() ){
           Enemy enemy = (Enemy)itr.next();
           double enx0 = enemy.getX0();
           double eny0 = enemy.getY0();
           if(eny0<0.0){
             itr.remove();
             gameover = true;
           }
         }

         itr = enemyList.iterator();
         while ( itr.hasNext() ){
           Enemy enemy = (Enemy)itr.next();
           double enx0 = enemy.getX0();
           double eny0 = enemy.getY0();
           double shooterX = shooter.getX0();
           double shooterY = shooter.getY0();
           if( ( ( shooterX < enx0 + 20 ) && (shooterX > enx0 - 20) ) && ( ( shooterY < eny0 + 20 ) && (shooterY > eny0 - 20 ) ) ){
             itr.remove();
             gameover = true;
           }      
     }
     }     
  //shot out of bounds
    public void missileRemove(){
      Iterator itr = missileList.iterator();
      while (itr.hasNext()){
        Missile ITR = (Missile)itr.next();
        double y = ITR.getY0();
        double x = ITR.getX0();
        if(y>800.0){
          itr.remove();       
        }else if( (x>800) || (x<0) ){
          itr.remove();
        }else if( (x>800) && (y>=800) ){
          itr.remove();   
        }else if( (x<=0) && (y>=800) ){ 
          itr.remove();
        }
      }   
    }
     
 //--------------(Extra)-----------------------------------------------------------------  
    
    private void getStateOfKeys() {
      keyLeft = StdDraw.isKeyPressed(65);
      keyRight = StdDraw.isKeyPressed(68);
      keyRotRight = StdDraw.isKeyPressed(67);
      keyRotLeft = StdDraw.isKeyPressed(90);
      shootButton = StdDraw.isKeyPressed(87);
    }

    public int returnScore(){
      return score;
    }
    
    public boolean gameOverTest(){
      if(gameover==true){
        clearEnemy();
        clearMissles();
      }
      return gameover;
    }
    
    public void drawGO(){
       StdDraw.clear(StdDraw.GRAY);
       StdDraw.text(400.0,400.0, "Game Over");
       StdDraw.text(400.0,350.0, "Score: "+score);
       StdDraw.show();
     }
    
    private void clearEnemy() {       
      Iterator itr = enemyList.iterator();
      while (itr.hasNext()){
        Enemy ITR = (Enemy)itr.next();
        itr.remove();       
      }
      
    }   
    
    private void clearMissles() {       
      Iterator itr = missileList.iterator();
      while (itr.hasNext()){
        Missile ITR = (Missile)itr.next();
        itr.remove();       
      }
      
    }   
    
    
    
//-----------------------------------(end)----------------------------------------------    
    
}


 















