public class Object2D {

    double x;                                     //x-coord
    double y;                                     //y-coord
    double vx;                                    //x-velocity
    double vy;                                    //y-velocity
    double ax;                                    //x-accelaration
    double ay;                                    //y-accelaration
    double angleref;                              //angle of object

    public Object2D(double x0, double y0, double angle) {
        x = x0;                                   //intialization
        y = y0;                                   //    "
        vx = 0;                                   //    "
        vy = 0;                                   //    "
        ax = 0;                                   //    "
        ay = 0;                                   //    "
        angleref = angle;                         //    "
    }
    //update enemy
    public void update() {
        double dt = 1;                            //time
        vx += ax * dt;                            //new vx
        vy += ay * dt;                            //new vy
        x += vx * dt + 0.5 * ax * dt * dt;        //new x
        y += vy * dt + 0.5 * ay * dt * dt;        //new y
        
        
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
    //update shooter
    public void update1() {
        double dt = 1;                            //time
        vx += ax * dt;                            //new vx
        vy += ay * dt;                            //new vy
        x += vx * dt + 0.5 * ax * dt * dt;        //new x
        y += vy * dt + 0.5 * ay * dt * dt;        //new y
        

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
    //update shot   
    public void update2() {
        double dt = 1;                          //time        
        vx += ax * dt;                          //new vx
        vy += ay * dt;                          //new vy
        x += vx * dt + 0.5 * ax * dt * dt;      //new x
        y += vy * dt + 0.5 * ay * dt * dt;      //new y
    }
    //return of y-coord
    public double getY(){
    return y;
    }
    //return of x-coord
    public double getX(){
    return x;
    }
    //return of angle
    public double reAng(){
     double angle1 = angleref;
     return angle1;
    }
    
}