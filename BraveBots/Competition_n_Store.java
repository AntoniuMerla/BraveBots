import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Competition_n_Store extends World
{

    OK OK=new OK();
    
    public Competition_n_Store()
    {    
           

        super(1300, 800, 1); 
        GreenfootImage bg=new GreenfootImage("CompetnStore.jpg");
        bg.scale(getWidth(),getHeight());
        setBackground(bg);
        addObject(OK,getWidth()/4*3,getHeight()/4*3);
    }
}
