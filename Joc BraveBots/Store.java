import greenfoot.*; 
import java.io.*;
import java.net.URL;


public class Store extends World
{
    BackSpace BS=new BackSpace();
    BuyGelu G=new BuyGelu();
    BuyDS DS=new BuyDS();
    Armor A[]={new Armor(),new Armor()};
    BackButtonText BackButtonText= new BackButtonText("Înapoi spre Meniu");
    BlackSquare BSQ=new BlackSquare();
    ConfirmationFrame CF=new ConfirmationFrame();
    
    ButtonText Req=new ButtonText("Nu te-a învățat nimeni să folosești \n antivirus pe laptop? \n Noroc că e doar piața neagră online! \n Cerințe: \n Programare: Actualizați totul la nivelul II.");
    
    public boolean checked=false;
    
    public Store()
    {    
        super(1300, 800, 1); 
        GreenfootImage img=new GreenfootImage("frog.jpg");
        img.scale(1300,800);
        setBackground(img);
        addObject(BS,getWidth()-125,125);
        addObject(BSQ,getWidth()-250,100);
        addObject(BackButtonText,getWidth()-250,100);
        
    }
    
        public void Read0()
    {
        int codes=0;
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Codes.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            codes=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        int alg=0;
        
        try
        {
            URL path = getClass().getClassLoader().getResource("Alg.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            alg=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        int pbtime=0;
        
        try
        {
            URL path = getClass().getClassLoader().getResource("PbTime.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            pbtime=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
        
        if(codes>1&&alg>1&&pbtime>1) checked=true;
    }
    
        public void Locked()
    {
        addObject(CF,getWidth()/2,getHeight()/2);
        addObject(Req,getWidth()/2,getHeight()/2);
    }
    
    public void act()
    {
        Read0();
        if(checked)
        {
        addObject(G,259,418);
        addObject(DS,392,383);
        addObject(A[0],251,602);
        addObject(A[1],343,561);
        }
        else Locked();
        
    }
}
