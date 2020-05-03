import greenfoot.*;  
import java.util.*;

public class Indications extends World
{


    BackSpace BackSpace = new BackSpace();
    BackButtonText BackButtonText= new BackButtonText("Înapoi spre Meniu");
    //Frame CF2= new Frame();
    
   boolean upgrade[]={false,false};
    
    Option O[]={new Option(),new Option()};
    ButtonText B[]={new ButtonText("Departamente"),new ButtonText("Competiție & Magazin")};
    
     public int h=getHeight();
     
     //OK OK=new OK();
     
     World W[]={new Departments(),new Competition_n_Store()};
     
     //IntroducingThePlayer ITP[]={new IntroducingThePlayer(new GreenfootImage("Departments.png")),new IntroducingThePlayer(new GreenfootImage("Departments.png")),new IntroducingThePlayer(new GreenfootImage("Departments.png"))};
    
    public Indications()
    {    
        super(1300, 800, 1); 
        GreenfootImage bg=new GreenfootImage("blue.jpg");
        bg.scale(getWidth(),getHeight());
        setBackground(bg);
        
        addObject(BackSpace,getWidth()-120,120);
        addObject(BackButtonText,getWidth()-245,95);
        
        int i=0;
        h=h-100;
        h=h/3;
        
        while(i<2)
        {
           addObject(O[i],getWidth()/2,h*(i+1)+50);
           addObject(B[i],getWidth()/2,h*(i+1)+50);
           i++;
        }
    
    }
    
    public void act()
    {
        int i;
        for(i=0; i<2; i++) 
        {
            
            if(((Greenfoot.mouseClicked(O[i])||Greenfoot.mouseClicked(B[i])))/*&&getObjects(OK.class).size()==0*/&&!upgrade[i])
            {
                upgrade[i]=true;
                GreenfootImage bg1= new GreenfootImage("anotherbluebutwithshadow.jpg");
                bg1.scale(900,100);
                O[i].setImage(bg1);
                int x=B[i].getX();
                int y=B[i].getY();
                B[i].setLocation(x-5,y-5);
                
                Greenfoot.delay(20);
                GreenfootImage bg2= new GreenfootImage("anotherblue.jpg");
                bg2.scale(900,100);
                O[i].setImage(bg2);
                B[i].setLocation(x,y);
                Greenfoot.setWorld(W[i]);
                //Check_this_out(i);
                
                
                //if(upgrade[i]) Choice_Done(i);
                
            }
            
            
            
        }
    }
    
    /*public void Check_this_out(int i)
    {
        addObject(CF2,getWidth()/2,getHeight()/2);
        addObject(ITP[i],getWidth()/2,getHeight()/2-25);
        addObject(OK,getWidth()/2,getHeight()/2+290);
    }
    
    public void Choice_Done(int i)
    {
        if(Greenfoot.mouseClicked(OK))
        {
            upgrade[i]=false;
            removeObject(OK);
            removeObject(ITP[i]);
            removeObject(CF2);
        }
    }*/
}
