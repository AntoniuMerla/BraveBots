import greenfoot.*;
import java.io.*;
import java.net.URL;  

public class Armor extends Items
{
    
    public Armor()
    {
        GreenfootImage img=getImage();
        turn(80);
        img.scale(100,20);
        setImage(img);
    }
    
    ButtonText B=new ButtonText("Armură");
    ConfirmationFrame CF= new ConfirmationFrame();
    ButtonText BConf=new ButtonText("Descriere: O a doua șansă. \n Ofertă așteptată: 20 Piulițe, 20 Șuruburi \n Interesat(ă)???");
    Yes Yes= new Yes();
    No No = new No();
    ButtonText Msg[]={new ButtonText("DA"), new ButtonText("NU")};
    
    BackSpace BackSpace=new BackSpace();
    BackButtonText BackButtonText= new BackButtonText("Înapoi spre Meniu");
    
    
    
    private boolean upgrade = false;
    
    Already A=new Already();
    
    Unavailable2 U=new Unavailable2();
    
    ArmorCount AC=new ArmorCount();
    
    public void act() 
    {
        Read();
        
        if(Greenfoot.mouseClicked(this)&&!upgrade)
            {
                upgrade = true;
                Confirmation();
                
            }
            
            Choice_Done();
    }    
    
    public int this_one=0;
    public int sn=0;
    public int scr=0;
    
    public void Read()
    {
        
        try
        {
            URL path = getClass().getClassLoader().getResource("BoughtArmor.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            this_one=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("SteelNuts.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            sn=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Screws.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            scr=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
    }
    
        public void Write()
    {
        
       try
        {
            BufferedWriter output=new BufferedWriter(new FileWriter("BoughtArmor.txt"));
            output.flush();
            output.write(""+(this_one+1));
            output.newLine();
            output.close();
        }catch (Exception e){}
        
        try
        {
            BufferedWriter output=new BufferedWriter(new FileWriter("SteelNuts.txt"));
            output.flush();
            output.write(""+(sn-20));
            output.newLine();
            output.close();
        }catch (Exception e){}
        
        try
        {
            BufferedWriter output=new BufferedWriter(new FileWriter("Screws.txt"));
            output.flush();
            output.write(""+(scr-20));
            output.newLine();
            output.close();
        }catch (Exception e){}
        
    }
    
    //Unavailable U=new Unavailable();
    
    public void Confirmation()
    {
        
        getWorld().addObject(CF,925,400);
        getWorld().addObject(B,925,250);
        getWorld().addObject(BConf, 925,350);
        if(this_one==2) 
        getWorld().addObject(A,900,450);
        if(this_one==1)
        getWorld().addObject(AC,900,425);
        if(this_one<2&&(sn<20||scr<20))
        getWorld().addObject(U,900,450);
        //getWorld().addObject(U,900,450);
        getWorld().addObject(Yes,800,500);
        getWorld().addObject(Msg[0],800,500);
        getWorld().addObject(No,1000,500);
        getWorld().addObject(Msg[1],1000,500);
    }
    
    public void Choice_Done()
    {
        if(this_one<2&&sn>=20&&scr>=20)
        if(Greenfoot.mouseClicked(Yes)||Greenfoot.mouseClicked(Msg[0]))
        {
            upgrade = false;
            Write();
            //getWorld().removeObject(U);
            //if(this_one==1)
        getWorld().removeObject(AC);
            getWorld().removeObject(CF);
            getWorld().removeObject(B);
            getWorld().removeObject(BConf);
            getWorld().removeObject(Yes);
            getWorld().removeObject(No);
            getWorld().removeObject(Msg[0]);
            getWorld().removeObject(Msg[1]);
        }
        
        if(Greenfoot.mouseClicked(No)||Greenfoot.mouseClicked(Msg[1]))
        {
            upgrade = false;
            if(this_one==2) 
        getWorld().removeObject(A);
        if(this_one<2&&(sn<20||scr<20))
        getWorld().removeObject(U);
        if(this_one==1)
        getWorld().removeObject(AC);
            //getWorld().removeObject(U);
            getWorld().removeObject(CF);
            getWorld().removeObject(B);
            getWorld().removeObject(BConf);
            getWorld().removeObject(Yes);
            getWorld().removeObject(No);
            getWorld().removeObject(Msg[0]);
            getWorld().removeObject(Msg[1]);
        }
    }
}
