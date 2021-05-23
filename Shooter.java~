import java.util.ArrayList;

public class Shooter extends DefaultCritter {

    private static  double x0 = 400;
    private static  double y0 = 100;
    int Orien = 0;
    
  private ArrayList<Shot> shots = new ArrayList<Shot>();
    
    
    public Shooter() {
        super(x0, y0, 90);
    }

    @Override
    public void update() {
        super.update1();
    }

    @Override
    public void draw() {
        int radius = 10;
        StdDraw.picture(x, y ,"ship.gif",Orien);
    }
    
    public void changeOr(int Rot){
      if( (Orien<=-90) && (Rot>=0) ){
       Orien=-90; 
       Orien = Orien + Rot;
      }else if( (Orien>=90) && (Rot<=0) ){
       Orien=90; 
       Orien = Orien + Rot;  
      }else if((Orien>-90) && (Orien<90)){
        Orien = Orien + Rot;
        }
      }
    
    public ArrayList<Shot> getShots(){
    return shots;
  }
  
  
   //shoot your shot
    
  public void shotmake(){ 
     double x = returnX0();
     double y = returnY0();
     double Orien = returnOr();
    
     
     //shots.add(new Shot(x,y,(double)Orien));
     /*Shot.sety0(y);
     Shot.setx0(x);
     shots.add(Shot);
     */
    
  }
   
     
  
    
    public double returnX0(){
     return x;
    }
    public double returnY0(){
     return y;
    }
    public int returnOr(){
     return Orien;
    }
}