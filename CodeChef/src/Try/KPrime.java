package Try;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;

/**
 *
 * @author Priyal
 */
public class KPrime 
{
    public static void main(String args[]) throws IOException
    {
        int a[]=new int[1000];
        int b[]=new int[1000];
        int k[]=new int[1000];
        
            BufferedReader test=new BufferedReader(new InputStreamReader(System.in));
            int t=Integer.parseInt(test.readLine());
            for(int i=0;i<t;i++)
            {
                String sd[]=test.readLine().split( " " );
                a[i]=Integer.parseInt(sd[0]);
                b[i]=Integer.parseInt(sd[1]);
                k[i]=Integer.parseInt(sd[2]);           
            }
            for(int i=0;i<t;i++)
            {System.out.write(b[i]);
            K_Prime(a,b,k,i);
            }
        }    
    public static void K_Prime(int[] a, int[] b, int[] k,int i) 
    {
        System.out.write(b[i]);
        for(int x=2;x<b[i]/2;x++)
        {
            out.println(b[i]);
        }
    }
}