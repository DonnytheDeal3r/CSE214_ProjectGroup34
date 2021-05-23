public class DefaultCritter extends Object2D implements Critter {
    //critter health
    private int hp;
    //body
    public DefaultCritter(double x, double y, double angle) {
        super(x, y, angle);
        hp = 100;
    }
    //is hp more than 0
    public boolean isAlive() {
      if(hp < 0){
      return false;
      }else{
       return true; 
      }
    }
    //damage calculation
    public void takeDamage(int damage) {
        hp -= damage;
    }

    @Override
    public void update(){
        super.update();
    }
    //draw object
    public void draw() {
        
    }
    //return y-coord
    public double returnY0(){
     double coy = super.getY();
     return coy;
    }
    public double returnX0(){
     double cox = super.getX();
     return cox;
    }
    //return angle
    public double reANg(){
     double angle2 = reAng();
     return angle2;
    }
    
    
    
}