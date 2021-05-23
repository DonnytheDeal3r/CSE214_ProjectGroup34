public class Shot extends DefaultCritter{
  static final private double x0=0;
  static final private double y0=0;
  static private double Orient;
     // private int hp = 100;
       
      public Shot(double x, double y, double angle) {
        super(x, y, angle);
      }
      
      public void setSpeed(){
        Orient = reANg();      
        Orient = Math.toRadians(Orient)+ 0.5*Math.PI;
        vy = 10 * Math.sin(Orient);
        vx = 10 * Math.cos(Orient);
      } 
      @Override
      public void update() {
        super.update2();
      }
      @Override
      public void draw() {
        if(isAlive() == true){
          Orient = reANg();      
          StdDraw.picture(x, y,"Shot.gif",Orient);
        }
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
    
      @Override 
      public void takeDamage(int damage) {
        super.takeDamage(damage);
      }
    
}