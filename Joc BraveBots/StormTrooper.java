import greenfoot.*;  
import java.util.*;

public class StormTrooper extends Playground
{
    int step=0;
    int distance=0;
    GreenfootImage S[]={new GreenfootImage("stormtrooper0.png"),new GreenfootImage("stormtrooper1.png"),new GreenfootImage("stormtrooper2.png"),new GreenfootImage("stormtrooper3.png"),new GreenfootImage("stormtrooper4.png"),new GreenfootImage("stormtrooper5.png")};
    GreenfootImage D[]={new GreenfootImage("dst0.png"),new GreenfootImage("dst1.png"),new GreenfootImage("dst2.png"),new GreenfootImage("dst3.png"),new GreenfootImage("dst4.png"),new GreenfootImage("dst5.png")};
    
    public StormTrooper()
    {
        int i;
        for(i=0; i<6; i++) 
        {
            S[i].scale(200,200);
            D[i].scale(200,200);
        }
        
        D[4].scale(200,75);
        D[5].scale(200,75);
        
        setImage(S[0]);
    }
    
    //boolean yes=true;
    
    public void act() 
    {
        if(getWorld().getObjects(GameOver.class).size()==0) 
        {
           if(!ouch)
           move(); 
           not_alive();
        }
    }
    
    int time = 0;
    
    public void move()
    {
        if(getX()>1200)
        { 
            if(time%10==0)
            {
                setImage(S[(time/10)%6]);
                setLocation(getX()-2,getY());
            }
            time++;
        } else time=0;
    }
    
    int time2=0;
    boolean ouch=false;
    
    public void not_alive()
    {
        if(getWorld().getObjects(Dinu_s_Sword.class).size()>0) 
        {
            List <Dinu_s_Sword> L=getWorld().getObjects(Dinu_s_Sword.class);
            Dinu_s_Sword G = L.get(0);
            if(G.getX()>=1200&&G.getX()<=1300) 
            {
                if(G.getY()==393) ouch=true;
                
            }
        }
        
        if(ouch)  
                {
                    if(time2<152)
                    {
                        if(time2%30==0) 
                        {
                            setImage(D[time2/30]);
                        }
                        time2++;
                    } 
                    else 
                    {
                        getWorld().removeObject(this);
                        time2=0;
                        ouch=false;
                    }
                }
        
        /*if(getOneIntersectingObject(Gelu.class)!=null||getOneIntersectingObject(Dinu_s_Sword.class)!=null) 
        {
            //yes=false;
            if(time2<152)
            {
            if(time2%30==0) 
            {
                setImage(D[(time/30)%6]);
            }
            time2++;
        }
            else {getWorld().removeObject(this); yes=true;}*/
        }
}
