/*Created by:H.C. de Beer
 *           J.C. Beukes
 * 
 * 
 * 
 * 
 */ 
//------------------(Default Missle)---------------------------------------------------
public class Shooter extends DefaultCritter {

    private static final double x0 = 400;
    private static final double y0 = 100;
    static private int Orien = 0;
    static private double vx;
    
//--------------------(main + overrides)-------------------------------------       
    //body of shooter
    public Shooter() {
        super(x0, y0, 90, 0);
    }

    @Override
    public void update() {
        super.update1();
    }

    @Override
    public void draw() {
        StdDraw.picture(x, y ,"ship.png",Orien);
    }
//--------------------(Orientasion)-------------------------------------     
        
    //Orientation of ship 
    public void changeOrien(int Rot){
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
    
//---------------(Getters and Setters)-------------------------------------------        
    
     //return y-coord
    public double getY0(){
     double Y0 = super.returnY0();
     return Y0;
    }
    
    //return x-coord
    public double getX0(){
     double X0 = super.returnX0();
     return X0;
    }
       
    //return orientation
    public int returnOrien(){
     return Orien;
    }
    
    //change ship vx
    @Override
    public void changeVx(double vx){
     super.changeVx(vx);    
    }
    
//------------------------(end)--------------------------------------------------
    
}