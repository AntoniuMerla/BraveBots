import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Proba extends Actor
{
    
    
    
    public void act() 
    {
        List <CelebrationFlag> L=getWorld().getObjects(CelebrationFlag.class);
    CelebrationFlag G=L.get(0);
       setImage(new GreenfootImage("X: "+G.getX()+"Y: "+G.getY(),35,Color.BLACK,Color.WHITE));
    }    
}
