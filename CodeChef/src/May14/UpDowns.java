/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package May14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;

/**
 *
 * @author Priyal
 */
public class UpDowns 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        
        
        while(t-->0)
        {
            int N=Integer.parseInt(in.readLine());
            String sd[]=in.readLine().split(" ");
            int a[]=new int[N];
            int b[]=new int[N];
            for(int i=0;i<N;i++)
            {
                a[i]=Integer.parseInt(sd[i]);   
            }
            for(int i=0;i<N;i++)
            {
                if(i%2==0)
                {
                    if( a[i]<=a[i+1]) 
                    {
                        b[i]=a[i];
                        b[i+1]=a[i+1];
                    }
                    else
                        break;
                }
                else
                {
                    if(a[i]>=a[i+1])
                    {
                        b[i]=a[i];
                        b[i+1]=a[i+1];
                    }
                    else
                        break;
                }
            }
            for(int i=0;i<N;i++)
            {
                out.print(b[i]);
        }
    }
}
}