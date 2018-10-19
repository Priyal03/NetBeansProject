/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pack;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.InputStream;
/**
 *
 * @author Priyal
 */
public class KSol 
{
    public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Algorithm maker = new Algorithm();
		maker.make(in, out);
		out.close();
	}
}
class Algorithm 
{
	boolean p[]=new boolean[100003];
	int a[]=new int[100003];
	public void make(InputReader in, PrintWriter out) 
	{
		Arrays.fill(p, true);
        for(int i=2;i<p.length;i++)
        {
            if(p[i])
            {
                a[i]++;
                for(int j=2;i*j<p.length;j++)
                {
                    p[i*j]=false;
                    a[i*j]++;
                }
            }
        }
        int table[][]=new int[6][p.length];
		for(int i=2;i<p.length;i++){
			for(int j=1;j<=5;j++){
				table[j][i]=table[j][i-1];
			}
			int x=a[i];
			if(x<=5 && x>=1){
				table[x][i]++;
			}
		}
        int t=in.nextInt();
        for(int l=0;l<t;l++)
		{
                int o=in.nextInt();
                int b=in.nextInt();
                int k=in.nextInt();
                int ctr=0;
                ctr=table[k][b]-table[k][o-1];
                out.println(ctr);
		}
	}
}
 
class InputReader {
    private BufferedReader reader;
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
