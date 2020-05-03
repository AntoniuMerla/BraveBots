import greenfoot.*;

public class Drill extends Andrei
{
    public Drill() 
    {
        GreenfootImage img= getImage();
        img.scale(150,150);
        getImage().mirrorHorizontally();
        setImage(img);
    }    
}
