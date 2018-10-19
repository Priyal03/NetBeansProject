/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Try;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Priyal
 */
class Sweets 
{
    public static void main(String args[]) throws IOException
    {           
        int t,sum=0,bank,sweet;  
        BufferedReader test=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(test.readLine());   
        
        while(t-->0)
        {
            BufferedReader te=new BufferedReader(new InputStreamReader(System.in));
            String sd[]=te.readLine().split( " " );
               bank=Integer.parseInt(sd[0]);               
               sweet=Integer.parseInt(sd[1]);
               int notes[]= new int[bank];
               System.out.print("asgdhkjhgkjhfkgja-------------"+bank);
               for(int k=0;k<bank;k++)
               {
                   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                   String[] s=br.readLine().split( " " );
                   notes[k]=Integer.parseInt(s[k]);
                   sum=sum+notes[k];                   
               }
               System.out.println(sum);
           }                          
        }
    }