import greenfoot.*;  
import java.io.*;
import java.net.URL;

public class CurrentScore extends Playground
{
    int score=0;
    boolean ok=true;
    int r=0;
    public static int highscore;
    
    public CurrentScore()
   {
       
       setImage(new GreenfootImage("Scor: "+score,35,Color.WHITE,Color.BLACK));
       
    }

    public void act() 
    {
        setImage(new GreenfootImage("Scor: "+(score*5+r%5),35,Color.WHITE,Color.BLACK));
        r=getWorld().getObjects(Tower.class).size();
        if(getWorld().getObjects(Tower.class).size()==5&&ok) {score++; ok=false;}
        if(getWorld().getObjects(Tower.class).size()==0&&!ok) ok=true;
        ReadScore();
        if(this_one<score*5+r%5)
        SaveScore();
    }    
    
    public void SaveScore()
    {
        try
        {
            BufferedWriter output=new BufferedWriter(new FileWriter("Score.txt"));
            output.flush();
            output.write(""+(score*5+r%5));
            output.newLine();
            output.close();
        }catch (Exception e){}
        
        
    }
    
    int this_one;
    
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
    
}
