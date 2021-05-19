public class Shooter extends DefaultCritter {

    private static  double x0 = 400;
    private static  double y0 = 100;
    int Orien = 0;
    
    public Shooter() {
        super(x0, y0);
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