import greenfoot.*;  

public class StartScreen extends World
{
    public StartScreen()
    {    
        super(1300, 800, 1); 
        GreenfootImage bg = new GreenfootImage("black.jpg");
        bg.scale(getWidth()+220,getHeight()+80);
        setBackground(bg);
        Greenfoot.start();
    }
    
    private Points P1= new Points();
    private Points P2= new Points();
    private Points P3= new Points();
    
    public void act()
    {
        Intro Intro = new Intro();
        addObject(Intro,getWidth()/2,getHeight()/2);
        IntroIndication IntroIndication = new IntroIndication();
        addObject(IntroIndication,getWidth()/2,getHeight()-100);
        Greenfoot.delay(50);
        addObject(P1,610,410+50);
        if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new BraveBotsRoboticsClub());
        Greenfoot.delay(50);
        addObject(P2,635,410+50);
        if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new BraveBotsRoboticsClub());
        Greenfoot.delay(50);
        addObject(P3,660,410+50);
        if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new BraveBotsRoboticsClub());
        Greenfoot.delay(50);
        removeObject(P1);
        if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new BraveBotsRoboticsClub());
        Greenfoot.delay(50);
        removeObject(P2);
        if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new BraveBotsRoboticsClub());
        Greenfoot.delay(50);
        removeObject(P3);
        if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new BraveBotsRoboticsClub());
        Greenfoot.delay(50);
        if(Greenfoot.isKeyDown("enter")) Greenfoot.setWorld(new BraveBotsRoboticsClub());
    }
    
}
