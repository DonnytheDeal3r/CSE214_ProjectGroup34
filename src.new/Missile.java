//------------------(Default Missle)---------------------------------------------------
public class Missile extends DefaultCritter{
  static final private double x0=0;
  static final private double y0=0;
  static private double Orientation;
            
      public Missile(double x, double y, double angle, double vx) {
        super(x, y, angle, vx);
      }
//--------------------(main + overrides)-------------------------------------         
      public void setSpeed(){
        Orientation = reAng();      
        Orientation = Math.toRadians(Orientation)+ 0.5*Math.PI;
        vy = 10 * Math.sin(Orientation);
        vx = 10 * Math.cos(Orientation);
      } 
      
      @Override
      public void update() {
        super.update2();
      }
      
      @Override
      public void draw() {
        if(isAlive() == true){
          Orientation = reAng();      
          StdDraw.picture(x, y,"Shot.png",Orientation);
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