import greenfoot.*;  

public class RedBeam extends Explosion
{
    public RedBeam()
    {
        GreenfootImage img = getImage();
        img.scale(100,7);
        turn(90);
        setImage(img);
    }
    
    boolean ouch = false;
    Explosion Explosion = new Explosion();
    boolean exist=true;

    public void act() 
    {
            shot();
            
            if(getOneIntersectingObject(YellowBrick.class)!=null&&getOneIntersectingObject(ReferenceForYB.class)==null&&getY()>500&&getOneIntersectingObject(YBrick2.class)==null) 
            {
                getWorld().addObject(Explosion,getX(),getY()-50);
                getWorld().removeObject(this);
                exist=false;
                ouch=true;
            }
            
            if(!ouch&&exist)
            {
                if(getY()==0)
                getWorld().removeObject(this);
                exist=false;
                
            }
            
            if(ouch&&exist)
            {
                if(getY()==0)
                {getWorld().removeObject(this);
                    ouch=false;
                    exist=false;
                }
            }
            
            if(!exist) exist=true;
            
            GreenfootSound S = new GreenfootSound("blaster.wav");
            S.setVolume(70);
            S.play();
    }    
    
    public void shot()
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        setLocation(getX(),getY()-3);
    }
    
}
