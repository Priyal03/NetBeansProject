/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Stanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;

/**
 *
 * @author Priyal
 */
public class SmallInvertions 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int a[]=new int[6];
        int count = 0;
        for(int j=0;j<6;j++)
        {
            a[j]=Integer.parseInt(in.readLine());
        }
        int x=0;
        int i=0;
        while(i<6)
        {      
            if(a[i]==i)
            {
                        i++;
            }
            else
            {
                if(a[i]<i)
                {
                   // 
                x=i-a[i];
                i=i-x;
                a[i]=a[i+x];
                count++;
                }
                else
                
                if(a[i]>i)
                {
                    //out.print(a[i]);
                    x=a[i]-i;
                    i=i+x;
                    a[i]=a[i-x];
                    count++;
                }
            }
              
                    
        }
        out.println(count);
    }

}
