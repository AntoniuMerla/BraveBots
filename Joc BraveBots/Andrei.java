import greenfoot.*;  

public class Andrei extends Member
{
    public Andrei()
    {
        GreenfootImage img=getImage();
        img.scale(250,250);
        turn(180);
        setImage(img);
    }
    
    private boolean hovering=false;
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) 
        Greenfoot.setWorld(new BuildingMenu());
        
        if(Greenfoot.mouseMoved(this)&&!hovering)
        {
            hovering=true;
            GreenfootImage img2= new GreenfootImage("AndreiTranscended.png");
            img2.scale(250,250);
            setImage(img2);
        }
        
        if(!Greenfoot.mouseMoved(this)&&hovering&&Greenfoot.mouseMoved(null))
        {
            hovering=false;
            GreenfootImage img2= new GreenfootImage("Andrei1.png");
            img2.scale(250,250);
            setImage(img2);
        }
    }
}
