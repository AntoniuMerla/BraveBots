import greenfoot.*;  

public class ReferenceForYB extends Playground
{
    public ReferenceForYB()
    {
        GreenfootImage img = getImage();
        img.scale(5,5);
        turn(90);
        getImage().setTransparency(0);
        setImage(img);
    }
    
    int rotation = 0;
    GameOver GM = new GameOver();
    //KBoom KB= new KBoom();
    
    public void act() 
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        {
            if(Greenfoot.isKeyDown("left")&&getX()-4*rotation>180)
        {
            setLocation(getX()-2,getY());
        }
        
            if(Greenfoot.isKeyDown("right")&&getX()-4*rotation<755)
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
        
        if(getOneIntersectingObject(GreenBeam.class)!=null||getOneIntersectingObject(GreenBeam2.class)!=null)
        {
           // getWorld().addObject(KB,getX(),getY());
           
            getWorld().addObject(GM,getWorld().getWidth()/2,getWorld().getHeight()/2);
        }
    }    
   }
}
