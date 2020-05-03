import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OK here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OK extends MenuElement
{
    
    public OK()
    {
        GreenfootImage img=getImage();
        img.scale(50,50);
        setImage(img);
    }
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        Greenfoot.setWorld(new Indications());
    }    
}
