/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Stanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Priyal
 */
public class Invertions 
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int a[]=new int[100000];
        for(int i=0;i<100000;i++)
        {
            a[i]=Integer.parseInt(in.readLine());
        }
    }
}
