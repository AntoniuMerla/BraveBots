import greenfoot.*;  
import java.util.*;

public class GreenBeam extends Playground
{
    GreenfootImage img= getImage();
    boolean E=true;
    int ok;
    boolean not_hit=true;
    
    public GreenBeam(int wew)
    {
        img.scale(100,7);
        ok=wew;
        setImage(img);
    }
    
    public void act() 
    {
         GreenfootSound S = new GreenfootSound("blaster.wav");
        if(getWorld().getObjects(GameOver.class).size()==0)
        {
            move();
            erase();
            {
               
                S.setVolume(70);
                S.play();
            }
        }
        else 
        {
            S.stop();
            List <ReferenceForYB> L_R = getWorld().getObjects(ReferenceForYB.class);
            ReferenceForYB LR=L_R.get(0);
            int x=LR.getX();
            int y=LR.getY();
            getWorld().addObject(KB,x,y+30);
        }
    } 
    
    KBoom KB= new KBoom();
    
    public void move()
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
            {
                if(getOneIntersectingObject(TheArmor.class)!=null)
                not_hit=false;
                
                if(getX()>175&&not_hit) 
                    {
                        setLocation(getX()-3,getY());
                    }
                    else 
                    {
                        getWorld().removeObject(this);
                        E=false;
                    }
             }
    }
    
    public void erase()
    {
        if(ok>=10&&E)
            {
                if(getX()<550)
                {
                    ok=ok-1;
                    img.scale(ok,7);
                    setImage(img);
                }
            }
    }
    
}
