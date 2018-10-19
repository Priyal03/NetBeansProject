/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package May14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Priyal
 */
public class SubStringsFrequency {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        
        
        while(t-->0)
        {
            String s=in.readLine();   
            char c[]=new char[s.length()];
            for(int i=0;i<s.length();i++)
            {
                c[i]=s.charAt(i);
            }
            int n=Integer.parseInt(in.readLine());         
            int f[]=new int[n];
            for(int i=0;i<n;i++)
            {
                f[i]=Integer.parseInt(in.readLine());
                if(f[i]<=s.length()/2)
                {                                                                                   
                   // if(c[i]==c[0])   
                        
                }
            }
            
            int b[]=new int[n];
        }
    }
    
}
