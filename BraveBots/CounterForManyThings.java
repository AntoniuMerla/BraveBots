import greenfoot.*; 
import java.io.*;
import java.net.URL; 

public class CounterForManyThings extends Actor
{

    String s1,s2;
    public CounterForManyThings(String Text,String Text2) 
    {
        int x=0;
        s1=Text;
        s2=Text2;
    } 
    
    public void act()
    {
        setImage(new GreenfootImage(s1+this_one,20,Color.WHITE,null));
        try
        {
            URL path = getClass().getClassLoader().getResource(s2);
            InputStream stream=path.openStream();
            BufferedReader input=new BufferedReader(new InputStreamReader(stream));
            this_one=Integer.parseInt(input.readLine());
            input.close();
        }catch (Exception e) {}
    }
    
    int this_one;
    
}
