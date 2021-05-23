//---------------(Default enemy)-------------------------------------
public class Enemy extends DefaultCritter {

   private static double x0 = 0;
   private static double y0 = 0;
 
   
//--------------------(main + overrides)-------------------------------------   
    //enemy body
    public Enemy(double x0, double y0, double vx) {
        super(x0, y0, 90, vx);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw() {
      if(isAlive()==true){
         StdDraw.picture(x,y ,"alien.png");
      }
    }
    
    @Override 
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }
//---------------(Getters and Setters)-------------------------------------------        
    //return y-coord
    public double getY0(){
     double Y0 = super.returnY0();
     return Y0;
    }
    
    //return x-coord
    public double getX0(){
     double X0 = super.returnX0();
     return X0;
    }
    
//------------------------(end)--------------------------------------------------    
    
}