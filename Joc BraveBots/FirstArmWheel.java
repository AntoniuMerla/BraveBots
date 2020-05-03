import greenfoot.*;  

public class FirstArmWheel extends Robot
{
    GreenfootImage img = getImage();
    int step=0;
    int distance=0;
    
    public FirstArmWheel()
    {
        img.scale(47,48);
        setImage(img);
    }
    
    GreenfootSound S=new GreenfootSound("Robo.wav");
    
    public void act()
    {
        if(getWorld().getObjects(GameOver.class).size()==0)
        {
            
                    if(Greenfoot.isKeyDown("left")&&getX()>481)
        {
            //if(!Greenfoot.isKeyDown("right"))
            setLocation(getX()-2,getY());
        }
        
        if(Greenfoot.isKeyDown("right")&&getX()<1057)
        {
            //if(!Greenfoot.isKeyDown("left"))
            setLocation(getX()+2,getY());
        }
            
        if(Greenfoot.isKeyDown("up"))
        {
           if(step<5) step++;
           else step=0;
           
           turn(step);
           
           if(step==0) 
           turn(-15);
           
           setImage(img);
           
           if(distance>0) distance=0;
           distance--;
           
           S.play();
            
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
           if(step<5) step++;
           else step=0;
           
           turn(step);
           
           if(step==0) 
           turn(-15);
           
           setImage(img);
           
           if(distance<0) distance=0;
           distance++;
           
           S.play();
           
        }
       
    }
   }
}
