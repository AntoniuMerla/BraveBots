import greenfoot.*;  

public class Arm extends Robot
{
    int rotation=0;
    
    public Arm()
    {
        GreenfootImage img=getImage();
        img.scale(80,450);
        turn(93);
        img.mirrorVertically();
        setImage(img);
    }
    
    GameOver GM = new GameOver();
    // KBoom KB= new KBoom();
    
    public void act()
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        {
        if(Greenfoot.isKeyDown("left")&&getX()>470)
        {
            setLocation(getX()-2,getY());
        }
        
        if(Greenfoot.isKeyDown("right")&&getX()<1045)
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
        }
    }
   }
}
