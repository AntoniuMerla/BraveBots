import greenfoot.*; 
import java.util.*; 
import java.io.*;
import java.net.URL;

public class Noice2 extends Noice1
{
    int time=0;
    boolean check=false;
    boolean alive=false;
    Resource R[]= {new Resource(new GreenfootImage("xp.png")),new Resource(new GreenfootImage("steelnut.png")),new Resource(new GreenfootImage("screw.png")),new Resource(new GreenfootImage("like.png")),new Resource(new GreenfootImage("contract.png")),new Resource(new GreenfootImage("apps.jpg"))};
    //Add A[]={new Add(0),new Add(3), new Add(4), new Add(5)};
    //public int r[]={0,3,4,5};
    String F[]={"Xp.txt","SteelNuts.txt","Screws.txt","Popularity.txt","Contracts.txt","Apps.txt"};
    public static int luck;
    int value[]={0,2,1,0,0,0};
    public static int weapon;
    BackButtonText BT[]={new BackButtonText(""),new BackButtonText("+2"),new BackButtonText("+1"),new BackButtonText(""),new BackButtonText(""),new BackButtonText("")};
    //public int needed[]={0,0,0,0,0,0};
    
    public Noice2()
    {
        GreenfootImage img=getImage();
        img.scale(100,100);
        setImage(img);
    }
    
    GreenfootSound S1 = new GreenfootSound("Noice.wav"), S2= new GreenfootSound("applause3.wav");
    
    public void act() 
    {
        //setPaintOrder(Resource.class,Noice2.class);
       announce();
        //Save();
    }    
    
    StormTrooper ST1;
    StormTrooper2 ST2;
    
    public void announce()
    {
        CelebrationFlag CF[]={new CelebrationFlag(),new CelebrationFlag(),new CelebrationFlag()};
        if(getWorld().getObjects(StormTrooper.class).size()>0&&getWorld().getObjects(StormTrooper2.class).size()>0)        
        {
            List <StormTrooper> L1=getWorld().getObjects(StormTrooper.class);
            StormTrooper ST1=L1.get(0);
            List <StormTrooper2> L2=getWorld().getObjects(StormTrooper2.class);
            StormTrooper2 ST2=L2.get(0);
            alive=true;
            //GreenfootImage img=new GreenfootImage("dst0.jpg");
            //img.scale(200,200);
        }   
            if(/*ST1.getImage().equals(img)||ST2.getImage().equals(img)*/alive&&(getWorld().getObjects(StormTrooper.class).size()==0||getWorld().getObjects(StormTrooper2.class).size()==0))
            //if(getWorld().getObjects(Tower.class).size()==5)
        {
            if(!check)
            {
            S1.play();
            S2.play();
            getWorld().addObject(CF[0],124,314);
            getWorld().addObject(CF[1],959,424);
            getWorld().addObject(CF[2],1233,341);
            luck=Greenfoot.getRandomNumber(6);
            while(luck!=1&&luck!=2)
                luck=Greenfoot.getRandomNumber(6);
                Save();
                getWorld().addObject(R[luck],1265,50);
                getWorld().addObject(BT[luck],1230,50);
                check=true;
            }
            
            if(time==111&&check) 
            {
                //List <Tower> T=getWorld().getObjects(Tower.class);
                int i;
                //for(i=0; i<=4; i++) 
                //getWorld().removeObject(T.get(i));
                getWorld().removeObject(R[luck]);
                getWorld().removeObject(BT[luck]);
                check=false;
                alive=false;
                time=0;
            }
            else time++;
        } else check=false;
    
    }
    
    public int this_res=0;
    
    public void Save()
    {
        this_res=0;
        Read();
        WriteDown();
    }
    
    public void Read()
    {
        int i;
        try
        {
            URL path = getClass().getClassLoader().getResource(F[luck]);
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            this_res=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) { }
        this_res=this_res+value[luck];
        
    }
    
    public void WriteDown()
    {
        int i;
        try
        {
            BufferedWriter output=new BufferedWriter(new FileWriter(F[luck]));
            output.flush();
            output.write(""+this_res);
            output.newLine();
            output.close();
        }catch (Exception e){}
    }    
}
