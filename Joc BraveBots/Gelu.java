import greenfoot.*; 

public class Gelu extends Robot
{
    
    public Gelu()
    {
        GreenfootImage img=getImage();
        img.scale(50,100);
        turn(180);
        setImage(img);
    }
    
    public void act() 
    {
        int time=0;
        if(getY()==393)
        //if(getOneIntersectingObject(StormTrooper.class)!=null||getOneIntersectingObject(StormTrooper2.class)!=null) 
        { 
            //if(time==1)
            getWorld().removeObject(this);
            //else time++;
        }
        else move();
    }    
    
    public void move()
    {
        setLocation(getX(),getY()+3);
    }
}
