import greenfoot.*; 

public class WhiteBackSpace extends MenuElement
{
    public WhiteBackSpace()
    {
        GreenfootImage img= getImage();
        img.scale(100,100);
        setImage(img);
        
    }
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("backspace"))
        {
            System.exit(0);
        }
    }    
}
