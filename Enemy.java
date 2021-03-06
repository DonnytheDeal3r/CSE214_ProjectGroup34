public class Enemy extends DefaultCritter {

   private static double x0 = 0;
   private static double y0 = 0;
   
    //enemy body
    public Enemy(double x0, double y0) {
        super(x0, y0, 90);
        vx = -1;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw() {
      if(isAlive()==true){
         StdDraw.picture(x,y ,"alien.gif");
      }
    }
    
    @Override 
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }
    
    //return y-coord
    public double getOGY(){
     double Y0 = super.returnY0();
     return Y0;
    }
    
    //return x-coord
    public double getOGX(){
     double X0 = super.returnX0();
     return X0;
    }
    
    
    
}