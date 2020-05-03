import greenfoot.*; 

public class GoShopping extends MenuElement
{
    
    public GoShopping()
    
    {
        GreenfootImage img=getImage();
        img.scale(50,50);
        setImage(img);
    }
    
    BackButtonText B=new BackButtonText("Magazin");
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) Greenfoot.setWorld(new Store());
        getWorld().addObject(B,375,150);
    }    
}
