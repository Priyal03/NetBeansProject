package Try;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class GOT 
{
    public static void main(String args[]) throws IOException
    {
        int t;  
        double l[] =new double[1000];
        double b[] =new double[1000];
        BufferedReader test=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(test.readLine());          
        for(int i=0;i<t;i++)
        {          
           StringTokenizer stringTokenizer = new StringTokenizer(test.readLine());
           b[i]=Integer.parseInt(stringTokenizer.nextToken());   
           l[i]=b[i];
        }   
        for(int i=0;i<t;i++)      
        {
            if(b[i+1]>b[i])
            {
                
            }
            else
            {
                
            }
        }
        
    }
    
}
