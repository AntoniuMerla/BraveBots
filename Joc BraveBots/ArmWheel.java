
import greenfoot.*;  

public class ArmWheel extends Arm
{
    public ArmWheel()
    {
        GreenfootImage img = getImage();
        img.scale(30,440);
        img.mirrorHorizontally();
        setImage(img);
    }
    
    int rotation=0;
    GameOver GM = new GameOver();
    // KBoom KB= new KBoom();
    
    public void act()
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        {if(Greenfoot.isKeyDown("left")&&getX()>475)
        {
            setLocation(getX()-2,getY());
        }
        
        if(Greenfoot.isKeyDown("right")&&getX()<1050)
        {
            setLocation(getX()+2,getY());
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(rotation<40)
            {
                rotation++;
                turn(1);
            }
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            if(rotation>0)
            { 
                rotation--;
                turn(-1);
            }
        }
        
        if(getOneIntersectingObject(GreenBeam.class)!=null||getOneIntersectingObject(GreenBeam2.class)!=null)
        {
            //getWorld().addObject(KB,getX(),getY());
            getWorld().addObject(GM,getWorld().getWidth()/2,getWorld().getHeight()/2);
            //Greenfoot.stop();
            //if(Greenfoot.isKeyDown("BackSpace")) Greenfoot.setWorld(new BraveBotsRoboticsClub());
            //if(Greenfoot.isKeyDown("Space")) Greenfoot.setWorld(new TheGameOfTheRobot());
        }
   }}
}
