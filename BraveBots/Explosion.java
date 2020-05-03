import greenfoot.*;  

public class Explosion extends YellowBrick
{
    public Explosion()
    {
        GreenfootImage img = getImage();
        img.scale(50,50);
        setImage(img);
    }
    
    int time = 0;
    
    public void act() 
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        if(time<56)
        {
            if(time%5==0)
            {
                GreenfootImage img = new GreenfootImage("explosion"+time/5+".png");
                img.scale(50,50);
                setImage(img);
            }
            time++;
        }
        else 
        {
            getWorld().removeObject(this);
            time=0;
        }
    }    
}
