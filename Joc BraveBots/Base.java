import greenfoot.*;  
import java.util.*;

public class Base extends Playground
{
    public Base()
    {
        GreenfootImage img=getImage();
        img.scale(125,125);
        setImage(img);
    }
    
    int ht=0;
    Tower T[]={new Tower(),new Tower(),new Tower(),new Tower(),new Tower()};
    //int time; 
    //boolean ok=true;
    
    public void act()
    {
        /*if(getOneIntersectingObject(YellowBrick.class)!=null)
        {
            /*getWorld().addObject(T[ht],getX(),getY()-20*ht);
            if(getOneIntersectingObject(YellowBrick.class)==null)
            {
                ht++;
                //if(ht==5) ht=0;
            }
            if(ok) 
            {
                getWorld().addObject(T[ht],getX(),getY()-20*ht);
                ht++;
                ok=false;
            }
            
            
        }
        
        if(getOneIntersectingObject(YellowBrick.class)==null&&!ok) ok=true;*/
        
        if(getWorld().getObjects(YBrick2.class).size()!=0) 
        {
            List <YBrick2> L = getWorld().getObjects(YBrick2.class);
            YBrick2 Y = L.get(0);
            if(Y.getX()>=600&&Y.getX()<=700&&Y.getY()>=550&&Y.getY()<=600)
            {
                getWorld().removeObject(Y);
                
                if(ht<5)
                {
                  getWorld().addObject(T[ht],getX(),getY()-20*ht);
                  ht++;
                }
                 
                
                
                
                
            }
            
        }
        
        if(ht==5) 
                
                {
                    /*int i;
                    for(i=0; i<5; i++) 
                    getWorld().removeObject(T[i]);*/
                    ht=0;
                }
        
    }
}
