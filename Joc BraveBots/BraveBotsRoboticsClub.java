import greenfoot.*; 

public class BraveBotsRoboticsClub extends World
{
    Andrei Andrei= new Andrei();
    Ioana Ioana = new Ioana();
    John John = new John();
    Oprah Oprah = new Oprah();
    Thudor Thudor = new Thudor();
    
    WhiteBackSpace WBS = new WhiteBackSpace();
    BackButtonText WBT = new BackButtonText("Ieșire din joc");
    
    PlayButton PB=new PlayButton();
    
    CounterForManyThings C[]={new CounterForManyThings("(Experiență):","Xp.txt"),new CounterForManyThings("(Piulițe):","SteelNuts.txt"),new CounterForManyThings("(Șuruburi):","Screws.txt"), new CounterForManyThings("(Popularitate):","Popularity.txt"), new CounterForManyThings("(Contracte):","Contracts.txt"), new CounterForManyThings("(Aplicații):","Apps.txt")};
    Resource R[]= {new Resource(new GreenfootImage("xp.png")),new Resource(new GreenfootImage("steelnut.png")),new Resource(new GreenfootImage("screw.png")),new Resource(new GreenfootImage("like.png")),new Resource(new GreenfootImage("contract.png")),new Resource(new GreenfootImage("apps.jpg"))};
    HighScore HS=new HighScore();
    GoShopping GS=new GoShopping();
    Questions Q=new Questions();
    
    Department D[]={new Department("Construcție"),new Department("Programare"),new Department("PR"), new Department("Leadership"),new Department("Proiectare")};
    
    public BraveBotsRoboticsClub()
    {    
        super(1300, 800, 1);
        
        addObject(Andrei,90,110);
        addObject(D[0],90,230);
        addObject(Ioana,1200,700);
        addObject(D[2],1200,550);
        addObject(John,50,700);
        addObject(D[1],75,555);
        addObject(Oprah,750,700);
        addObject(D[3],700,545);
        addObject(Thudor,1200,235);
        addObject(D[4],1200,360);
        
        addObject(WBS,100,350);
        addObject(WBT,97,430);
        
        addObject(PB,getWidth()/2,getHeight()/2-50);
        addObject(HS,getWidth()/2,200);
        addObject(GS,375,106);
        addObject(Q,1000,106);
        
        int i;
        
        addObject(C[0],555,75);
        addObject(R[0],485,75);
        addObject(C[1],705,75);
        addObject(R[1],650,75);
        addObject(C[2],830,75);
        addObject(R[2],775,75);
        addObject(C[3],555,125);
        addObject(R[3],480,125);
        addObject(C[4],730,125);
        addObject(R[4],660,125);
        addObject(C[5],870,125);
        addObject(R[5],810,125);
    }
    
    private boolean ok[] = {false,false,false,false,false};
    
    Drill Drill = new Drill();
    Speaker Speaker = new Speaker();
    Laptop Laptop = new Laptop();
    Hand Hand = new Hand();
    BluePrint BluePrint= new BluePrint();
    
    GreenfootSound S[]={new GreenfootSound("electric-drill.mp3"),new GreenfootSound("i-cant-wait.wav"),new GreenfootSound("Typing.mp3"),new GreenfootSound("youcandoit.mp3"),new GreenfootSound("page-flip.mp3")};
    
    public void act()
    {
        
        if(Greenfoot.mouseMoved(Andrei)&&!ok[0])
        {
            addObject(Drill,275,40);
            ok[0] = true;
            S[0].play();
            
        }
        
        if(!Greenfoot.mouseMoved(Andrei)&&ok[0]&&Greenfoot.mouseMoved(null))
        {
            ok[0] = false;
            removeObject(Drill);
            S[0].stop();
        }
        
        if(Greenfoot.mouseMoved(Ioana)&&!ok[1])
        {
            addObject(Speaker,1000,700);
            ok[1] = true;
            S[1].play();
            
        }
        
        if(!Greenfoot.mouseMoved(Ioana)&&ok[1]&&Greenfoot.mouseMoved(null))
        {
            ok[1] = false;
            removeObject(Speaker);
            S[1].stop();
        }
        
        if(Greenfoot.mouseMoved(John)&&!ok[2])
        {
            addObject(Laptop,330,750);
            ok[2] = true;
            S[2].play();
            
        }
        
        if(!Greenfoot.mouseMoved(John)&&ok[2]&&Greenfoot.mouseMoved(null))
        {
            ok[2] = false;
            removeObject(Laptop);
            S[2].stop();
        }
        
        if(Greenfoot.mouseMoved(Oprah)&&!ok[3])
        {
            addObject(Hand,580,760);
            ok[3] = true;
            S[3].play();
            
        }
        
        if(!Greenfoot.mouseMoved(Oprah)&&ok[3]&&Greenfoot.mouseMoved(null))
        {
            ok[3] = false;
            removeObject(Hand);
            S[3].stop();
        }
        
        if(Greenfoot.mouseMoved(Thudor)&&!ok[4])
        {
            addObject(BluePrint,1200,75);
            ok[4] = true;
            S[4].play();
            
        }
        
        if(!Greenfoot.mouseMoved(Thudor)&&ok[4]&&Greenfoot.mouseMoved(null))
        {
            ok[4] = false;
            removeObject(BluePrint);
            S[4].stop();
        }
        
        if(Greenfoot.mouseClicked(PB)) 
        Greenfoot.setWorld(new TheGameOfTheRobot());
    }
    
}