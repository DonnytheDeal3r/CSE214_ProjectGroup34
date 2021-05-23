//--------------------(default critter)----------------------------------

public class DefaultCritter extends Object2D implements Critter {
  
    //critter health
    private int hp;
    
//-------------(Implementation of API)-----------------------------------    
    
    //body
    public DefaultCritter(double x, double y, double angle, double vx) {
        super(x, y, angle, vx);
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
        
    @Override
    public void update(){
        super.update();
    }
    
    
    //draw object
    public void draw() {
        
    }
//---------------(Extra)-------------------------------------------
    
    //damage calculation
    public void takeDamage(int damage) {
        hp -= damage;
    }

//---------------(Getters and Setters)-------------------------------------------    
    
    //return y-coord
    public double returnY0(){
     double coy = super.getY();
     return coy;
    }
    
    //return x-coord
    public double returnX0(){
     double cox = super.getX();
     return cox;
    }
    

    
    //change vx
    public void changeVx(double vx){
      super.changeVx(vx);    
    }
    
//------------------------(end)--------------------------------------------------    
}