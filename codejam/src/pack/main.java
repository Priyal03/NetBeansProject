package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main
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
           String[] sd=test.readLine().split( " " );                   
            l[i]=Integer.parseInt(sd[0]);
            b[i]=Integer.parseInt(sd[1]);         
        }   
        for(int i=0;i<t;i++)      
           Lower(l,b,i);
    }
    public static void Lower(double l[],double b[],int i)
    {
       double rl[] =new double[1000];
       double rm[] =new double[1000];
       rl[i]=Math.sqrt(Math.max((l[i]*l[i])-(b[i]*b[i]),(b[i]*b[i])-(l[i]*l[i])));
       rm[i]=Math.sqrt((l[i]*l[i])+(b[i]*b[i]));
       System.out.println(rl[i]+" "+rm[i]);       
   }
}