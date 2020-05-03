import greenfoot.*;  

public class Wheel extends Robot
{
    
    GreenfootImage img = getImage();
    int step=0;
    int distance=0;
    int position;
    
    public Wheel(int x)
     {
       img.scale(30,30);
       setImage(img);
       position=x;
     }
    
    public void act()
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        {if(Greenfoot.isKeyDown("left")&&getX()>425+position)
        {
           if(step<5) step++;
           else step=0;
           
           turn(step);
           
           if(step==0) 
           turn(-15);
           
           setImage(img);
           
            if(distance>0) distance=0;
            distance--;
            setLocation(getX()-2,getY());
            
        }
        
        if(Greenfoot.isKeyDown("right")&&getX()<1000+position)
        {
           if(step<5) step++;
           else step=0;
           
           turn(step);
           
           if(step==0) 
           turn(-15);
           
           setImage(img);
           
           if(distance<0) distance=0;
           distance++;
           setLocation(getX()+2,getY());
        }
    }}
}
