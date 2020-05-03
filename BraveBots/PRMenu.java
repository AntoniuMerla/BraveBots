import greenfoot.*;  
import java.io.*;
import java.net.URL;

public class PRMenu extends World
{
    Option O[]={new Option(), new Option()};
    ButtonText B[]= {new ButtonText("Marketing"), new ButtonText("Sponsorizări")};
  
    ButtonText B2[]= {new ButtonText("Marketing"), new ButtonText("Sponsorizări")};
    ConfirmationFrame CF= new ConfirmationFrame();
    ButtonText BConf=new ButtonText("Sigur doriți să actualizați:");
    ButtonText SÎ= new ButtonText("???");
    Yes Yes= new Yes();
    No No = new No();
    ButtonText Msg[]={new ButtonText("DA"), new ButtonText("NU")};
    
    BackSpace BackSpace = new BackSpace();
    BackButtonText BackButtonText= new BackButtonText("Înapoi spre Meniu");
    private boolean upgrade[] = {false,false};
    Resource R=new Resource(new GreenfootImage("xp.png"));
    ButtonText Number[]={new ButtonText("-25"),new ButtonText("-50")};
    Level L[]={new Level("Marketing.txt"),new Level("Sponsorship.txt")};
    
    public PRMenu()
    {    
        super(1300, 800, 1); 
        GreenfootImage bg=new GreenfootImage("blue.jpg");
        bg.scale(getWidth(),getHeight());
        setBackground(bg);
        
        addObject(O[0],getWidth()/2,getHeight()/2-100);
        addObject(O[1],getWidth()/2,getHeight()/2+100);
        addObject(B[0],getWidth()/2,getHeight()/2-100);
        addObject(B[1],getWidth()/2,getHeight()/2+100);
        addObject(L[0],getWidth()/2+400,getHeight()/2-70);
        addObject(L[1],getWidth()/2+400,getHeight()/2+130);
        
        addObject(BackSpace,getWidth()-125,125);
        addObject(BackButtonText,getWidth()-250,100);
    }
    
    public int xp=0;
    public int mk=0;
    public int sp=0;
    
        public void Read()
    {
        try
        {
            URL path = getClass().getClassLoader().getResource("Marketing.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            mk=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Sponsorship.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            sp=Integer.parseInt(input.readLine());
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
           
            BufferedWriter output0=new BufferedWriter(new FileWriter("Marketing.txt"));
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
           
            BufferedWriter output1=new BufferedWriter(new FileWriter("Sponsorship.txt"));
            output1.flush();
            output1.write(""+(modifier+1));
            output1.newLine();
            output1.close();
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
            addObject(Number[mk],getWidth()/2-17,getHeight()/2+75);
        }
        if(i==1) 
        {
            addObject(Number[sp],getWidth()/2-17,getHeight()/2+75);
        }
    }
    
        public void decide2(int i)
    {
        if(i==0) removeObject(Number[mk]);
        if(i==1) removeObject(Number[sp]);;
    }
    
    public void act()
   {
       Read();
        int i;
        
        for(i=0; i<2; i++)
        {
            if(i==0&&mk<2)
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
            
            if(upgrade[0]) Choice_Done(i);}
            else if(mk==2) addObject(CK[0],250,getHeight()/2-100);
            
            if(i==1&&sp<2)
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
            
            if(upgrade[1]) Choice_Done(i);}
            else if(sp==2) addObject(CK[1],250,getHeight()/2+100);
        }
    }
    
    Checked CK[]={new Checked(),new Checked()};
    
    Unavailable U=new Unavailable();
    
    public void Confirmation(int i)
    {
        addObject(CF,getWidth()/2,getHeight()/2);
        addObject(B2[i],getWidth()/2, getHeight()/2-30);
        addObject(SÎ,getWidth()/2,getHeight()/2+30);
       // addObject(U,getWidth()/2,getHeight()/2+75);
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
        if(i==0) modifier=mk;
        if(i==1) modifier=sp;
        if(modifier==0) to_be_taken=25;
        else to_be_taken=50;
        
      if(xp>=to_be_taken)  
        {
            if(Greenfoot.mouseClicked(Yes)||Greenfoot.mouseClicked(Msg[0]))
        {
            //Write(i);
            xp=xp-to_be_taken;
            if(i==0) Write0();
            if(i==1) Write1();
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
            decide2(i);
            removeObject(U);
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
