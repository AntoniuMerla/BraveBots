import greenfoot.*;  

public class Laptop extends John
{
    public Laptop()
    {
        GreenfootImage img=getImage();
        img.mirrorHorizontally();
        setImage(img);
    }
}
