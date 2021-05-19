public class Enemy extends DefaultCritter {

      private static double x0 = 0;
      private static double y0 = 0;

    public Enemy() {
        super(x0, y0);
        vx = -1;
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw() {
      if(isAlive() == true){
        StdDraw.picture(x,y ,"alien.gif");
      }
    }
    //setter
    public void setCoord(double XCoord,double YCoord){
      this.x0 = XCoord;
      this.y0 = YCoord;
    }
    public void damage(double x0,double y0,double sx,double sy){
      if( ( ( sx < x0 + 5 ) && (sx > x0 - 5) ) && ( ( sy < y0 + 5 ) && (sy > y0 - 5) ) ){
      takeDamage(101); 
      
      }
    }
    public double returnX0(){
     return x0;
    }
    public double returnY0(){
     return y0;
    }
}