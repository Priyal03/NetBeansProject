/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Try;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Priyal
 */
public class TravellingChef 
{
    public static void main(String args[]) throws IOException
    {
        int t;  
        double tt[] =new double[3600];
        double ct[] =new double[3600];
   //     int cv[]=new int[3600];
        BufferedReader test=new BufferedReader(new InputStreamReader(System.in));
        t=Integer.parseInt(test.readLine());          
        for(int i=0;i<t;i++)
        {
           BufferedReader time=new BufferedReader(new InputStreamReader(System.in));         
           //String[] sd;
           tt[i]=Integer.parseInt(time.readLine());
           int x=(int) (tt[i]/4);
           for(int j=0;j<tt[i];j=j+x)
           {
               BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
               String sd=input.readLine();//.split( " " );
               ct[j]=Integer.parseInt(sd);
           }                  
        }               
    }
}
