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
public class CRCL
{    
    public static void main(String[] args) throws IOException 
    {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
	int n = Integer.parseInt(br.readLine());
	
	int p=-1;
	while (++p<n)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
		float b=Integer.parseInt(stringTokenizer.nextToken());
		float ls=Integer.parseInt(stringTokenizer.nextToken());
		double a=Math.sqrt(b*b+ls*ls);
		double ba;
		if(b>ls)
			ba=Math.sqrt(b*b-ls*ls);
		else
			ba=Math.sqrt(ls*ls-b*b);
		if(ba<a)
			System.out.println(ba+" "+a);
		else
			System.out.println(a+" "+ba);
	}
    }
}