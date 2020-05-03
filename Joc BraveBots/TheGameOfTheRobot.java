import greenfoot.*;  
import java.util.*;
import java.io.*;
import java.net.URL; 

public class TheGameOfTheRobot extends World
{
    Platform Platform = new Platform();
    Base Base= new Base();
    
    Chassis Chassis= new Chassis();
    Wheel W[]={new Wheel(-50),new Wheel(50)};
    Arm Arm = new Arm();
    ArmWheel AW= new ArmWheel();
    FirstArmWheel FAW = new FirstArmWheel();
    Claw Claw = new Claw();
    ReferenceForYB RFYB = new ReferenceForYB();
    CurrentScore CS=new CurrentScore();
    boolean alive = true;
    Noice1 N1=new Noice1();
    Noice2 N2=new Noice2();
    int attack_time=0;
    TheArmor TheArmor=new TheArmor();
    
    //private BraveBotsRoboticsClub BBRC;
    
    public TheGameOfTheRobot(/*BraveBotsRoboticsClub BBC*/)
    {    
        super(1300, 800, 1); 
        GreenfootImage bg = new GreenfootImage("audience.jpg");
        bg.scale(getWidth()+220,getHeight()+80);
        setBackground(bg);
        //Greenfoot.start();
        addObject(N1,50,50);
        addObject(N2,1250,50);
        addObject(Platform,getWidth()/2,750);
        addObject(Base,getWidth()/2,630);
        addObject(Claw,getWidth()/2-30,613);
        addObject(Arm,getWidth()/2+45,620);
        
        try
        {
            URL path = getClass().getClassLoader().getResource("BoughtArmor.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            ba=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        if(ba==2)
        addObject(TheArmor,getWidth()/2+60,605);
        
        addObject(Chassis,getWidth()/2,660);
        addObject(W[0],getWidth()/2-50,720);
        addObject(W[1],getWidth()/2+50,720);
        addObject(AW,getWidth()/2+50,613);
        addObject(FAW,getWidth()/2+57,607);
        addObject(RFYB,getWidth()/2-244,600); 
        addObject(CS,getWidth()/2,50);
        //BBRC=BBC;
        
    }
    
    public int bds=0;
    public int bg=0;
    
    public int ds_used=0;
    public int g_used=0;
    
    public int ba=0;
    
    public void Read()
    {
        
        try
        {
            URL path = getClass().getClassLoader().getResource("BoughtDS.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            bds=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("BoughtGelu.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            bg=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        
    }
    
    public void act()
    {
        Read();
        setPaintOrder(Resource.class,Playground.class);
        setPaintOrder(Robot.class,Tower.class);
        setPaintOrder(GameOver.class,KBoom.class);
        setPaintOrder(BackButtonText.class,Resource.class,Noice1.class);
        setPaintOrder(BackButtonText.class,Resource.class,Noice2.class);
       // setPaintOrder(FirstArmWheel.class,TheArmor.class);
        //setPaintOrder(ArmWheel.class,TheArmor.class);
        //setPaintOrder(Noice1.class,YellowBrick.class);
        //setPaintOrder(Noice2.class,YellowBrick.class);
        yeeted();
        if(alive)
    {
        legos();
        spawn();
        fire();
        if(attack_time%200==0) fight();
        attack_time++;
        
    } else attack_time=0;
    }

    int time = 8000;
    int pause = 500;
    int nooflegos=0;
    int noofrb=0;
    YellowBrick YB[]={new YellowBrick(),new YellowBrick(),new YellowBrick(),new YellowBrick(),new YellowBrick()};
    RedBeam RB[]={new RedBeam(),new RedBeam(),new RedBeam(),new RedBeam(),new RedBeam()};
    
    public void legos()
    {
        int i,j;
        
        check();
        if(time==0) time = 8000;
        else 
        {
            check();
            if(time%1013==0&&pause>100) pause--;
            check();
            if(time%pause==0) 
            {
                if(nooflegos==5) nooflegos=0;
                check();
                addObject(YB[nooflegos],300+Greenfoot.getRandomNumber(700),50);
                check();
                //here[nooflegos]=true;
                check();
                nooflegos++;
                check();
            }
            time--;
            check();
        }
    }
    
    public void check()
    {
        List <YellowBrick> YBL=getObjects(YellowBrick.class);
        int i;
        for(i=0; i<YBL.size(); i++) 
        {
            if(YBL.get(i).getY()==360)
            {
                addObject(RB[i],YBL.get(i).getX(),800);
            }
        }
    }
    
    int time_respawn = 7999;
    boolean stright=false;
    boolean stleft=false;
    StormTrooper ST = new StormTrooper();
    StormTrooper2 ST2= new StormTrooper2();
    
    public void spawn()
    {
        if(time_respawn%1000==0&&!stright)
        {
            addObject(ST,1300,540);
            stright=true;
        }
        if((time_respawn-500)%1000==0&&!stleft)
        {
            addObject(ST2,0,540);
            stleft=true;
        }
        time_respawn--;
        if(time_respawn==-1) time_respawn=7999;
        if(getObjects(StormTrooper.class).size()==0) stright=false;
        if(getObjects(StormTrooper2.class).size()==0) stleft=false;
        
    }
    
    int timef[]={8313,8000};
    int pausef[]={500,500};
    GreenBeam GB= new GreenBeam(100);
    GreenBeam2 GB2= new GreenBeam2(100);
    
    public void fire()
    {
        if(stright)
        {
            if(timef[0]==313) timef[0]=8313;
            else 
            {
                if(timef[0]%1013==0&&pausef[0]>100) pausef[0]--;
                if(timef[0]%pausef[0]==0) 
                {
                    
                    addObject(GB,1050,525); //505
                }
                timef[0]--;
            }
            if(getObjects(GreenBeam.class).size()==0) GB=new GreenBeam(100);
        }
        
        if(stleft)
        {
            if(timef[1]==0) timef[1]=8000;
            else 
            {
                if(timef[1]%1013==0&&pausef[1]>100) pausef[1]--;
                if(timef[1]%pausef[1]==0) 
                {
                    
                    addObject(GB2,175,525); //505
                }
                timef[1]--;
            }
            if(getObjects(GreenBeam2.class).size()==0) GB2=new GreenBeam2(100);
        }
        
    }
    
    public void yeeted()
    {
        if(getObjects(GameOver.class).size()!=0) 
        {
            alive=false;
            if(Greenfoot.isKeyDown("M")) {Greenfoot.setWorld(new BraveBotsRoboticsClub());/*Greenfoot.setWorld(BBRC);*/ alive=true;}
            if(Greenfoot.isKeyDown("Enter")) {Greenfoot.setWorld(new TheGameOfTheRobot());/*Greenfoot.setWorld(new TheGameOfTheRobot(BBRC));*/ alive=true;}
        }
    }
    
    public void fight()
    {
        if(getObjects(StormTrooper.class).size()!=0&&getObjects(StormTrooper2.class).size()!=0)
        {if(Greenfoot.isKeyDown("1")&&bg==1&&g_used<=1) {addObject(new Gelu(),50,0); g_used++;}
        if(Greenfoot.isKeyDown("2")&&bds==1&&ds_used==0) {addObject(new Dinu_s_Sword(),1200,0); ds_used++; }}
    }
}
