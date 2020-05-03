import greenfoot.*;  
import java.io.*;
import java.net.URL;

public class Level extends MenuElement
{
    String S;
    
    public Level(String S2)
    {
        S=S2;
    }
    
    public void act() 
    {
        Read(S);
         setImage(new GreenfootImage("Nivel: "+this_one,20,Color.BLACK,null));
    }    
    
    int this_one=0;
    
        public void Read(String S)
    {
        try
        {
            
            URL path = getClass().getClassLoader().getResource(S);
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            this_one=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
    }
}
