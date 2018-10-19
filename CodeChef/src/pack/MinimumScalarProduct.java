package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Priyal
 */
public class MinimumScalarProduct 
{
    public static void main(String args[] ) throws IOException
    {
        int t;
        int n[] =new int[1000];
        String s1,s2;
        int x[]=new int[8];
        int y[]=new int[8];
        
        String a[]=new String[32];
        String b[]=new String[32];   
        BufferedReader test=new BufferedReader(new InputStreamReader(System.in));
        s1=test.readLine();
        t=Integer.parseInt(s1);          
        for(int i=0;i<t;i++)
            {
           BufferedReader length=new BufferedReader(new InputStreamReader(System.in));
           s2=length.readLine();                         
           n[i]=Integer.parseInt(s2);   
           
           Input(a,n,x,i);
           Input(b,n,y,i);   
                        
           Sort(x,n,i);
           Sort(y,n,i);                                        
            }
            for(int i=0;i<t;i++)
                    {
           Product(x,y,i,n);   
            }
        
        
    }
    public static void Input(String a[],int n[],int x[],int j) throws IOException
    {
       BufferedReader xo=new BufferedReader(new InputStreamReader(System.in));                    
       String[] sd=xo.readLine().split( " " );       
           for(int i=0;i<n[j];i++)
           {
               x[i]= Integer.parseInt(sd[i]);
           }
        
    }        
    public static void Product(int x[],int y[],int test,int n[])
    {        
        int a=0;       
        for(int i=0;i<n[test];i++)
        {        
            int c[]=new int[8];
            c[i]=(x[i]*y[i]);            
            a=c[i]+a;            
        }
        System.out.println("CASE #"+test+":"+ a);
        
    }
    /**
     *
     * @param array
     * @param n1    
     * @param j    
     */
    public static void Sort(int array[],int n1[],int j)
    {
        int swap;
       
        for (int c = 0; c < ( n1[j] - 1 ); c++) 
        {
       
            for (int d = 0; d < n1[j] - c - 1; d++) 
            {
              
                if (array[d] > array[d+1]) 
                {
                   
                    swap       = array[d];
                    array[d]   = array[d+1];
                    array[d+1] = swap;
                }
                
            }
        }
        
    }
}
    
