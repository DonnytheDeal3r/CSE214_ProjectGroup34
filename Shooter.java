public class Shooter extends DefaultCritter {

    private static final double x0 = 400;
    private static final double y0 = 100;
    int Orien = 0;
    //body of shooter
    public Shooter() {
        super(x0, y0, 90);
    }

    @Override
    public void update() {
        super.update1();
    }

    @Override
    public void draw() {
        StdDraw.picture(x, y ,"ship.gif",Orien);
    }
    //Orientation of ship 
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
    //return x-coord
    public double returnX0(){
     return x;
    }
    //return y-coord
    public double returnY0(){
     return y;
    }
    //return orientation
    public int returnOr(){
     return Orien;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}