public class DefaultCritter extends Object2D implements Critter {

    private int hp;
    public DefaultCritter(double x, double y) {
        super(x, y);
        hp = 100;
    }

    public boolean isAlive() {
      if(hp <= 0){
        return false;
      }
      return true;
    }

    public void takeDamage(int damage) {
        hp = hp - damage;
    }

    @Override
    public void update(){
        super.update();
    }

    public void draw() {
        
    }
    
}