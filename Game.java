import java.util.ArrayList;
import java.awt.Rectangle;
public class Game extends Rectangle{
  
    //running
    boolean running = false;
    
    //keys
    boolean keyLeft = false;
    boolean keyRight = false;
    boolean keyRotRight = false;
    boolean keyRotLeft = false;
    boolean shootbut = false;
    
    //shooter make
    Shooter shooter = new Shooter();
    
    //arraylist for enemies
    static ArrayList<Enemy> enemylist = new ArrayList<Enemy>();  
    
    //arraylist for shots
    static ArrayList<Shot> shots1 = new ArrayList<Shot>();
    
    //usefull ints
    int row;
    int col;
    int count;
    int intialize = 0;
    
    //fire control
    private long lastFire = 0;
    private long firingInterval = 500;
    
   
    
    
    
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
    
    //draw meun
    public void menu(){
      
      StdDraw.clear(StdDraw.GRAY); 
      StdDraw.setPenColor(StdDraw.YELLOW);  
      StdDraw.text(400.0,300.0, "Shoot(w)");
      StdDraw.text(400.0,270.0, "Rotate: Left(a), Stop(s), Right(d)");
      StdDraw.text(400.0,240.0, "Move: Left(z), Stop(x), Right(c)");
      StdDraw.text(400.0,210.0, "Quit(q), Screencap(p)");
      StdDraw.show();
    
    }
    
    
    
    
    
    //drawshooter
    public void drawshooter() {
        shooter.draw();
    }
    //draw enemies
    public void drawEnemies() {
      for(Enemy str : enemylist){
        str.draw();
      }    
    }  
    //draw shots
    public void drawshots() {
      for(Shot str: shots1){
        str.draw();
      }   
    }  
//-------------(intialize enemies)-----------------------------------------------------       
        
    //intialize enemies
    public void initEnemy() {
      if(intialize == 0)
        for(row=0;row<3;row++){
        for(col=0;col<6;col++){
          count++;           
          double x0 = 0 + col*50 + 30;
          double y0 = 799 - row*50 - 30;         
          enemylist.add(new Enemy(x0,y0));
        }
      }
     intialize++;
  }   
 
//----------(update)--------------------------------------------------------------------   
       
  //update enemies
    public void updateEnemy() { 
      for(Enemy str : enemylist){
        str.update();
      }  
    }
  //update shots
    public void updateshot(){
      for(Shot str: shots1){
        str.update();
      }
    }
    
  //update shooter
    public void updateshooter() {
    
    getStateOfKeys();
    //horizontal movement
    if (keyLeft && !keyRight &&  shooter.x>10){
      shooter.vx = -10;
    }
    else if (keyRight && !keyLeft && shooter.x<790){
      shooter.vx = +10;
    }
    else{
      shooter.vx = 0;
    }
    //rotation
    if (keyRotLeft && !keyRotRight && shooter.Orien< 90){
      shooter.changeOr(5);
    }
    else if (keyRotRight && !keyRotLeft && shooter.Orien> -90){
      shooter.changeOr(-5);
    }
    else{
      shooter.changeOr(0);
    }
    //updateshooter
    shooter.update();
       
    }

//---------(intialize shot)--------------------------------------------------------------  
    public void shotmake(){ 
      getStateOfKeys();
      if(shootbut==true){
        if (System.currentTimeMillis() - lastFire < firingInterval) {
          return;
        }
        double x = shooter.returnX0();
        double y = shooter.returnY0();
        double Orien = shooter.returnOr();
        lastFire = System.currentTimeMillis();
        shots1.add( new Shot(x,y,(int)Orien));    
      }
      for(Shot str: shots1){ 
        str.setSpeed();
      } 
    }
 //--------------(Collision)------------------------------------------------------------- 
    public void collision(){
      /*
      if(shots1.size()>0){
        for(int i = 0; i < enemylist.size(); i++){
          for(int j = 0; j < shots1.size(); j ++){
          if (shots1.get(i))
          
          }
        
        }
      
      
      
      
      }
      */
      
      
      
      
      for(Enemy str : enemylist){
        double enx0 = str.getOGX();
        double eny0 = str.getOGY();
        for(Shot str1 : shots1){ 
          double sx0 = str1.returnX0();
          double sy0 = str1.returnY0();
          if (sy0 <= (eny0 + 20) && (sy0 >= eny0 -20) && (sx0 >= enx0 - 20)
                && sx0 <= (enx0 +20)){
            str1.setHp(0);
            str.setHp(0);
            System.out.println("HIT");
          
          }
        } 
       
       
       
       
      }  
      
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
 //--------------(Extra)-----------------------------------------------------------------       
    private void getStateOfKeys() {
      keyLeft = StdDraw.isKeyPressed(65);
      keyRight = StdDraw.isKeyPressed(68);
      keyRotRight = StdDraw.isKeyPressed(69);
      keyRotLeft = StdDraw.isKeyPressed(81);
      shootbut = StdDraw.isKeyPressed(87);
    }

}




































