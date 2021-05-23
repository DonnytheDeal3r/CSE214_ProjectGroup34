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
    
     
      public double returnX0(){
      return x0;
      } 
      
      public double returnY0(){
        return y0;
      }
    
    
    
      public void damage(double x0,double y0,double sx,double sy){
        if( ( ( sx < x0 + 5 ) && (sx > x0 - 5) ) && ( ( sy < y0 + 5 ) && (sy > y0 - 5) ) ){
        takeDamage(101); 
      
        }
      }
}