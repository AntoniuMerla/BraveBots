import greenfoot.*;  

public class BackSpace extends MenuElement
{
    public BackSpace()
    {
        GreenfootImage img=getImage();
        img.scale(200,200);
        setImage(img);
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("backspace"))
        Greenfoot.setWorld(new BraveBotsRoboticsClub());
    }    
}
