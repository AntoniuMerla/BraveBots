import greenfoot.*; 


public class CelebrationFlag extends Noice1
{
    int time=0;
    boolean ok=true;
    GreenfootImage img=getImage();
    
    public CelebrationFlag()
    {
        img.scale(75,150);
        //img.rotate(20);
        setImage(img);
    }
    
    public void act() 
    {
        if(time<121)
        {
            if(time%40==0) 
            {
                if(ok) 
                {
                    //img.rotate(-40);
                    img.mirrorHorizontally();
                    setImage(img);
                    ok=false;
                }
                else 
                {
                    ok=true; 
                    //img.rotate(40); 
                    img.mirrorHorizontally();
                    setImage(img);
                }
            }
            time++;
        }
        else 
        { 
            getWorld().removeObject(this);
            time=0;
        }
    }    
}
