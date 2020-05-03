import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Questions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Questions extends MenuElement
{
    public Questions()
    
    {
        GreenfootImage img=getImage();
        img.scale(50,50);
        setImage(img);
    }
    
    BackButtonText B=new BackButtonText("Întrebări? \nClick aici!");
    
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) Greenfoot.setWorld(new Indications());
        getWorld().addObject(B,1000,150);
    }   
}
