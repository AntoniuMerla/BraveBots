import greenfoot.*; 

public class Ioana extends Member
{
    
    public Ioana()
    {
        GreenfootImage img=getImage();
        img.scale(275,275);
        img.mirrorHorizontally();
        setImage(img);
    }
    
    private boolean hovering=false;
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) 
        Greenfoot.setWorld(new PRMenu());
        
        if(Greenfoot.mouseMoved(this)&&!hovering)
        {
            hovering=true;
            GreenfootImage img2= new GreenfootImage("IoanaTranscended.png");
            img2.mirrorHorizontally();
            img2.scale(275,275);
            setImage(img2);
        }
        
        if(!Greenfoot.mouseMoved(this)&&hovering&&Greenfoot.mouseMoved(null))
        {
            hovering=false;
            GreenfootImage img2= new GreenfootImage("Ioana1.png");
            img2.mirrorHorizontally();
            img2.scale(275,275);
            setImage(img2);
        }
    } 
}
