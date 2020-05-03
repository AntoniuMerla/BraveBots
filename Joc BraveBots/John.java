import greenfoot.*;  

public class John extends Member
{
        public John()
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
        Greenfoot.setWorld(new ProgrammingMenu());
        
        if(Greenfoot.mouseMoved(this)&&!hovering)
        {
            hovering=true;
            GreenfootImage img2= new GreenfootImage("JohnTranscended.png");
            img2.scale(275,275);
            setImage(img2);
        }
        
        if(!Greenfoot.mouseMoved(this)&&hovering&&Greenfoot.mouseMoved(null))
        {
            hovering=false;
            GreenfootImage img2= new GreenfootImage("John.png");
            img2.scale(275,275);
            img2.mirrorHorizontally();
            setImage(img2);
        }
    }
}
