/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package May14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.out;

/**
 *
 * @author Priyal
 */
public class CakeCut 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        
        
        while(t-->0)
        {
            int n=Integer.parseInt(in.readLine());
            if(360%n==0)
            {
                out.println("y");
            }
            else
            {
                out.println("n");
            }
        }
    }
}
