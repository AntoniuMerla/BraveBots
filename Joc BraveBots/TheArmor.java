import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TheArmor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TheArmor extends Robot
{
    int rotation=0;
    public boolean okarmor=true;
    int time=0;
    boolean change=false;
    boolean E=false;
    
    public TheArmor()
    
    {
        GreenfootImage img=getImage();
        img.scale(120,440);
        turn(91);
        img.mirrorVertically();
        setImage(img);
    }
    
    public void move()
    {
        
        if(getY()<796)
        {setLocation(getX(),getY()+3); turn(2);}
        else getWorld().removeObject(this);
        
    }
    
    public void act() 
    {
       if(getWorld().getObjects(GameOver.class).size()==0&&okarmor)
        {
        if(Greenfoot.isKeyDown("left")&&getX()>470)
        {
            setLocation(getX()-2,getY());
        }
        
        if(Greenfoot.isKeyDown("right")&&getX()<1045)
        {
            setLocation(getX()+2,getY());
        }
        
        if(Greenfoot.isKeyDown("up"))
        {
            if(rotation<40)
            {
                rotation++;
                turn(1);
            }
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            if(rotation>0)
            {
               rotation--;
               turn(-1);
            }
        }
        
        
        
        if((getOneIntersectingObject(GreenBeam.class)!=null||getOneIntersectingObject(GreenBeam2.class)!=null)&&okarmor)
        {

            change=true;
            /*GreenfootImage img=new GreenfootImage("armor.png");
            img.scale(20,215);
            setImage(img);
            okarmor=false;*/
            
           // move();
            //getWorld().addObject(KB,getX(),getY());
            //getWorld().addObject(GM,getWorld().getWidth()/2,getWorld().getHeight()/2);
        }
    }    
    
    
    
    if(!okarmor&&time==2)
        {
            if(!E)
            {getWorld().addObject(new Explosion(),getX()-150,getY()-100); E=true;}
            move();
        }
        
        if(change)
    {
        if(time==2)
       {GreenfootImage img=new GreenfootImage("armor.png");
            img.scale(20,215);
            setImage(img);
            okarmor=false; 
            change=false;}
            else time++;
    }
}
}
