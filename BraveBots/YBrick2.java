import greenfoot.*; 
import java.util.*;

public class YBrick2 extends Playground
{

    public YBrick2()
    {
        GreenfootImage img=getImage();
        img.scale(50,50);
        setImage(img);
    }
    
    boolean in_action=true;
    
    public void act() 
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        {
            taken(); 
            //if(/*getOneIntersectingObject(Claw.class)==null&&in_action&&*/getOneIntersectingObject(RedBeam.class)!=null&&getOneIntersectingObject(ReferenceForYB.class)==null) correct();
            if(getOneIntersectingObject(ReferenceForYB.class)==null) correct();
            //build(); 

        }
    }    
    
    public int rotation=40;
    
           public void taken()
       {
              
        if(Greenfoot.isKeyDown("left")&&getX()-rotation*4>180)
        {
            setLocation(getX()-2,getY());
        }
        
        if(Greenfoot.isKeyDown("right")&&getX()-rotation*4<755)
        {
            setLocation(getX()+2,getY());
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(rotation<40)
            {
                rotation++;
                setLocation(getX()+4,getY()-4);
            }
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            if(rotation>0)
            {
                rotation--;
                setLocation(getX()-4,getY()+4);
            }
        }
    }  
    
    
        public void build()
        {
            if(getOneIntersectingObject(Base.class)!=null) 
            {
                //getWorld().addObject(T,getWorld().getWidth()/2,700);
                in_action=false;
                getWorld().removeObject(this);

            }
        }
        
        public void correct()
        {
            /*List <Claw> ClawList = getWorld().getObjects(Claw.class);
            Claw TheClaw = ClawList.get(0);
            //if(getOneIntersectingObject(Claw.class)==null) 
            if(getOneIntersectingObject(Claw.class)==null) 
            {
                setLocation(TheClaw.getX(),TheClaw.getY());
            }*/
            List <ReferenceForYB> R_L=getWorld().getObjects(ReferenceForYB.class);
            ReferenceForYB RL=R_L.get(0);
            int x=RL.getX();
            int y=RL.getY();
            //setLocation(getX()-10,getY()+50);
            setLocation(x,y);
        }
        
    
}
