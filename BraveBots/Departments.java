import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Departments here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Departments extends World
{
    
    OK OK=new OK();
    
    public Departments()
    {    

        super(1300, 800, 1); 
        GreenfootImage bg=new GreenfootImage("Departments.png");
        bg.scale(getWidth(),getHeight());
        setBackground(bg);
        addObject(OK,getWidth()/4*3,getHeight()/4*3);
    }
}
