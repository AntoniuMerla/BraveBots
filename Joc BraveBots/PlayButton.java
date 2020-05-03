import greenfoot.*; 

public class PlayButton extends MenuElement
{
    public PlayButton()
    {
        GreenfootImage img=getImage();
        img.scale(150,150);
        setImage(img);
    }
    
    public void act() 
    {
        getWorld().addObject(new PlaySir(),getX(),getY()+100);
    }    
}
