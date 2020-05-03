import greenfoot.*; 
import java.io.*;
import java.net.URL; 

public class BuyDS extends Items
{
    public BuyDS()
    {
        GreenfootImage img=getImage();
        img.scale(75,200);
        turn(-20);
        setImage(img);
    }
    
    ButtonText B=new ButtonText("Sabia lui Dinu");
    ConfirmationFrame CF= new ConfirmationFrame();
    ButtonText BConf=new ButtonText("Descriere: Sătul(ă) de StormTroopers? \n Elimină-i din joc!!! \n (Dinu nu mai confecționează săbii, așa că sunt rare. Una poate fi folosită pe meci.) \n Ofertă așteptată: 21 Contracte, 50 Popularitate (reclamă mai bună, mai multă marfă vândută) \n Restricții: Proiectare - Actualizați totul la nivelul II. \n Construcție - Actualizați totul la nivelul I. \n Interesat(ă)???");
    Yes Yes= new Yes();
    No No = new No();
    ButtonText Msg[]={new ButtonText("DA"), new ButtonText("NU")};
    
    BackSpace BackSpace=new BackSpace();
    BackButtonText BackButtonText= new BackButtonText("Înapoi spre Meniu");
    
    private boolean upgrade = false;
    
    Already A=new Already();
    
    Unavailable2 U=new Unavailable2();
    
    public void act() 
    {
        GreenfootImage IBC=BConf.getImage();
        IBC.scale(500,175);
        BConf.setImage(IBC);
        
        Read();
        
        if(Greenfoot.mouseClicked(this)&&!upgrade)
            {
                upgrade = true;
                Confirmation();
                
            }
            
            Choice_Done();
    }    
    
    public int this_one=0;
    public int contr=0;
    public int pop=0;
    
    public int drill=0;
    public int scrtime=0;
    
    public int ma=0;
    public int wt=0;
    
    public void Read0()
    {
                try
        {
            URL path = getClass().getClassLoader().getResource("DrillAcc.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            drill=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("ScrTime.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            scrtime=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
                try
        {
            URL path = getClass().getClassLoader().getResource("MeasAcc.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            ma=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("WkTime.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            wt=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
    }
    
    public void Read()
    {
        Read0();
        
        try
        {
            URL path = getClass().getClassLoader().getResource("BoughtDS.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            this_one=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Contracts.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            contr=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Popularity.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            pop=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
    }
    
    public void Write()
    {
        
       try
        {
            BufferedWriter output=new BufferedWriter(new FileWriter("BoughtDS.txt"));
            output.flush();
            output.write(""+1);
            output.newLine();
            output.close();
        }catch (Exception e){}
        
        try
        {
            BufferedWriter output=new BufferedWriter(new FileWriter("Contracts.txt"));
            output.flush();
            output.write(""+(contr-21));
            output.newLine();
            output.close();
        }catch (Exception e){}
        
        try
        {
            BufferedWriter output=new BufferedWriter(new FileWriter("Popularity.txt"));
            output.flush();
            output.write(""+(pop-50));
            output.newLine();
            output.close();
        }catch (Exception e){}
        
    }
    
    public void Confirmation()
    {
        getWorld().addObject(CF,925,400);
        getWorld().addObject(B,925,250);
        getWorld().addObject(BConf, 925,350);
        if(this_one==1) 
        getWorld().addObject(A,900,450);
        if(this_one==0&&(contr<21||pop<50||drill<1||scrtime<1||ma<2||wt<2))
        getWorld().addObject(U,900,450);
        getWorld().addObject(Yes,800,500);
        getWorld().addObject(Msg[0],800,500);
        getWorld().addObject(No,1000,500);
        getWorld().addObject(Msg[1],1000,500);
    }
    
    public void Choice_Done()
    {
        if(this_one==0&&contr>=21&&pop>=50&&drill>=1&&scrtime>=1&&ma==2&&wt==2)
        if(Greenfoot.mouseClicked(Yes)||Greenfoot.mouseClicked(Msg[0]))
        {
            upgrade = false;
            Write();
            //getWorld().removeObject(A);
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
            if(this_one==1)
            getWorld().removeObject(A);
            if(this_one==0&&(contr<21||pop<50||drill<1||scrtime<1||ma<2||wt<2))
            getWorld().removeObject(U);
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
