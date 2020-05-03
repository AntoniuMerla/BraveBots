import greenfoot.*;  

public class Oprah extends Member
{
    public Oprah()
    {
        GreenfootImage img=getImage();
        img.scale(350,350);
        setImage(img);
    }
    
    private boolean hovering=false;
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) 
        Greenfoot.setWorld(new Leader_s_Menu());
        
        if(Greenfoot.mouseMoved(this)&&!hovering)
        {
            hovering=true;
            GreenfootImage img2= new GreenfootImage("OprahTranscended.png");
            img2.scale(350,350);
            setImage(img2);
        }
        
        if(!Greenfoot.mouseMoved(this)&&hovering&&Greenfoot.mouseMoved(null))
        {
            hovering=false;
            GreenfootImage img2= new GreenfootImage("Oprah.png");
            img2.scale(350,350);
            setImage(img2);
        }
    }
}
