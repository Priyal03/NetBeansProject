/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package May14;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Stack;

/**
 *
 * @author Priyal
 */
public class Parser 
{
    public static void main(String[] args) 
    {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
                try (PrintWriter out = new PrintWriter(outputStream)) 
                {
                    compiler m = new compiler();
                    m.max(in, out);
                }
    }  
}

class compiler
{    
    public static int top=0;
    void max(InputReader in, PrintWriter out)
    {
        int t=in.nextInt();    
        String a[]=new String[100];
        int cnt=0;     
         Stack stack = new Stack();
        while(t-->0)
        {            
            a[t]=in.next();
            char arr[]=a[t].toCharArray();
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]=='<')
                {
                    stack.push(arr[i]);
                }
               
                if(arr[i]=='>')
                    stack.pop();
                
                if(cnt==0)
                     out.println(a[t]+"df"+cnt*2);
                break;
                }
                cnt=0;
            }
        }
}