import greenfoot.*;  

public class Chassis extends Robot

{
    public Chassis()
    {
        GreenfootImage img=getImage();
        img.scale(200,200);
        setImage(img);
    }
    
    public void act()
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        
        {
        if(Greenfoot.isKeyDown("left")&&getX()>425)
        {
            setLocation(getX()-2,getY());
        }
        
        if(Greenfoot.isKeyDown("right")&&getX()<1000)
        {
            setLocation(getX()+2,getY());
        }
    }
   }
}
