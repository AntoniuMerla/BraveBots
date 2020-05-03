import greenfoot.*;
import java.io.*;
import java.net.URL;  

public class ProgrammingMenu extends World
{
    Option O[]= {new Option(),new Option(),new Option()};
    ButtonText B[]={new ButtonText("Coduri"), new ButtonText("Algoritmi"), new ButtonText("Timp de remediere a problemelor")};
    ButtonText B2[]={new ButtonText("Coduri"), new ButtonText("Algoritmi"), new ButtonText("Timp de remediere a problemelor")};
    ConfirmationFrame CF= new ConfirmationFrame();
    ButtonText BConf=new ButtonText("Sigur doriți să actualizați:");
    ButtonText SÎ= new ButtonText("???");
    Yes Yes= new Yes();
    No No = new No();
    ButtonText Msg[]={new ButtonText("DA"), new ButtonText("NU")};
    BackSpace BackSpace = new BackSpace();
    BackButtonText BackButtonText= new BackButtonText("Înapoi spre Meniu");
    private boolean upgrade[] = {false,false,false};
    
    Resource R=new Resource(new GreenfootImage("xp.png"));
    ButtonText Number[]={new ButtonText("-25"),new ButtonText("-50")};
    Level L[]={new Level("Codes.txt"),new Level("Alg.txt"),new Level("PbTime.txt")};
    
    ButtonText Req=new ButtonText("Mai mult lucru în echipă! \n Cerințe: \n Lider: Actualizați totul la nivelul I. \n PR: Actualizați totul la nivelul I. ");
    
    public int h=getHeight();
    
    public ProgrammingMenu()
    {    
        super(1300, 800, 1); 
        GreenfootImage bg=new GreenfootImage("blue.jpg");
        bg.scale(getWidth(),getHeight());
        setBackground(bg); 
        
        h=h/3;
        h=h-60;
        int i=0;
        while(i<3)
        {
            addObject(O[i],getWidth()/2,h*(i+1)+25);
            addObject(B[i],getWidth()/2,h*(i+1)+25);
            addObject(L[i],getWidth()/2+400,h*(i+1)+50);
            i++;
        }
        addObject(BackSpace,getWidth()-120,120);
        addObject(BackButtonText,getWidth()-245,95);
    }
    
    public int codes=0;
    public int alg=0;
    public int pbtime=0;
    public int xp=0;
    public boolean checked=false;
    
    public void Read0()
    {
        int org=0;
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Organization.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            org=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        int ch=0;
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Charisma.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            ch=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        int com=0;
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Comunication.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            com=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        int mk=0;
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Marketing.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            mk=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        int sp=0;
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Sponsorship.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            sp=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        if(sp>0&&mk>0&&com>0&&ch>0&&org>0) checked=true;
    }
    
