
import java.awt.Rectangle;
import java.util.ArrayList;

public class Game extends Rectangle {
  
  boolean running = false;
  boolean keyLeft = false;
  boolean keyRight = false;
  boolean keyRotRight = false;
  boolean keyRotLeft = false;
  boolean shootbut = false;
  
  Shooter shooter = new Shooter();
  Enemy enemy[] = new Enemy[18];
  Shot shot[] = new Shot[50000];
  int shotcount;
  int row;
  int col;
  int count;
  int intialize = 0;
  int shots;
  
  private long lastFire = 0;
  private long firingInterval = 500;
 
  static ArrayList<Shot> shots1 = new ArrayList<Shot>();
  static ArrayList<Enemy> enemylist = new ArrayList<Enemy>();
  public Game() {
    // Setup StdDraw Window
    StdDraw.enableDoubleBuffering();
    StdDraw.clear();
    StdDraw.setCanvasSize(800, 800);
    StdDraw.setXscale(0, 800);
    StdDraw.setYscale(0, 800); 
   
  }
  
  public void start() {
    running = true;
  }
  
  public void drawshooter() {  
    shooter.draw();
  }
  
  public void initEnemy() {
    if(intialize == 1)
      for(row=0;row<3;row++){
        for(col=0;col<6;col++){
          count++;
          double x0 = 0.0 + col*50 + 30;
          double y0 = 799.0 - row*50 - 30;

          enemylist.add(new Enemy(x0,y0));


          //enemy[count].setCoord(x0,y0);
        }
      }
     intialize--;
  }
  
  
  public void drawEnemy() {
     for(Enemy str : enemylist){
      str.draw();
    }
   }
   public void updateEnemy() { 

           for(Enemy str : enemylist){
      str.update();
    } 
    
    
    
    
    /*
    if(intialize==0){
      count=-1;
      for(row=0;row<3;row++){
        for(col=0;col<6;col++){
          count++;  
          enemy[count] = new Enemy();
          double x0 = 0 + col*50 + 30;
          double y0 = 799 - row*50 - 30;
          enemy[count].setCoord(x0,y0);
        }
        enemy[0].setCoord(30,769);
        
      }
      intialize = 1;
    }
    count=-1;
    for(row=0;row<3;row++){
      for(col=0;col<6;col++){
        count++;  
        enemy[count].draw();
      }
    }
  }
  
  
  */
   }
  public void update() {
    
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
  
//update enemy
    /*
    count=-1;
    for(row=0;row<3;row++){
      for(col=0;col<6;col++){
        count++;       
        enemy[count].update();
      }
    }
    shooter.update();
    */
  }
  
  private void getStateOfKeys() {
    keyLeft = StdDraw.isKeyPressed(65);
    keyRight = StdDraw.isKeyPressed(68);
    keyRotRight = StdDraw.isKeyPressed(69);
    keyRotLeft = StdDraw.isKeyPressed(81);
    shootbut = StdDraw.isKeyPressed(87);
  }

   //shoot your shot
  public void shotmake(){ 
    if(shootbut==true){
      if (System.currentTimeMillis() - lastFire < firingInterval) {
        return;
      }
      double x = shooter.returnX0();
      double y = shooter.returnY0();
      double Orien = shooter.returnOr();
      shots1.add( new Shot(x,y,(int)Orien));
      lastFire = System.currentTimeMillis();
      }
    for(Shot str: shots1){ 
        str.setSpeed();
    } 
     
  }
  
  public void shotDraw(){
  for(Shot str: shots1){
        str.draw();
    }

  }
  
  public void shotupdate(){
    
     for(Shot str: shots1){
       str.update();
    }
  }
  public void collisiondec(){
    /*
    for(count=0;count<18;count++){ 
         double enx0 = enemy[count].returnX0();
         double eny0 = enemy[count].returnY0();
       for(shots=shots;shots>0;shots--){                               
         double sx0 = shot[shots].returnX0();
         double sy0 = shot[shots].returnY0();
         enemy[count].damage(enx0,eny0,sx0,sy0);
         shot[shots].damage(enx0,eny0,sx0,sy0);
       }                               
      }
    
    for(count=0;count<18;count++){
      for(shots=shots;shots>0;shots--){
        if((shot[shotcount]).intersects(enemy[count])){
          System.out.println("A");
        }
      }
    }
    */
  }
  
  
  
    
    
  }
