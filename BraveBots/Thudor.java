import greenfoot.*;  

public class Thudor extends Member
{
    public Thudor()
    {
        GreenfootImage img=getImage();
        img.scale(275,275);
        turn(-90);
        setImage(img);
    }
    
    private boolean hovering=false;
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this)) 
        Greenfoot.setWorld(new DesignMenu());
        
        if(Greenfoot.mouseMoved(this)&&!hovering)
        {
            hovering=true;
            GreenfootImage img2= new GreenfootImage("ThudorTranscended.png");
            img2.scale(275,275);
            setImage(img2);
        }
        
        if(!Greenfoot.mouseMoved(this)&&hovering&&Greenfoot.mouseMoved(null))
        {
            hovering=false;
            GreenfootImage img2= new GreenfootImage("Thudor.png");
            img2.scale(275,275);
            setImage(img2);
        }
    }
}