        public void Read()
    {
        try
        {
            URL path = getClass().getClassLoader().getResource("Codes.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            codes=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Alg.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            alg=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("PbTime.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            pbtime=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Xp.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            xp=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
    }
    
    public int modifier=0;
    public int to_be_taken=0;
    
        public void Write0()
    {
         try
        {
           
            BufferedWriter output0=new BufferedWriter(new FileWriter("Codes.txt"));
            output0.flush();
            output0.write(""+(modifier+1));
            output0.newLine();
            output0.close();
        }catch (Exception e){}
    }
    
    public void Write1()
    {
         try
        {
           
            BufferedWriter output1=new BufferedWriter(new FileWriter("Alg.txt"));
            output1.flush();
            output1.write(""+(modifier+1));
            output1.newLine();
            output1.close();
        }catch (Exception e){}
    }
    
    public void Write2()
    {
         try
        {
           
            BufferedWriter output2=new BufferedWriter(new FileWriter("PbTime.txt"));
            output2.flush();
            output2.write(""+(modifier+1));
            output2.newLine();
            output2.close();
        }catch (Exception e){}
    }
    
        public void WriteXP()
    {
         try
        {
           
            BufferedWriter output2=new BufferedWriter(new FileWriter("Xp.txt"));
            output2.flush();
            output2.write(""+xp);
            output2.newLine();
            output2.close();
        }catch (Exception e){}
    }
    
        public void decide(int i)
    {
        if(i==0) 
        {
            addObject(Number[codes],getWidth()/2-17,getHeight()/2+75);
        }
        if(i==1) 
        {
            addObject(Number[alg],getWidth()/2-17,getHeight()/2+75);
        }
        if(i==2)
        {
            addObject(Number[pbtime],getWidth()/2-17,getHeight()/2+75);
        }
        
    }
    
        public void decide2(int i)
    {
        if(i==0) removeObject(Number[codes]);
        if(i==1) removeObject(Number[alg]);;
        if(i==2) removeObject(Number[pbtime]);
    }
    
    Checked CK[]={new Checked(),new Checked(),new Checked()};
    
    public void Locked()
    {
        addObject(CF,getWidth()/2,getHeight()/2);
        addObject(Req,getWidth()/2,getHeight()/2);
    }
    
   public void act()
   {
       Read0();
       if(checked)
       {Read();
        int i;
        for(i=0; i<3; i++)
        {
            if(i==0&&codes<2)
            {if((Greenfoot.mouseClicked(O[i])||Greenfoot.mouseClicked(B[i]))&&!upgrade[0])
            {
                upgrade[0]= true;
                GreenfootImage bg1= new GreenfootImage("anotherbluebutwithshadow.jpg");
                bg1.scale(900,100);
                O[i].setImage(bg1);
                int x=B[i].getX();
                int y=B[i].getY();
                B[i].setLocation(x-5,y-5);
                L[i].setLocation(L[i].getX()-5,L[i].getY()-5);
                
                Greenfoot.delay(20);
                Confirmation(i);
                
                GreenfootImage bg2= new GreenfootImage("anotherblue.jpg");
                bg2.scale(900,100);
                O[i].setImage(bg2);
                B[i].setLocation(x,y);
                L[i].setLocation(L[i].getX()+5,L[i].getY()+5);
            }
            
            if(upgrade[0]) Choice_Done(i);
        } 
        else if(codes==2) addObject(CK[0],250,h+25);
        if(i==1&&alg<2)
            {if((Greenfoot.mouseClicked(O[i])||Greenfoot.mouseClicked(B[i]))&&!upgrade[1])
            {
                upgrade[1]= true;
                GreenfootImage bg1= new GreenfootImage("anotherbluebutwithshadow.jpg");
                bg1.scale(900,100);
                O[i].setImage(bg1);
                int x=B[i].getX();
                int y=B[i].getY();
                B[i].setLocation(x-5,y-5);
                L[i].setLocation(L[i].getX()-5,L[i].getY()-5);
                
                Greenfoot.delay(20);
                Confirmation(i);
                
                GreenfootImage bg2= new GreenfootImage("anotherblue.jpg");
                bg2.scale(900,100);
                O[i].setImage(bg2);
                B[i].setLocation(x,y);
                L[i].setLocation(L[i].getX()+5,L[i].getY()+5);
            }
            
            if(upgrade[1]) Choice_Done(i);
        }
        else if(alg==2) addObject(CK[1],250,h*2+25);
        if(i==2&&pbtime<2)
            {if((Greenfoot.mouseClicked(O[i])||Greenfoot.mouseClicked(B[i]))&&!upgrade[2])
            {
                upgrade[2]= true;
                GreenfootImage bg1= new GreenfootImage("anotherbluebutwithshadow.jpg");
                bg1.scale(900,100);
                O[i].setImage(bg1);
                int x=B[i].getX();
                int y=B[i].getY();
                B[i].setLocation(x-5,y-5);
                L[i].setLocation(L[i].getX()-5,L[i].getY()-5);
                
                Greenfoot.delay(20);
                Confirmation(i);
                
                GreenfootImage bg2= new GreenfootImage("anotherblue.jpg");
                bg2.scale(900,100);
                O[i].setImage(bg2);
                B[i].setLocation(x,y);
                L[i].setLocation(L[i].getX()+5,L[i].getY()+5);
            }
            
            if(upgrade[2]) Choice_Done(i);
        }
        else if(pbtime==2) addObject(CK[2],250,h*3+25);
        }
        }
        else Locked();
    }
    
    
    Unavailable U=new Unavailable();
    
    public void Confirmation(int i)
    {
        addObject(CF,getWidth()/2,getHeight()/2);
        addObject(B2[i],getWidth()/2, getHeight()/2-30);
        addObject(SÎ,getWidth()/2,getHeight()/2+30);
        addObject(BConf, getWidth()/2, getHeight()/2-100);
        addObject(Yes,getWidth()/2-150,getHeight()/2+100);
        addObject(Msg[0],getWidth()/2-150,getHeight()/2+100);
        addObject(No,getWidth()/2+150,getHeight()/2+97);
        addObject(Msg[1],getWidth()/2+150,getHeight()/2+97);
        addObject(R,getWidth()/2+17,getHeight()/2+75);
        decide(i);
    }
    
    public void Choice_Done(int i)
    {
        if(i==0) modifier=codes;
        if(i==1) modifier=alg;
        if(i==2) modifier=pbtime;
        if(modifier==0) to_be_taken=25;
        else to_be_taken=50;
        if(xp>=to_be_taken)  
        {
            if(Greenfoot.mouseClicked(Yes)||Greenfoot.mouseClicked(Msg[0]))
        {
            xp=xp-to_be_taken;
            if(i==0) Write0();
            if(i==1) Write1();
            if(i==2) Write2();
            WriteXP();
            upgrade[i] = false;
            removeObject(R);
            decide2(i);
            removeObject(CF);
            removeObject(B2[i]);
            removeObject(SÎ);
            removeObject(BConf);
            removeObject(Yes);
            removeObject(No);
            removeObject(Msg[0]);
            removeObject(Msg[1]);
        }
        
        if(Greenfoot.mouseClicked(No)||Greenfoot.mouseClicked(Msg[1]))
        {
            upgrade[i] = false;
            removeObject(R);
            decide2(i);
            removeObject(CF);
            removeObject(B2[i]);
            removeObject(SÎ);
            removeObject(BConf);
            removeObject(Yes);
            removeObject(No);
            removeObject(Msg[0]);
            removeObject(Msg[1]);
        }
    }
    else 
    {
        addObject(U,getWidth()/2,getHeight()/2+150);
        
        if(Greenfoot.mouseClicked(No)||Greenfoot.mouseClicked(Msg[1]))
        {
            upgrade[i]= false;
            removeObject(R);
            removeObject(U);
            decide2(i);
            removeObject(CF);
            removeObject(B2[i]);
            removeObject(SÎ);
            removeObject(BConf);
            removeObject(Yes);
            removeObject(No);
            removeObject(Msg[0]);
            removeObject(Msg[1]);
        }
    }
    }
}

