import greenfoot.*;  

public class Dinu_s_Sword extends Robot
{

    public Dinu_s_Sword()
    {
        GreenfootImage img=getImage();
        img.scale(50,100);
        //turn(180);
        setImage(img);
    }
    
    public void act() 
    {
        
        /*if(getOneIntersectingObject(StormTrooper.class)!=null||getOneIntersectingObject(StormTrooper2.class)!=null) { getWorld().removeObject(this); }
        else move();*/
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
