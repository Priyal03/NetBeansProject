/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package may;

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
class Utopian 
{   
    public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
        try (PrintWriter out = new PrintWriter(outputStream)) {
            tree m = new tree();
            m.make(in, out);
        }
	}
}
class tree
{
    void make(InputReader in, PrintWriter out)
    {               
        int t=in.nextInt();
        for(int l=0;l<t;l++)
        {               
                int n=in.nextInt();
                int sum=1;
                for(int i=1;i<=n;i++)
                {
                if(i%2==0)
                {
                    sum=sum+1;     
                }
                else
                {
                    sum=sum*2;
                }                
                }
                out.println(sum);
        }
    }
}
class InputReader {
    private final BufferedReader reader;
    private StringTokenizer tokenizer;
 
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
 
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
 
    public int nextInt() {
        return Integer.parseInt(next());
    }     
}