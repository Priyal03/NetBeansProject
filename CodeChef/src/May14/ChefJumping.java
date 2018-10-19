/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package May14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Priyal
 */
class ChefJumping 
{
    public static void main(String[] args) 
    {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
                try (PrintWriter out = new PrintWriter(outputStream)) 
                {
                    chef m = new chef();
                    m.max(in, out);
                }
    }  
}
class chef
{
    void max(InputReader in, PrintWriter out)
    {
        int a=in.nextInt();        
        int sum=0;
        int b=(a/3)+(a%3);
        int n=Math.max(6-b, b-6);
        for(int i=0;i<n;i++)
        {
            if(sum!=a)        
                sum=sum+1;                    
            if(sum!=a)
                sum=sum+2;
            if(sum!=a)
                sum=sum+3;
        }        
        if(sum==a)        
            out.println("yes");            
        else
            out.println("no");
    }
}
/*class InputReader 
{
    private final BufferedReader reader;
    private StringTokenizer tokenizer;
 
    public InputReader(InputStream stream) 
    {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
 
    public String next() 
    {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) 
        {
            try 
            {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            catch (IOException e) 
            {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
 
    public int nextInt() 
    {
        return Integer.parseInt(next());
    }     
}*/