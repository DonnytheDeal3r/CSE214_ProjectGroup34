public class Object2D {

    double x;
    double y;
    double vx;
    double vy;
    double ax;
    double ay;

    public Object2D(double x0, double y0) {
        x = x0;
        y = y0;
        vx = 0;
        vy = 0;
        ax = 0;
        ay = 0;
    }

    public void update() {
        double dt = 1;
        vx += ax * dt;
        vy += ay * dt;
        x += vx * dt + 0.5 * ax * dt * dt;
        y += vy * dt + 0.5 * ay * dt * dt;
      if(x>=780){
        vx = -vx;
        y -= 150;
      }
      if(y>=800){
        vy = -vy;
      }
      if(x<=20){
        vx = -vx;
        y -= 150;
      }
      if(y<=0){
        vy = -vy;
      }
        
    }
    public void update1() {
        double dt = 1;
        vx += ax * dt;
        vy += ay * dt;
        x += vx * dt + 0.5 * ax * dt * dt;
        y += vy * dt + 0.5 * ay * dt * dt;
      if(x>=780){
        vx = -vx;
       
      }
      if(y>=800){
        vy = -vy;
      }
      if(x<=20){
        vx = -vx;
       
      }
      if(y<=0){
        vy = -vy;
      }
        
    }
    
    
    
    public void update2() {
        double dt = 1;
        vx += ax * dt;
        vy += ay * dt;
        x += vx * dt + 0.5 * ax * dt * dt;
        y += vy * dt + 0.5 * ay * dt * dt;
      
        
    }
    
    
    
    

}