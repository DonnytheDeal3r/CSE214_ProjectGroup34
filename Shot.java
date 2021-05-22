public class Shot extends DefaultCritter{
  static private double x0;
  static private double y0;
  int OrienS;
     // private int hp = 100;
       
      public Shot(double x, double y, double angle) {
        super(x, y, angle);
       
      }
      public void setCoord(double XCoord,double YCoord){
        this.x0 = XCoord;
        this.y0 = YCoord;
      }
      
      public void Shoot(){
      setSpeed(Shooter.returnOr());
      }
      
      public void setSpeed(int Or){
        double Orient = Math.toRadians(Or)+ 0.5*Math.PI;
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
          StdDraw.picture(x, y,"Shot.gif",OrienS);
        }
      }
    
     
      public double returnX0(){
      return x0;
      } 
      
      public double returnY0(){
        return y0;
      }
    
      public void returnOrien(int Orien){
      OrienS = Orien;
      
      }
    
    
      public void damage(double x0,double y0,double sx,double sy){
        if( ( ( sx < x0 + 5 ) && (sx > x0 - 5) ) && ( ( sy < y0 + 5 ) && (sy > y0 - 5) ) ){
        takeDamage(101); 
      
        }
      }
}