import greenfoot.*;  
import java.io.*;
import java.net.URL;

public class HighScore extends MenuElement
{;
    int this_one;
    
    public void act() 
    {
        ReadScore();
        setImage(new GreenfootImage("Cel mai bun scor: "+this_one,35,Color.CYAN,Color.BLACK));
    }   
    
    public void ReadScore()
    {
        try
        {
            URL path = getClass().getClassLoader().getResource("Score.txt");
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            this_one=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
    }
    
    public HighScore()
    {   
    }
    
    
}
