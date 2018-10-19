package Try;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class SnapeLadder
{
    public static void main(String args[]) throws IOException
    {         
        BufferedReader test=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(test.readLine());          
        for(int i=0;i<t;i++)
        {          
           String[] sd=test.readLine().split( " " );                   
             int l = Integer.parseInt(sd[0]);
             int b = Integer.parseInt(sd[1]);                          
            double rl =Math.sqrt(Math.max((l*l)-(b*b),(b*b)-(l*l)));
            double rm=Math.sqrt((l*l)+(b*b));
            System.out.println(rl+" "+rm);       
        }
    }
}