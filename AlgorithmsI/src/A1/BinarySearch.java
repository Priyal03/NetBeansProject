/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package A1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Priyal
 */
public class BinarySearch 
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int N=5;
         int key=Integer.parseInt(in.readLine());                    
        PrintWriter out = new PrintWriter(System.out);
        int a[]=new int[N];
        String sd[]=in.readLine().split(" ");
        for(int i=0;i<N;i++)
        {
            a[i]= Integer.parseInt(sd[i]);
        }
        int mid=0;
        int lo=0, hi=a.length-1;
        for(;lo<=hi;)
        {
            mid=lo+(hi-lo)/2;
            out.println(mid);
            if(key<a[mid])
                hi=mid-1;
            else if(key>a[mid])
                lo=mid+1;            
            else if(mid==key)
            {                
                break;
            } 
            
        }
        //out.print(mid);
    }
}