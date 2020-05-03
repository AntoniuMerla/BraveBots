import greenfoot.*;  

public class Robot extends Actor
{   
    GameOver GM = new GameOver();
    
    public void act() 
    {
        if(getOneIntersectingObject(GreenBeam.class)!=null||getOneIntersectingObject(GreenBeam2.class)!=null)
        {
            getWorld().addObject(GM,getWorld().getWidth()/2,getWorld().getHeight()/2);
        }
    }    
}
