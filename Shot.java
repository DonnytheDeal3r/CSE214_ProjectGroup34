public class Shot extends DefaultCritter{
      private static double x0 = 0;
      private static double y0 = 0;
      private int hp = 100;
      private int OrienS = 0;
    public Shot() {
        super(x0, y0);
       
    }
    public void setCoord(double XCoord,double YCoord){
       this.x0 = XCoord;
       this.y0 = YCoord;
    }
    public void setSpeed(int Or){
    double Orient = Math.toRadians(Or)+ 0.5*Math.PI;
    vy = 10 * Math.sin(Orient);
    vx = 10 * Math.cos(Orient);
    } 
    @Override
    public void draw() {
      if(isAlive() == true){
        StdDraw.picture(x, y,"Shot.gif",OrienS);
      }
    }
     @Override
    public void update() {
        super.update2();
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