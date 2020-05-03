import greenfoot.*;  

public class YellowBrick extends Playground
{
    public YellowBrick()
    {
        GreenfootImage img= getImage();
        img.scale(50,50);
        setImage(img);
    }
    
    private boolean earned = false;
    int time=0;
    boolean ouch = false;
    
    public void act()
    {
        if(!earned)
        {
            gravity();
            the_moment();
            /*if(getOneIntersectingObject(ReferenceForYB.class)!=null&&getOneIntersectingObject(Claw.class)!=null) //conditie daca un lego e deja luat de cleste
            if(getWorld().getObjects(YBrick2.class).size()==0)
            earned = true;*/
            
            if(getOneIntersectingObject(RedBeam.class)!=null&&getY()>360) 
            {
                //if(getOneIntersectingObject(ReferenceForYB.class)==null)
                if(!earned)
                ouch = true;
            }
            if(ouch) 
            {
                if(time==1) 
                {
                    getWorld().removeObject(this); 
                    ouch=false;
                }
                time++;
            }
            else time=0;
        }
        else 
        {
            
            taken();
        }
        
    }
    
        public void gravity()
    {
        if(getWorld().getObjects(GameOver.class).size()==0) setLocation(getX(),getY()+1);
    }
    
        void the_moment()
        {
            if(getOneIntersectingObject(ReferenceForYB.class)!=null&&getOneIntersectingObject(Claw.class)!=null/*&&getWorld().getObjects(YBrick2.class).size()==0*/) //conditie daca un lego e deja luat de cleste
            if(getWorld().getObjects(YBrick2.class).size()==0)
            earned = true;
        }
    
       YBrick2 YB2= new YBrick2();
    
      void taken()
       {
              
        getWorld().addObject(YB2,getX(),getY());
        getWorld().removeObject(this);
        earned = false;
       // if(getWorld().getObjects(YBrick2.class).size()==0) getWorld().removeObject(this);

       }
}
