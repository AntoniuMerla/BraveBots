import greenfoot.*;  

public class Platform extends Playground
{
    public Platform()
    {
        GreenfootImage img=getImage();
        turn(90);
        img.scale(500,1300);
        setImage(img);
    }
}
