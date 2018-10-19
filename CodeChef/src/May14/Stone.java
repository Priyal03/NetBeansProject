package May14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class Stone 
{
    public static void main(String[] args) 
    {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
                try (PrintWriter out = new PrintWriter(outputStream)) 
                {
                    stonesolver m = new stonesolver();
                    m.max(in, out);
                }
    }    
}
class stonesolver
{
    void max(InputReader in, PrintWriter out)
    {
        int n=in.nextInt();
        int k=in.nextInt();
        int a[]=new int[n];       
        for(int i=0;i<n;i++)
        {
            a[i]=in.nextInt();        
        }        
        for(int j=0;j<k;j++)
        {
            int largest=a[0]; 
            for(int x=0; x<n; x++)
            { 
                if(a[x]>largest)
                { 
                    largest = a[x]; 
                }
            }
            for(int x=0;x<n;x++)
            {
                a[x]=largest-a[x];                  
            }
        }
        for(int x=0;x<n;x++)
        {
            out.print(a[x]+" ");
        }        
     }
}
class InputReader 
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
}