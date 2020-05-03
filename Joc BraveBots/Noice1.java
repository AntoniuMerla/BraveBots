import greenfoot.*; 
import java.util.*; 
import java.io.*;
import java.net.URL;

public class Noice1 extends Playground
{
    
    int time=0;
    boolean check=false;
    Resource R[]= {new Resource(new GreenfootImage("xp.png")),new Resource(new GreenfootImage("blue.jpg")),new Resource(new GreenfootImage("blue.jpg")),new Resource(new GreenfootImage("like.png")),new Resource(new GreenfootImage("contract.png")),new Resource(new GreenfootImage("apps.jpg"))};
    //public int r[]={0,3,4,5};
    String F[]={"Xp.txt",".txt",".txt","Popularity.txt","Contracts.txt","Apps.txt"};
    public static int luck;
    public int value[]={100,0,0,5,1,3};
    BackButtonText BT[]={new BackButtonText("+100"),new BackButtonText(""),new BackButtonText(""),new BackButtonText("+5"),new BackButtonText("+1"),new BackButtonText("+3")};
    //public int needed[]={0,0,0,0,0,0};
    
    public Noice1()
    {
        GreenfootImage img=getImage();
        img.scale(100,100);
        setImage(img);
    }
    
    GreenfootSound S1 = new GreenfootSound("Noice.wav"), S2= new GreenfootSound("applause3.wav");
    
    public void act() 
    {
       announce();
        //Save();
    }    
    
    public void announce()
    {
        CelebrationFlag CF[]={new CelebrationFlag(),new CelebrationFlag(),new CelebrationFlag()};
        
        if(getWorld().getObjects(Tower.class).size()==5)
        {
            if(!check)
            {
            S1.play();
            S2.play();
            getWorld().addObject(CF[0],292,224);
            getWorld().addObject(CF[1],728,224);
            getWorld().addObject(CF[2],1222,109);
            luck=Greenfoot.getRandomNumber(6);
            while(luck==1||luck==2)
                luck=Greenfoot.getRandomNumber(6);
                Save();
                getWorld().addObject(R[luck],65,50);
                getWorld().addObject(BT[luck],35,50);
                check=true;
            }
            
            if(time==111&&check) 
            {
                List <Tower> T=getWorld().getObjects(Tower.class);
                int i;
                for(i=0; i<=4; i++) 
                getWorld().removeObject(T.get(i));
                getWorld().removeObject(R[luck]);
                getWorld().removeObject(BT[luck]);
                //getWorld().removeObject(A[luck]);
                check=false;
                time=0;
            }
            else time++;
        } else check=false;
    }
    
    int this_res=0;
    
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
